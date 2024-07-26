package io.openweb3.xwebhook;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "xwebhook")
public class XWebhookProperties {
    private String serverUrl;

    @NotEmpty
    private String token;

    public String getServerUrl() {
        return serverUrl;
    }

    public String getToken() {
        return token;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public XWebhookProperties() {}
}
