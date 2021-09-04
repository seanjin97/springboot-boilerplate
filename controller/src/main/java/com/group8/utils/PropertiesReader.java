package com.group8.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix="group8.springboottemplate.config")
@Configuration()
public class PropertiesReader {
    private String thirdPartyAPIUrl;

    public String getThirdPartyAPIUrl() {
        return thirdPartyAPIUrl;
    }

    public void setThirdPartyAPIUrl(String thirdPartyAPIUrl) {
        this.thirdPartyAPIUrl = thirdPartyAPIUrl;
    }
}
