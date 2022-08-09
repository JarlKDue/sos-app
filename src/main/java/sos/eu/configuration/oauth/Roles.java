package sos.eu.configuration.oauth;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Secured
@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
public @interface Roles {
    String[] rolesAllowed();
}
