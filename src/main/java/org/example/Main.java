package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SNAP!!");
        System.out.println("Here are the rules/instructions:");
        System.out.println("There are two players and the deck is divided in two for both players");
        System.out.println("please 'ENTER' to flip your card over one by one.");
        System.out.println("Whichever player flips the card matching the same ");
        System.out.println("number to the previous card wins!");
        System.out.println("Before we being, enter your names");

        System.out.println("Player 1 enter your name below: ");
        String player1Name = scanner.nextLine();
        System.out.println("Player 2 enter your name below: ");
        String player2Name = scanner.nextLine();

        System.out.println("Press ENTER to start the game!");

        Snap snapGame = new Snap("My Snap Game", player1Name, player2Name);
        snapGame.playGame();
    }
}