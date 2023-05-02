package com.cm6123.monopoly.game;
import com.cm6123.monopoly.dice.Dice;

public class Action {
    /**
     * Creating a private instance variable for the bank object of the Bank class.
     */
    private Bank bank;
    /**
     * Creating a private instance variable for the board object of the Board class.
     */
    private Board board;
    /**
     * Defining board size.
     */
    private final int boardSize = 10;

    /**
     * Creating constructor for the Action class as parameters and initializing the instance variables.
     * @param bank  **this is**
     * @param board **this is**
     */
    public Action(final Bank bank, final Board board) {
        this.bank = bank;
        this.board = board;
    }

    /**
     * Creating moveToSpace, so that when the player moves to different spaces the bank actions are executed.
     *
     * @param player  **this is**
     * @param spaceId **this is**
     */
    public void moveToSpace(final Player player, final int spaceId) {
        String spaceName = board.getCurrentSpace(spaceId);
        switch (spaceName) {
            case "Home": // If lands in space 1
                bank.deposit(player, 200); // award 200 bonus for landing on Home
                break;
            case "Road":
                // do nothing if lands on space 2
                break;
            case "Copacabana": // If lands in space 3
                bank.withdraw(player, 400); // withdraw 400 from the player's balance
                break;
            case "Leblon": // If lands in space 4
                bank.withdraw(player, 250); // withdraw 250 from the player's balance
                break;
            case "Barra da Tijuca": // If lands in space 6
                bank.withdraw(player, 150); // withdraw 150 from the player's balance
                break;
            case "Ipanema": // If lands in space 7
                bank.withdraw(player, 200); // withdraw 200 from the player's balance
                break;
            case "Tax Office": // If lands in space 8
                bank.withdraw(player, 100); // withdraw 100 from the player's balance
                break;
            case "Train Station": // If lands in space 10
                bank.withdraw(player, 100); // withdraw 100 from the player's balance
                break;
        }
    }

    /**
     * Creating moveToSpace, so that when the player moves to different spaces the bank actions are executed.
     *
     * @param player **this is**
     * @return newPosition
     */
    public int move(final Player player) {
        Dice dice = new Dice(6);
        int firstRoll = dice.roll();
        int secondRoll = dice.roll();
        int spacesToMove = firstRoll + secondRoll;
        int newPosition = (player.getPosition() + spacesToMove) % boardSize;
        player.setPosition(newPosition);
        return newPosition;
    }

}



