package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    //1- create the object of Properties
    private static Properties properties= new Properties();

    static {


        try {
            //2- We need to open the file in java memory : FileInputStream
            FileInputStream file= new FileInputStream("configuration.properties");

            //3- Load the properties object using FileInputStream object
            properties.load(file);

            //CLOSE THE FILE !
            file.close();

        } catch (IOException e) {
            System.out.println("Something happened in the ConfigurationReader class.");
            e.printStackTrace();
        }


    }
    // 4- get the properties key  to return value  // IT IS OUR OWN UTILITY METHOD
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


}
