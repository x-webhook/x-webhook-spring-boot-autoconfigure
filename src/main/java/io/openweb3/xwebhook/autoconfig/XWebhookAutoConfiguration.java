package io.openweb3.xwebhook.autoconfig;


import io.openweb3.xwebhook.XWebhookProperties;
import io.openweb3.xwebhook.Xwebhook;
import io.openweb3.xwebhook.XwebhookOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.lang.invoke.MethodHandles;

@AutoConfiguration
@EnableConfigurationProperties({XWebhookProperties.class})
public class XWebhookAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final XWebhookProperties properties;

    public XWebhookAutoConfiguration(XWebhookProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public Xwebhook xwebhook() {
        var options = new XwebhookOptions();

        if (properties.getServerUrl() != null) {
            options.serverUrl(properties.getServerUrl());
        }

        return new Xwebhook(properties.getToken(), options);
    }
}
