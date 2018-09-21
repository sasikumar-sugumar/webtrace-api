package com.sskez.core.event.store.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;

@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "webtrace")
public class ConfigurationProperties {

    private static final Logger log = LoggerFactory.getLogger(ConfigurationProperties.class);


    private MongoProperties database = new MongoProperties();

    public MongoProperties getDatabase() {
        log.info("Database HOST [" + database.getHost()+"] PORT ["+ database.getPort()+"]");
        return database;
    }

    public void setDatabase(MongoProperties database) {
        log.info("Database HOST [" + database.getHost()+"] PORT ["+ database.getPort()+"]");
        this.database = database;
    }
}
