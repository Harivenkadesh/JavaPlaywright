package org.example.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
public class ReadProperties {

    public static String getPropertyValue(String strKey) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(System.getProperty("user.dir") +"/src/main/resources/properties.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return (String) jsonObject.get(strKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}



