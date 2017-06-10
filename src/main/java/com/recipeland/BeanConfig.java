package com.recipeland;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableNeo4jRepositories(basePackages = "com.recipeland.repository")
@EnableTransactionManagement
public class BeanConfig {

    @Value("${neo4j.uri}")
    private String uri;
    @Value("${neo4j.user}")
    private String user;
    @Value("${neo4j.password}")
    private String password;

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
        org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();

        config
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .setURI(uri)
                .setCredentials(user,password);


        return config;
    }

}

