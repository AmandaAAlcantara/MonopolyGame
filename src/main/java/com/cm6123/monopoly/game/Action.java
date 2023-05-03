package com.cm6123.monopoly.game;
import com.cm6123.monopoly.dice.Dice;

public class Action {
    private String playerName;
    private int firstRoll;
    private int secondRoll;
    private int spacesToMove;
    /**
     * Creating a private instance variable for the properties object of the Properties class.
     */
    private Properties properties = new Properties();
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
     * @param player **this is**
     * @return newPosition
     */
    public int move(final Player player) {
        Dice dice = new Dice(6);
        firstRoll = dice.roll();
        secondRoll = dice.roll();
        spacesToMove = firstRoll + secondRoll;
        int newPosition = (player.getPosition() + spacesToMove) % boardSize;
        player.setPosition(newPosition);
        return newPosition;
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
            case "Home":
                bank.deposit(player, 200);
                break;
            case "Road":
                break;
            case "Copacabana":
                if (properties.getPropertyOwner("Copacabana") != null) {
                    int rent = properties.getPropertyRent("Copacabana");
                    bank.withdraw(player, rent);
                    //bank.deposit(player,rent);
                    System.out.println("Paid rent");
                } else {
                    int price = properties.getPropertyPrice("Copacabana");
                    if (bank.getBalance(player) >= price) {
                        bank.withdraw(player, price);
                        properties.addPropertyOwner("Copacabana", player.getName());
                        System.out.println("Player " + player.getName() + " bought the Copacabana property");
                    } else {
                        System.out.println("Player " + player.getName() + " cannot afford to buy the Copacabana property");
                    }
                }
                break;
            case "Leblon":
                if (properties.getPropertyOwner("Leblon") != null) {
                    int rent = properties.getPropertyRent("Leblon");
                    bank.withdraw(player, rent);
                    //bank.deposit(player,rent);
                    System.out.println("Paid rent");
                } else {
                    int price = properties.getPropertyPrice("Leblon");
                    if (bank.getBalance(player) >= price) {
                        bank.withdraw(player, price);
                        properties.addPropertyOwner("Leblon", player.getName());
                        System.out.println("Player " + player.getName() + " bought the Leblon property");
                    } else {
                        System.out.println("Player " + player.getName() + " cannot afford to buy the Leblon property");
                    }
                }
                break;
            case "Barra da Tijuca":
                if (properties.getPropertyOwner("Barra da Tijuca") != null) {
                    int rent = properties.getPropertyRent("Barra da Tijuca");
                    bank.withdraw(player, rent);
                    //bank.deposit(player,rent);
                    System.out.println("Paid rent");
                } else {
                    int price = properties.getPropertyPrice("Barra da Tijuca");
                    if (bank.getBalance(player) >= price) {
                        bank.withdraw(player, price);
                        properties.addPropertyOwner("Barra da Tijuca", player.getName());
                        System.out.println("Player " + player.getName() + " bought the Barra da Tijuca property");
                    } else {
                        System.out.println("Player " + player.getName() + " cannot afford to buy the Barra da Tijuca property");
                    }
                }
                break;
            case "Ipanema":
                if (properties.getPropertyOwner("Ipanema") != null) {
                    int rent = properties.getPropertyRent("Ipanema");
                    bank.withdraw(player, rent);
                    //bank.deposit(player,rent);
                    System.out.println("Paid rent");
                } else {
                    int price = properties.getPropertyPrice("Ipanema");
                    if (bank.getBalance(player) >= price) {
                        bank.withdraw(player, price);
                        properties.addPropertyOwner("Ipanema", player.getName());
                        System.out.println("Player " + player.getName() + " bought the Ipanema property");
                    } else {
                        System.out.println("Player " + player.getName() + " cannot afford to buy the Barra da Ipanema property");
                    }
                }
                break;
            case "Tax Office":
                if (firstRoll == secondRoll){
                int balance = bank.getBalance(player);
                int amount1 = (int) (balance*0.1);
                bank.withdraw(player, amount1);}
                else {
                int balance = bank.getBalance(player);
                int amount2 = (int) (balance*0.05);
                bank.withdraw(player, amount2);}
                break;
            case "Train Station":
                bank.withdraw(player, spacesToMove*10);
                break;
        }
    }
}



