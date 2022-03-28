package it.adt;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class Comparison {
    //private final static String nameCost = "Pippo";
    private String nameCost;

    public String getNameCost() {
        return nameCost;
    }

    public void setNameCost(String nameCost) {
        this.nameCost = nameCost;
    }

    public void compareString() throws IOException {
        PropertiesReader reader = new PropertiesReader("test.properties");
        String property = reader.getProperty("name");


        if(StringUtils.equals(nameCost, property)){
            System.out.println("Le stringhe sono uguali");
        }else{
            System.out.println("Le stringhe sono differenti");
        }
    }
}
