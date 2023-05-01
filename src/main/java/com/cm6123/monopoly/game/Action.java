package com.cm6123.monopoly.game;

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
     * Creating constructor for the Action class as parameters and initializing the instance variables.
     * @param bank **this is**
     * @param board **this is**
     */
    public Action(final Bank bank, final Board board) {
        this.bank = bank;
        this.board = board;
    }
    /**
     * Creating moveToSpace, so that when the player moves to different spaces the bank actions are executed.
     * @param player **this is**
     * @param spaceId **this is**
     */
    public void moveToSpace(final Player player, final int spaceId) {
        String spaceName = board.getCurrentSpace(spaceId);
        switch(spaceName) {
            case "Home": // If lands in space 1
                bank.deposit(player, 200); // award 200 bonus for landing on Home
                break;
            case "Road":
                bank.getBalance(player); // If lands in space 2
                break;
            case "Copacabana": // If lands in space 3
                bank.withdraw(player, 400); //
                break;
            case "Leblon": // If lands in space 4
                bank.withdraw(player, 250); //
                break;
            case "Barra da Tijuca": // If lands in space 6
                bank.withdraw(player,150); //
                break;
            case "Ipanema": // If lands in space 7
                bank.withdraw(player,200); //
                break;
            case "Tax Office": // If lands in space 8
                bank.withdraw(player,100); //
                break;
            case "Train Station": // If lands in sapace 10
                bank.withdraw(player,100); //
                break;
            default:
                bank.getBalance(player); //
                break;
        }
    }
}
