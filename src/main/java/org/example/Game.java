package org.example;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        //start game
        printGameRules();
        String choice = input.nextLine().toUpperCase(); //prompt response

        //initialize variables
        ScoreBoard scoreBoard = new ScoreBoard();

        while (!choice.equals("quit")) //do the following if the user does not put in "quit"
        {
            GameOption playerChoice = getPlayerChoice(choice);
            if (playerChoice == null)//not valid responses
            {
                while(playerChoice == null) //continue while user input is still not valid
                {
                    System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                    choice = input.nextLine().toUpperCase();
                    playerChoice = getPlayerChoice(choice);
                }
            }

            GameOption computerChoice = getComputerChoice();

            decideWinner(playerChoice, computerChoice, scoreBoard);
            printResults(scoreBoard);
            choice = input.nextLine().toUpperCase(); //prompt for new user input
        }
    }

    private static void printResults(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWins() + "\nloses:" + scoreBoard.getLoses() + "\nties:" + scoreBoard.getTies()); //print out number of wins, ties, and loses
        System.out.println("Let's play again! \n \n"); //start game again
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private static void decideWinner(GameOption choicenum, GameOption compnum, ScoreBoard scoreBoard) {
        if(choicenum == compnum) //tie cases
        {
            System.out.println("It's a tie");
            scoreBoard.incrementTies();
        }
        else if (choicenum == GameOption.ROCK && compnum == GameOption.SCISSORS)
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        }
        else if (choicenum == GameOption.SCISSORS && compnum == GameOption.PAPER)
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        }
        else if (choicenum == GameOption.PAPER && compnum == GameOption.ROCK)
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        }
        else //otherwise computer wins
        {
            System.out.println("you lose.");
            scoreBoard.incrementLoses();
        }
    }

    private GameOption getPlayerChoice(String choice) {
        GameOption selectedOption = null;

        if (choice.equalsIgnoreCase("quit")) {
            System.exit(0);
        }

        try {
            selectedOption = GameOption.valueOf(choice);
        } catch (Exception e) {
            return null;
        }
        return selectedOption;
    }

    private GameOption getComputerChoice() {
        GameOption option = GameOption.values()[random.nextInt(3)];

        System.out.println("Computer chose " + option.toString().toLowerCase());

        return option;
    }

    private static void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }
}