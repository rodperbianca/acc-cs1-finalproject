// Bia Pereira and Reza Halbrooks
// 12/03/2025
// CSC 1060 Final Project

import java.util.Scanner;
public class DiceGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // starting score is zero and dice values zero
        int score = 0;
        int dice1Value = 0;
        int dice2Value = 0;
        int diceTotal = 0;

        //code for printing an emoji
        int sadFace = 0x1F622;
        String sadEmoji = new String(Character.toChars(sadFace));
        int smileyFace = 0x1F601;
        String  smileyEmoji = new String(Character.toChars(smileyFace));

        System.out.println("Welcome to Dice Game! \uD83C\uDFB2");
        System.out.println("This game is for two players");
        System.out.print("First player what is your name? ");
        String firstPlayer = input.nextLine();
        System.out.print("What is your name second player? ");
        String secondPlayer = input.nextLine();
        System.out.println("Welcome to the game " + firstPlayer + " and " + secondPlayer + "!");

        // calling the players
        Player player1 = new Player();
        player1.setName(firstPlayer);
        Player player2 = new Player();
        player2.setName(secondPlayer);

        // calling the dices
        RollDice dice1 = new RollDice();
        RollDice dice2 = new RollDice();

        System.out.print("Would you like to (1)See the rules of the game or (2)Play the game? ");
        int rulesGame = input.nextInt();
        if (rulesGame == 1) {
            // printing out the message and rules of the game
            System.out.println("The goal of Dice Game is to accumulate a perfect score of 30. The first player to score exactly 30 is the Winner!");
            System.out.println("You will roll a pair of dice, then you must choose the score of one of the dice or the total of the two dice. \n" +
                    "This value is added to your score. If your score goes over 30, your score is reset to zero. \n" +
                    "Player turn changes after each roll of the dice. You win when you accumulate a score of exactly 30.");
            System.out.println("Here we go!");
            System.out.println("Good luck!\n");
        }

        //calculating each turn for each player
        while (true) {
            // first player turn
            score = player1.getScore();
            System.out.println(player1.getName() + " it's your turn!\nYour score is " + player1.getScore());
            dice1Value = dice1.getDice();
            dice2Value = dice2.getDice();
            System.out.println("\uD83C\uDFB2 The first die value is " + dice1Value + "\n\uD83C\uDFB2 The second die value is " + dice2Value);
            diceTotal = dice1Value + dice2Value;
            System.out.println("The total value of both dice is " + diceTotal);
            System.out.print("Would you like to: \n(1)Keep the first die " + dice1Value + "? \n(2)Keep the second die " + dice2Value + "? \n(3)Keep the total " + diceTotal + "? \n" + player1.getName() + " what is your choice, option 1, option 2 or option 3? ");
            int choice = input.nextInt();
            if (choice == 1) {
                player1.setScore(dice1Value);
                System.out.println("Your total is " + player1.getScore() + "\n");
            }
            if (choice == 2) {
                player1.setScore(dice2Value);
                System.out.println("Your total is " + player1.getScore() + "\n");
            }
            if (choice == 3) {
                player1.setScore(diceTotal);
                System.out.println("Your total is " + player1.getScore() + "\n");
            }
            score = player1.getScore();

            if (score == 30) {
                System.out.println("Congratulations " + player1.getName() + "! You win! " + smileyEmoji);
                System.out.println("Sorry " + player2.getName() + "! You lost this time! Try again!" + sadEmoji);
                System.exit(0);
            } else if (score > 30) {
                System.out.println("That's too sad! Your score went over 30. You will start again with a score of zero." + sadEmoji);
                player1.resetScore();
                System.out.println(player1.getName() + " your new score is " + player1.getScore() + "\n");
                }
            // second player turn
            score = player2.getScore();
            dice1Value = dice1.getDice();
            dice2Value = dice2.getDice();
            System.out.println(player2.getName() + " it's your turn!\nYour score is " + player2.getScore());
            System.out.println("\uD83C\uDFB2 The first die value is " + dice1Value + "\n\uD83C\uDFB2 The second die value is " + dice2Value);
            diceTotal = dice1Value + dice2Value;
            System.out.println("The total value of both dice is " + diceTotal);
            System.out.print("Would you like to: \n(1)Keep the first die " + dice1Value + "? \n(2)Keep the second die " + dice2Value + "? \n(3)Keep the total " + diceTotal + "? \n" + player2.getName() + " what is your choice, option 1, option 2 or option 3?");
            choice = input.nextInt();
            if (choice == 1) {
                player2.setScore(dice1Value);
                System.out.println("Your total is " + player2.getScore() + "\n");
            }
            if (choice == 2) {
                player2.setScore(dice2Value);
                System.out.println("Your total is " + player2.getScore() + "\n");
            }
            if (choice == 3) {
                player2.setScore(diceTotal);
                System.out.println("Your total is " + player2.getScore() + "\n");
            }
            score = player2.getScore();

            if (score == 30) {
                System.out.println("Congratulations " + player2.getName() + "! You win!" + smileyEmoji);
                System.out.println("Sorry " + player1.getName() + "! You lost this time! Try again!" + sadEmoji);
                System.exit(0);
            } else if (score > 30) {
                System.out.println("That's too sad! Your score went over 30. You will start again with a score of zero. " + sadEmoji);
                player2.resetScore();
                System.out.println(player2.getName() + " your new score is " + player2.getScore() + "\n");
            }
        }
    }
}

// a player class that keeps score for each player
class Player {
    private String name;
    private int score = 0;
    public Player() {
    }
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score += score;
    }
    public void resetScore() {
        this.score = 0;
    }
}
// a class for rolling the dices
class RollDice {
    private int dice;
    private int min = 1;
    private int max = 6;

    public RollDice() {
    }
    // getting the first dice value
    public int getDice() {
        return min + (int) (Math.random() * (max - min + 1));
    }
}