package it.adt;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Comparison {
    final static Logger logger = LogManager.getLogger(Comparison.class.getName());
    //private final static String nameCost = "Pippo";
    private String nameCost;

    public String getNameCost() {
        return nameCost;
    }

    public void setNameCost(String nameCost) {
        this.nameCost = nameCost;
    }

    public void compareString()  {
        try{
        PropertiesReader reader = new PropertiesReader("test.properties");
        String property = reader.getProperty("name");


            if (StringUtils.equals(nameCost, property)) {
                logger.info("Le stringhe sono uguali");
            } else {
                logger.info("Le stringhe sono differenti");
            }
        }catch(IOException e){
            logger.error("Exception Thrown: " + e);
        }
    }
}
