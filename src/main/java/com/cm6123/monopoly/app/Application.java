package com.cm6123.monopoly.app;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.Bank;
import com.cm6123.monopoly.game.Action;
import com.cm6123.monopoly.game.Player;
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

        System.out.println("Hello. Welcome to Monopoly.");

        logger.info("Application closing");

        Bank bank = new Bank();
        Board board = new Board();
        Action action = new Action(bank, board);

// get number of players from user input
        Scanner scanner = new Scanner(System.in);
        int numPlayers = 0;
        while (numPlayers < 2 || numPlayers > 10) {
            System.out.print("Enter number of players (between 2 and 10): ");
            numPlayers = scanner.nextInt();
            scanner.nextLine();  // consume the newline character
        }

// create players
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name of Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName);
        }

        int currentPlayerIndex = 0;  // index of the player whose turn it is

        while (true) {
            // get current player and move to new space
            Player currentPlayer = players[currentPlayerIndex];
            int newPosition = action.move(currentPlayer);
            action.moveToSpace(currentPlayer, newPosition);
            System.out.println(currentPlayer.getName() + " balance after moving to space " + newPosition + ": " + bank.getBalance(currentPlayer));

            // check if current player has won
            if (bank.getBalance(currentPlayer) <=0) {
                System.out.println(currentPlayer.getName() + " has lost");
                break;  // exit loop if current player has won
            }

            // move to next player's turn
            currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;

            // ask user if they want to continue playing
            System.out.print("Continue playing? (Y/N): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("N")) {
                break;  // exit loop if user enters "N"
            }
        }
    }
}
