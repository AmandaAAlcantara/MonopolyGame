package com.cm6123.monopoly.app;
import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.Bank;
import com.cm6123.monopoly.game.Action;
import com.cm6123.monopoly.game.Properties;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Bankruptcy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public final class Application {
    /**
     * Create a logger for the class.
     */
    private static Logger logger = LoggerFactory.getLogger(Application.class);


    private Application() {
    }

    /**
     * main entry point.  If args provided, result is displayed and program exists. Otherwise, user is prompted for
     * input.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {
        logger.info("Application Started with args:{}", String.join(",", args));
        System.out.println("Hello. Welcome to Rio de Janeiro Monopoly.");
        logger.info("Application closing");

        Bank bank = new Bank();
        Board board = new Board();
        Properties properties = new Properties();
        Action action = new Action(bank, board);


        Scanner scanner = new Scanner(System.in);
        int numPlayers = 0;
        while (numPlayers < 2 || numPlayers > 10) {
            System.out.print("Enter number of players (between 2 and 10): ");
            numPlayers = scanner.nextInt();
            scanner.nextLine();
        }


        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name of Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName);
        }

        int currentPlayerIndex = 0;  // index of the player whose turn it is

        while (true) {

            Player currentPlayer = players[currentPlayerIndex];
            int newPosition = action.move(currentPlayer);
            action.moveToSpace(currentPlayer, newPosition);
            System.out.println(currentPlayer.getName() + " is now in square: " + board.getCurrentSpace(newPosition) + "\r\n"+"Balance: " + bank.getBalance(currentPlayer));

            if (numPlayers < 2){
                System.out.println(currentPlayer.getName() + " is the winner of Rio de Janeiro Monopoly");
            break;
            }
            if (bank.getBalance(currentPlayer) <= 0) {
                System.out.println(currentPlayer.getName() + " has no money left");
                System.out.println(currentPlayer.getName() + " Leaving game");

                // Create a new array with one less element
                Player[] newPlayers = new Player[numPlayers - 1];

                // Copy all the elements from the old array except for the current player
                int j = 0;
                for (int i = 0; i < numPlayers; i++) {
                    if (i != currentPlayerIndex) {
                        newPlayers[j] = players[i];
                        j++;
                    }
                }

                // Update the players array and numPlayers
                players = newPlayers;
                numPlayers--;

                // Reset the currentPlayerIndex if it's out of bounds
                if (currentPlayerIndex >= numPlayers) {
                    currentPlayerIndex = 0;
                }
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;


            System.out.print("<Enter> for next player move"+"\r\n");
            String input = scanner.nextLine();
        }
    }
}
