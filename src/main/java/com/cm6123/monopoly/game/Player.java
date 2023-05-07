package com.cm6123.monopoly.game;
public class Player {
    /**
     * Creating a String variable to store the player value.
     */
    private String player;
    /**
     * Creating an int variable to store the position of the player in the monopoly game.
     */
    private int position;

    /**
     * defining the player as a parameter and the position as 0 (0 is the start of the board).
     *
     * @param aplayer ** this is **
     */
    //Used the code from stackoverflow as inspiration: https://stackoverflow.com/questions/20028272/syntax-and-logic-for-moving-player-around-game-board-array-using-do-while-loop-j
    //Access: 3 Apr 2023
    public Player(final String aplayer) {
        this.player = aplayer;
        this.position = 0; // Initial position
    }

    /**
     * Returning the value of the player if the method getPlayer is called.
     *
     * @return player.getPlayer()
     */
    public String getPlayer() {
        return player;
    }

    /**
     * Returning the position of the player if the method getPosition is called.
     *
     * @return postion.getPosition()
     */
    public int getPosition() {
        return position;
    }

    /**
     * Updating the position of the player by adding the number of spaces to move to the current position.
     *
     * @param spacesToMove the number of spaces to move
     */
    public void setPosition(final int spacesToMove) {
        this.position = spacesToMove;
    }

    /**
     * Returning the name of the player if the method is called. Returns the player.
     *
     * @return player
     */
    public String getName() {
        return player;
    }
}
