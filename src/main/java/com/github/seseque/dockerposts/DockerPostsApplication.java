package com.github.seseque.dockerposts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.github.seseque.dockerposts.config")
public class DockerPostsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerPostsApplication.class, args);
    }

}
