package com.matej.guessing_game.handlers;
import com.matej.guessing_game.data.DataHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class GameHandler {

    static DataHandler dataHandler = new DataHandler();
    public static String generateID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        dataHandler.newPlayer(id);
        return id;
    }

    public static Boolean verifyGame(String id) {
        return dataHandler.checkIfExists(id);
    }

    public static String handleGuess(String Id, int number) {
        if(verifyGame(Id)) {
            return GameHandler.checkNumber(Id, number);
        } else {
           return "Invalid";
        }
    }

    public static String checkNumber(String Id, int number) {
        int Number = dataHandler.getNumber(Id);

        if(dataHandler.getGameStatus(Id) == true){
            return "The game finished with this many guesses: " + dataHandler.getGuesses(Id);
        }

        if (Number == number) {
            dataHandler.endGame(Id);
            return "Correct! It took you: " + dataHandler.getGuesses(Id);
        } else if(number > Number) {
            dataHandler.incrementGuesses(Id);
            return "Number is bigger than the number you generated!";
        } else {
            dataHandler.incrementGuesses(Id);
            return "Number is less than the number you generated!";
        }
    }
}
