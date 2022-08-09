package sos.eu.configuration.audit;

import io.micrometer.core.instrument.MeterRegistry;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Level;
import java.util.logging.Logger;

@Audited
@Interceptor
public class AuditLogIntercepter {

    @Named("auditId")
    @Inject
    public String auditId;

    private final MeterRegistry registry;

    public AuditLogIntercepter(MeterRegistry registry) {
        this.registry = registry;
    }

    @AroundInvoke
    public Object manageSLARule(InvocationContext invocationContext) throws Exception {
        AuditLog auditLog = invocationContext.getMethod().getAnnotation(AuditLog.class);
        String logStatement = "";
        logStatement = "AuditLog - " + auditId + " " + auditLog.getAudittedAction();
        Class<?> clazz = invocationContext.getMethod().getDeclaringClass();
        Object returnValue = invocationContext.proceed();
        logStatement = logStatement + " " + returnValue.toString();
        Logger.getLogger(clazz.getName()).log(Level.INFO, logStatement);
        return invocationContext.proceed();
    }

}
