package sos.eu.configuration.oauth;

import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.arc.Priority;
import org.eclipse.microprofile.jwt.JsonWebToken;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.NotAuthorizedException;

@Secured
@Interceptor
@Priority(10000)
public class OAuthInterceptor {

    private final MeterRegistry registry;

    @Inject
    JsonWebToken jwt;

    public OAuthInterceptor(MeterRegistry registry) {
        this.registry = registry;

    }

    @AroundInvoke
    public Object checkAccess(InvocationContext invocationContext) throws Exception {

        isAccessLegal(invocationContext);
        Object returnValue = invocationContext.proceed();
        SecuredResource securedResource = invocationContext.getMethod().getAnnotation(SecuredResource.class);
        if(!(securedResource==null)){
           ResourceAccessChecker resourceAccessChecker = securedResource.resourceAccessChecker().getConstructor().newInstance();
           if(!resourceAccessChecker.isAccessToResourceLegal(jwt.getName(), returnValue)){
               throw new NotAuthorizedException("You do not have access to this specific resource");
           }
        }
        return returnValue;
    }

    private void isAccessLegal(InvocationContext invocationContext) {
        Roles roles = invocationContext.getMethod().getAnnotation(Roles.class);
        boolean legalAccess = false;
        if(!(roles == null)){
            legalAccess = false;
            String[] rolesAllowed = roles.rolesAllowed();
            if(rolesAllowed.length <= 0){
                throw new IllegalArgumentException("And endpoint was hit that declares itself protected, but has no roles listed");
            }
            for(String role : rolesAllowed){
                if(jwt.containsClaim(role)){
                    legalAccess = true;
                }
            }
        }
        if(!legalAccess){
            throw new NotAuthorizedException("You do not have access to the specified endpoint");
        }
    }
}
