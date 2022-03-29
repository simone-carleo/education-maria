package it.adt;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@Configuration
@PropertySource(value="test.properties")
public class Comparison {
    final static Logger logger = LogManager.getLogger(Comparison.class.getName());
    private static String nameCost = "Pippo";
   // private String nameCost;
    @Value("${name}")
    private String name;

    public String getNameCost() {
        return nameCost;
    }
    public void setNameCost(String nameCost) {
        this.nameCost = nameCost;
    }
    public String getName() {
        return name;
    }


    public void compareString()  {
        //try{
        //PropertiesReader reader = new PropertiesReader("test.properties");
        //String property = reader.getProperty("name");


            if (StringUtils.equals(nameCost, name)) {
                logger.info("Le stringhe nameCost {} e name {} sono uguali", nameCost, name);
            } else {
                logger.info("Le stringhe nameCost {} e name {} sono differenti", nameCost, name);
            }
       //}catch(IOException e){
       //     logger.error("Exception Thrown: " , e);
       //}
    }
}
