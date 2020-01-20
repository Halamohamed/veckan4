package se.ecutbildning.serilization_demo;

import se.ecutbildning.serilization_demo.data.PlayerIO;
import se.ecutbildning.serilization_demo.data.PlayerStorage;
import se.ecutbildning.serilization_demo.model.PlayerCharacter;

import java.nio.file.Paths;

public class SerializationDemo {
    static PlayerStorage storage;
    static {
        storage = PlayerStorage.getInstance();
    }
    public static void main(String[] args) {

      /*
        storage.findByPlayerName("Claes").forEach(System.out::println);*/
      //storage.addCharacter(new PlayerCharacter("Loffe","Hans-Olof"));

      storage.findAll().forEach(System.out::println);


        PlayerIO.serialize(storage.findAll(), Paths.get("source/players.dat"));


    }
}
