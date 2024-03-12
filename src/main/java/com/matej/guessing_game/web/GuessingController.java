package com.matej.guessing_game.web;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.matej.guessing_game.handlers.*;

@RestController
public class GuessingController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/game")
    public String generate_game() {
        return GameHandler.generateID();
    }

    @GetMapping("/game/{game_id}/guess/{number}")
    public String guess(@PathVariable String game_id, @PathVariable int number) {
        String gameResponse = GameHandler.handleGuess(game_id, number);
        if(gameResponse.equals("Invalid")) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Game not found!"
            );
        } else {
            return gameResponse;
        }

    }

}
