package it.adt.mvntestproject;


import it.adt.mvntestproject.service.service.ComparisonService;
import it.adt.mvntestproject.service.service.impl.ComparisonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ComparisonServiceImpl.class })
public class ComparisonApplication {
    final Logger logger = LoggerFactory.getLogger(ComparisonApplication.class);
    @Autowired
    private ComparisonService comparisonService;

    @Autowired
    @Qualifier("stringaRestituita")
    private String comparisonConfig;

    @Value("${my-properties.name}")
    private String name;


    public static void main(String[] args ) {
        SpringApplication.run(ComparisonApplication.class, args);

    }

    @Bean
    public Boolean initApp(){

        comparisonService.compareString(comparisonConfig, name);
        logger.info("Ho comparato le due stringhe");
        return true;
    }


}
