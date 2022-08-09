package sos.eu.configuration.slalogging;

import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.arc.Priority;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@SLAObserved
@Interceptor
@Priority(10000)
/**
 *
 */
public class SLARuleInterceptor {

    private final MeterRegistry registry;
    private Map<String, SLAChecker> slaCheckerMap = new HashMap<>();

    public SLARuleInterceptor(MeterRegistry registry) {
        this.registry = registry;

    }

    @AroundInvoke
    public Object manageSLARule(InvocationContext invocationContext) throws Exception {
        Object returnValue = invocationContext.proceed();
        SLARule slaRule = invocationContext.getMethod().getAnnotation(SLARule.class);
        SLAChecker slaChecker = getSLAChecker(slaRule.slaChecker());
        if (slaChecker.fulfillsSLA(returnValue)) {
            registry.counter(slaRule.slaName() + "_success").increment();
        } else {
            registry.counter(slaRule.slaName() + "_failed").increment();
        }
        return returnValue;
    }

    private SLAChecker getSLAChecker(Class<? extends SLAChecker> slaCheckerClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String slaClassName = slaCheckerClass.getCanonicalName();
        if (slaClassName == null || slaClassName.isEmpty()) {
            throw new IllegalArgumentException("Cannot pass empty or null value to fetch an SLA Checker");
        }
        if (slaCheckerMap.containsKey(slaClassName)) {
            return slaCheckerMap.get(slaClassName);
        }
        Constructor<? extends SLAChecker> slaCheckerConstructor = slaCheckerClass.getConstructor();
        SLAChecker slaChecker = slaCheckerConstructor.newInstance();
        slaCheckerMap.put(slaClassName, slaChecker);
        return slaChecker;

    }

}
