package it.adt;


import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Hello world!
 *
 */

public class App {

    private final static String nameCost = "Pippo";

    public static void main( String[] args ) throws IOException {
        PropertiesReader reader = new PropertiesReader("test.properties");
        String property = reader.getProperty("name");


        if(StringUtils.equals(nameCost, property)){
            System.out.println("Le stringhe sono uguali");
        }else{
            System.out.println("Le stringhe sono differenti");
        }
      //  System.out.println( "Maven test!" );
    }


}
