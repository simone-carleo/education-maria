package it.adt.mvntestproject.boot.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="test.properties")
public class ComparisonConfig {
    final static Logger logger = LoggerFactory.getLogger(ComparisonConfig.class);

    @Value("${name}")
    private String name;

    @Bean(name = "stringaRestituita")
    public String stringaRestituita(){
        return name;
    }
}
