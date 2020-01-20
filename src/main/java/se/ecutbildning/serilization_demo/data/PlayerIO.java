package se.ecutbildning.serilization_demo.data;

import se.ecutbildning.serilization_demo.model.PlayerCharacter;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PlayerIO {

    public static void serialize(List<PlayerCharacter> source, Path path){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path.toFile()))){
           out.writeObject(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<PlayerCharacter> deserialize(Path path){
        List<PlayerCharacter> characters= new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toFile()))){

            characters = (List<PlayerCharacter>) in.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
