package com.github.seseque.dockerposts.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "services.users")
public class UserServiceProperties {

    public String origin;

}
