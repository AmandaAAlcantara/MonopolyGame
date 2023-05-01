package com.cm6123.monopoly.game;
public class Player {
    /**
     * Creating a String variable to store the player value.
     */
    private String player;
    /**
     * Creating an int variable to store the position of the player in the monopoly ugame.
     */
    private int position;
    /**
     * defining the player as a parameter and the postion as 0 (0 is the start of the board).
     * @param player ** this is **
     */
    public Player(final String player) {
        this.player = player;
        this.position = 0; // Initial position
    }
    /**
     * Returning the value of the player if the method getPlayer is called.
     * @return player.getPlayer()
     */
    public String getPlayer() {
        return player;
    }
    /**
     * Returning the postion of the player if the method getPosition is called.
     * @return postion.getPosition()
     */
    public int getPosition() {
        return position;
    }
    /**
     * Updating the position depending on the playerPosition so that when the player moves the new position is addded to the initial.
     * @param playerPosition ** this is **
     */
    public void setPosition(final int playerPosition) {
        this.position += playerPosition;
    }
}
