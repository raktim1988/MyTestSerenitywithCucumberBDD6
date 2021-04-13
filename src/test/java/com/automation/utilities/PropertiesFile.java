package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Author:Raktim Biswas
 * Purpose : This is to read the properties files for any configuration needed for the project
 */
public class PropertiesFile {


    public static Properties readPropertiesFile() {
        Properties properties = null;
        try {
            File file = new File("Data\\Input.properties");
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}
