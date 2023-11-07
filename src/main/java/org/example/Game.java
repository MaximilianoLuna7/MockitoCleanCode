package org.example;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        //start game
        printGameRules();
        String choice = input.nextLine().toLowerCase(); //prompt response

        //initialize variables
        ScoreBoard scoreBoard = new ScoreBoard();

        while (!choice.equals("quit")) //do the following if the user does not put in "quit"
        {
            int choicenum = getChoicenum(choice);
            if (choicenum == 0)//not valid responses
            {
                while(choicenum == 0) //continue while user input is still not valid
                {
                    System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                    choice = input.nextLine().toLowerCase();
                    choicenum = getChoicenum(choice);
                }
            }
            int compnum = getChoiceComputer();

            decideWinner(choicenum, compnum, scoreBoard);
            printResults(scoreBoard);
            choice = input.nextLine().toLowerCase(); //prompt for new user input
        }
    }

    private static void printResults(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWins() + "\nloses:" + scoreBoard.getLoses() + "\nties:" + scoreBoard.getTies()); //print out number of wins, ties, and loses
        System.out.println("Let's play again! \n \n"); //start game again
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private static void decideWinner(int choicenum, int compnum, ScoreBoard scoreBoard) {
        if(choicenum == compnum) //tie cases
        {
            System.out.println("It's a tie");
            scoreBoard.incrementTies();
        }
        else if (choicenum == 1 && compnum == 3) //user wins rock vs scissors
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        }
        else if (choicenum == 3 && compnum == 2) //user wins scissors vs paper
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        }
        else if (choicenum == 2 && compnum ==1) //user wins paper vs rock
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

    private int getChoicenum(String choice) {
        int choicenum = 0;
        if (choice.equals("rock"))
        {
            choicenum = 1;
        }
        else if (choice.equals("paper"))
        {
            choicenum = 2;
        }
        else if (choice.equals("scissors"))
        {
            choicenum = 3;
        }
        else if (choice.equals("quit"))
            System.exit(0);

        return choicenum;
    }

    private int getChoiceComputer() {
        int compnum = (int) (random.nextInt(3)) + 1;//computer generate random num
        //print computer choice
        if (compnum == 1) System.out.println("Computer chose rock");
        if (compnum == 2) System.out.println("Computer chose paper");
        if (compnum == 3) System.out.println("Computer chose scissors");

        return compnum;
    }

    private static void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }
}