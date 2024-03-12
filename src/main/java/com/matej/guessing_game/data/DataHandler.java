package com.matej.guessing_game.data;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class DataHandler {
    Map<String, Player> map = new HashMap<String, Player>();

    public void newPlayer(String id) {
        Player newPlayer = new Player();
        Random random = new Random();
        int RandomNumber = random.nextInt(99) + 1;
        newPlayer.setNumber(RandomNumber);
        map.put(id, newPlayer);
        System.out.println("RANDOM NUMBER IS: ");
        System.out.println(RandomNumber);
    }

    public boolean checkIfExists(String id){
        if(map.containsKey(id)) {
            return true;
        }
        return false;
    }
    public int getNumber(String id) {
        return map.get(id).getNumber();
    }

    public int getGuesses(String id) {
        return map.get(id).getGuesses();
    }

    public void incrementGuesses(String id) {
        map.get(id).incrementGuesses();
    }

    public void endGame(String id){
        map.get(id).markGameAsFinished();
    }

    public boolean getGameStatus(String id) {
        return map.get(id).getGameStatus();
    }
}
