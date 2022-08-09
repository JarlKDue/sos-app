package sos.eu.configuration.audit;

import javax.inject.Named;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
public class AuditLogFilter implements ContainerRequestFilter {

    String auditId = "audit-id-not-set";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        MultivaluedMap<String, String> headerMap = containerRequestContext
                .getHeaders();

        if (headerMap == null) {
            throw new NullPointerException("Headermap was not present on the incoming request");
        }
        if (headerMap.containsKey("audit-header")) {
            List<String> auditIdHeaders = headerMap.get("audit-header");
            auditId = auditIdHeaders.stream().findFirst().orElse("no-audit-id-present");
        } else {
            auditId = "no-audit-id-present";
        }
    }






    @Named("auditId")
    public String auditId(){
        return auditId;
    }
}
