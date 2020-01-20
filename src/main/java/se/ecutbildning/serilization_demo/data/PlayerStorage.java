package se.ecutbildning.serilization_demo.data;

import se.ecutbildning.serilization_demo.model.PlayerCharacter;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerStorage {
    //Only ONE instance that should be shared
    private static final PlayerStorage INSTANCE;

    //Körs så fort en metod anropas ENGÅNG!
    static {
        INSTANCE = new PlayerStorage();
    }

    public static PlayerStorage getInstance(){
        return INSTANCE;
    }

    private List<PlayerCharacter> characterList;

    private PlayerStorage(){
        characterList = PlayerIO.deserialize(Paths.get("source/players.dat"));
    }
    public Optional<PlayerCharacter> findById(String playerId){
        for(PlayerCharacter character : characterList){
            if(character.getId().toString().equals(playerId)){
                return Optional.of(character);
            }
        }
        return Optional.empty();
    }

    public List<PlayerCharacter> findByPlayerName(String playerName){
        List<PlayerCharacter> result = new ArrayList<>();
        for(PlayerCharacter character: characterList){
            if(character.getPlayerName().equalsIgnoreCase(playerName)){
                result.add(character);
            }
        }
        return result;
    }

    public List<PlayerCharacter> findAll(){
        return new ArrayList<>(characterList);
    }

    public PlayerCharacter addCharacter(PlayerCharacter character){
        if(!characterList.contains(character)){
            characterList.add(character);
        }
        return character;
    }
}
