package se.ecutbildning.serilization_demo.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerCharacter implements Serializable {
    private UUID id;
    private String characterName;
    private String playerName;
    private int strength, agility, intelligence;

    PlayerCharacter(){

    }

    public PlayerCharacter(String characterName, String playerName) {
        this.id = UUID.randomUUID();
        this.characterName = characterName;
        this.playerName = playerName;
        this.strength = ThreadLocalRandom.current().nextInt(3,19);
        this.agility = ThreadLocalRandom.current().nextInt(3,19);
        this.intelligence = ThreadLocalRandom.current().nextInt(3,19);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUID.randomUUID();
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCharacter that = (PlayerCharacter) o;
        return strength == that.strength &&
                agility == that.agility &&
                intelligence == that.intelligence &&
                Objects.equals(id, that.id) &&
                Objects.equals(characterName, that.characterName) &&
                Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, characterName, playerName, strength, agility, intelligence);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlayerCharacter{");
        sb.append("id=").append(id);
        sb.append(", characterName='").append(characterName).append('\'');
        sb.append(", playerName='").append(playerName).append('\'');
        sb.append(", strength=").append(strength);
        sb.append(", agility=").append(agility);
        sb.append(", intelligence=").append(intelligence);
        sb.append('}');
        return sb.toString();
    }
}
