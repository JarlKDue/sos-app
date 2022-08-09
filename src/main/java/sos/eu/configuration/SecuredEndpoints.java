package sos.eu.configuration;

import io.smallrye.config.ConfigMapping;

import java.util.Set;

@ConfigMapping(prefix = "secured-endpoint")
public interface SecuredEndpoints {
    Set<SecuredEndpoint> securedEndpoints();

    interface SecuredEndpoint {
        String method();
        String path();
        String role();
    }
}
