package org.example;

import java.util.Scanner;

public class Snap extends CardGame{
    private Player player1;
    private Player player2;
    private long startTime;
    private long endTime;


    public Snap(String name, String player1Name, String player2Name) {
        super(name);
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void playGame () {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            Card previousCard = null;
            boolean player1Turn = true;

            shuffleDeck();

            while (true) {
                startTime = System.currentTimeMillis();

                scanner.nextLine();

                Card currentCard = dealCard();
                System.out.println("Current card " + currentCard);

                String snapInput = scanner.nextLine();

                endTime = System.currentTimeMillis();

                if (previousCard != null && previousCard.getSymbol().equals(currentCard.getSymbol())) {
                    if (snapInput.equalsIgnoreCase("snap")) {
                        long timeDifference = endTime - startTime;
                        System.out.println(timeDifference);

                        if (timeDifference < 2000) {
                            System.out.println("Snap! " + (player1Turn ? player1.getName() : player2.getName()) +
                                    " wins this round!" + previousCard + " matches " + currentCard);
                            if (player1Turn) {
                                player2.setLost(true);
                            } else {
                                player1.setLost(true);
                            }
                        } else {
                            System.out.println("You said 'snap' too late...");
                        }
                        break;
                    } else {
                        System.out.println("Missed this one, type 'snap' when you see a matching pair.");
                    }
                }
                previousCard = currentCard;
                player1Turn = !player1Turn;
            }

            if (player1.hasLost() || player2.hasLost()) {
                gameOver = true;
                System.out.println("Game over");
            } else {
                System.out.println("Press enter to stat the next round...");
                scanner.nextLine();
            }
        }
        scanner.close();

    }
}
