package com.matej.guessing_game.data;

public class Player {
    int guesses = 0;

    int number;

    boolean finished = false;

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    int getGuesses(){
        return guesses;
    }

    void incrementGuesses() {
        this.guesses++;
    }

    boolean getGameStatus() {
        return finished;
    }

    void markGameAsFinished() {
        finished = true;
    }

}