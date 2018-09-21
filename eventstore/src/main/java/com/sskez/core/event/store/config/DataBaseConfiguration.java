package com.sskez.core.event.store.config;

import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableConfigurationProperties(ConfigurationProperties.class)
public class DataBaseConfiguration extends AbstractMongoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DataBaseConfiguration.class);

    @Autowired
    private ConfigurationProperties configuration;

    @Override
    protected String getDatabaseName() {
        log.info("Database Name [WEBTRACe]");
        return "WEBTRACE";
    }

    @Override
    public MongoClient mongoClient()   {
        log.info("Entering method [mongoClient]");
        basicValidation();
        log.info("Configuration : [" + configuration + "] Database : [" + configuration.getDatabase() +  "] Host : [" + configuration.getDatabase().getHost() + "] Port [" +configuration.getDatabase().getPort()+"]" );
        log.info("Exiting method [mongoClient]");
        return new MongoClient(configuration.getDatabase().getHost(), configuration.getDatabase().getPort());
    }

    private void basicValidation() {
        if(configuration == null)
            throw new RuntimeException(" Database Configuration is [null or undefined]");

        log.info("Configuration [" +configuration+"]");

        if(configuration.getDatabase() == null)
            throw new RuntimeException(" Database Details is [null or undefined]");

        log.info("Database [" +configuration.getDatabase()+"]");

        if(configuration.getDatabase().getHost() == null)
            throw new RuntimeException(" Database Host is [null or undefined]");

        log.info("Database HOST [" +configuration.getDatabase().getHost()+"]");

        if(configuration.getDatabase().getPort() == null)
            throw new RuntimeException(" Database Port is [null or undefined]");

        log.info("Database PORT [" +configuration.getDatabase().getPort()+"]");

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        log.info("Entering method [mongoTemplate]");
        basicValidation();
        log.info("Configuration : [" + configuration + "] Database : [" + configuration.getDatabase() +  "] Host : [" + configuration.getDatabase().getHost() + "] Port [" +configuration.getDatabase().getPort()+"]" );
        log.info("Exiting method [mongoTemplate]");
        return new MongoTemplate(mongoClient(), configuration.getDatabase().getDatabase());
    }
}
