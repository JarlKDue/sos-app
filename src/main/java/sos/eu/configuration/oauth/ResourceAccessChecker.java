package sos.eu.configuration.oauth;

public interface ResourceAccessChecker<AuthorizationParameters, Resource> {
    boolean isAccessToResourceLegal(AuthorizationParameters authorizationParameters, Resource resource);
}
