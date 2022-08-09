package sos.eu.configuration.audit;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Audited
@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
public @interface AuditLog {
    String getAudittedAction() default "None";
}
