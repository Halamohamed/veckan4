package se.ecutbildning.data;

import java.io.*;
import java.util.Properties;

public class PropertyFileHandler {

    private static final File ID_PROPERTIES = new File("properties/id.properties");
    public static final String PERSON_ID = "person_id";

    public static void updateProperties(){
        Properties properties = new Properties();
        try (FileWriter writer = new FileWriter(ID_PROPERTIES)){
            if(!ID_PROPERTIES.exists()){
                ID_PROPERTIES.createNewFile();
            }
            properties.setProperty(PERSON_ID, Integer.valueOf(PersonSequencer.lastPersonId()).toString());
            properties.store(writer, "Latest id values");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initIdProperties(){
        Properties properties = new Properties();
        try (FileReader reader = new FileReader(ID_PROPERTIES)){
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PersonSequencer.setPersonId(Integer.parseInt(properties.getProperty(PERSON_ID)));
    }
}
