package org.example;

public class ScoreBoard {

    private Integer ties = 0;
    private Integer wins = 0;
    private Integer loses = 0;

    public ScoreBoard() {
        ties = 0;
        wins = 0;
        loses = 0;
    }

    public Integer getTies() {
        return ties;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLoses() {
        return loses;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementLoses() {
        loses++;
    }

    public void incrementTies() {
        ties++;
    }
}
