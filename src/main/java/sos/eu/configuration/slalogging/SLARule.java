package sos.eu.configuration.slalogging;

import sos.eu.service.slas.EmptySlaChecker;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@SLAObserved
@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
public @interface SLARule {
    Class<? extends SLAChecker> slaChecker() default EmptySlaChecker.class;
    String slaName() default "Not Set";
}
