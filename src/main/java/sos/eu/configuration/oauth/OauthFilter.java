package sos.eu.configuration.oauth;

import io.quarkus.oidc.OidcConfigurationMetadata;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;
import sos.eu.configuration.SecuredEndpoints;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Optional;

@Provider
@ApplicationScoped
public class OauthFilter implements ContainerRequestFilter {

    @Inject
    OidcConfigurationMetadata configMetadata;

    @Inject
    JsonWebToken jwt;
    
    @Inject
    SecurityIdentity identity;

    @Inject
    SecuredEndpoints securedEndpoints;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        /**
        if(jwt == null){
            throw new NotAuthorizedException("Requests to this API requires a token");
        }
        String path = containerRequestContext.getUriInfo().getRequestUri().toString();
        Optional<SecuredEndpoints.SecuredEndpoint> endpoint = securedEndpoints.securedEndpoints().stream().findFirst().filter(securedEndpoint -> securedEndpoint.path().equals(path));
        Optional<Boolean> authorized = endpoint.filter(endpoint2 -> endpoint2.method().equals(containerRequestContext.getMethod())).map(endpoint2 -> jwt.getGroups().contains(endpoint2.role()));
        if(authorized.isPresent()){
            if(!authorized.get()){
                throw new NotAuthorizedException("No Access Granted 4 u!");
            }
        }
        if(jwt.getGroups().contains("Jarl")){
            throw new NotAuthorizedException("The provided token did not contain a valid role");
        }
        */
    }
}
