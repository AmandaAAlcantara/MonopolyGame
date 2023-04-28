package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.dice.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private List<String> players;

    public UserInput() {
        scanner = new Scanner(System.in);
        players = new ArrayList<>();
    }

    public void getNameFromUser() {
        final int minPlayers = 2;
        System.out.println("Enter player names (min 2 and max 10 players <done> to finish registration):");


        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            if (input.isEmpty()) {
                System.out.println("Please enter a player name (Empty not valid).");
                continue;
            }
            if (players.contains(input)) {
                System.out.println("Player already added, add different player");
                continue;
            }
            players.add(input);
            if (players.size() == 10) {
                System.out.println("Maximum number of players added.");
                break;
            }
            System.out.println("Enter player names (min 2 and max 10 players <done> to finish registration):");
        }


        }

    public void getPlayerSpaces() {
        for (String playerName : players) {
            Player playerInTurn = new Player(playerName);
            playerInTurn.setPlayerPosition(playerName);
            System.out.println("Player : " + playerName + " is now in space: " + playerInTurn.setPlayerPosition(playerName));
        }
        }


    public static void main(String[] args) {
        UserInput userInputPlayer = new UserInput();
        userInputPlayer.getNameFromUser();
        userInputPlayer.getPlayerSpaces();
    }
}


