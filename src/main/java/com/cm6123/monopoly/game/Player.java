package com.cm6123.monopoly.game;
import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.dice.Dice;

public class Player {
    private Dice dice = new Dice(6);
    private String player;
    private int position;
    private final int boardSize = 10;

    public Player(String player) {
        this.player = player;
        this.position = 0; // Initial position
    }

    public String getPlayer() {
        return player;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(final int playerPosition) {
        this.position = playerPosition;
    }

    public int setPlayerPosition( String player) {
        Board board = new Board();
        int firstRoll = dice.roll();
        int secondRoll = dice.roll();
        int spacesToMove = firstRoll + secondRoll;

        int playerPosition = getPosition();
        playerPosition = (playerPosition + spacesToMove) % boardSize;
        setPosition(playerPosition);
        int newPosition = getPosition();
        if (board.getCurrentSpace(newPosition).equals("Home")) {
            System.out.println("Hello");
        }
        return newPosition;
    }

}

