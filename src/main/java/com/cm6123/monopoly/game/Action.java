package com.cm6123.monopoly.game;
import com.cm6123.monopoly.dice.Dice;

public class Action {
    /**
     * Creating a private String variable for storing the player name.
     */
    private String playerName;
    /**
     * Creating a private integer variable for storing the value of the die first roll.
     */
    private int firstRoll;
    /**
     * Creating a private integer variable for storing the value of the die second roll.
     */
    private int secondRoll;
    /**
     * Creating a private integer variable for storing the value of the added values of the dices (the spaces the player needs to move).
     */
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
     * @param thebank  **this is**
     * @param theboard **this is**
     */
    public Action(final Bank thebank, final Board theboard) {
        this.bank = thebank;
        this.board = theboard;
    }
    /**
     * Creating move() method that takes the argument player and returns the added value of two dice rolls.
     *
     * @param player **this is**
     * @return newPosition
     */
    //Adaptive use of modulus operator from https://codereview.stackexchange.com/questions/58063/screen-wraparound. [Access: 1 Apr 2023]
    public int move(final Player player){
        Dice dice = new Dice(6);
        firstRoll = dice.roll();
        secondRoll = dice.roll();
        spacesToMove = firstRoll + secondRoll;
        int newPosition = (player.getPosition() + spacesToMove) % boardSize;
        player.setPosition(newPosition);
        return newPosition;
    }
    /**
     * Creating moveToSpace, so that when the player lands on different spaces different actions are executed.
     *
     * @param player  **this is**
     * @param spaceId **this is**
     */
    //Inspired switch use addapted from W3 Schools. Available at: https://www.w3schools.com/java/java_switch.asp
    //Accessed 3 May 2023
    public void moveToSpace(final Player player, final int spaceId) {
        String spaceName = board.getCurrentSpace(spaceId);
        switch (spaceName) {
            case "Home":
                bank.deposit(player, 200);
                break;
            case "Road":
                break;
            case "Copacabana":
                if (properties.getPropertyOwner("Copacabana") == player.getPlayer()) {
                    System.out.println("You landed in your property");
                } else {
                    if (properties.getPropertyOwner("Copacabana") != null && properties.getPropertyOwner("Copacabana") != player.getPlayer()) {
                        int rent = properties.getPropertyRent("Copacabana");
                        bank.withdrawl(player, rent);
                        //This would deposit the rent amount in the Owner`s balance however, the deposit method does not accept a string. So this line of code does not work.
                        //bank.deposit((properties.getPropertyOwner("Copacabana"),rent);
                        System.out.println("Paid rent.");
                    } else {
                        int price = properties.getPropertyPrice("Copacabana");
                        if (bank.getBalance(player) >= price) {
                            bank.withdrawl(player, price);
                            properties.addPropertyOwner("Copacabana", player.getName());
                            System.out.println("Player " + player.getName() + " bought the Copacabana property");
                        } else {
                            System.out.println("Player " + player.getName() + " cannot afford to buy the property");
                        }
                    }
                }
                break;
            case "Leblon":
                if (properties.getPropertyOwner("Leblon") == player.getPlayer()) {
                    System.out.println("You landed in your property");
                } else {
                    if (properties.getPropertyOwner("Leblon") != null && properties.getPropertyOwner("Leblon") != player.getPlayer()) {
                        int rent = properties.getPropertyRent("Leblon");
                        bank.withdrawl(player, rent);
                        //This would deposit the rent amount in the Owner`s balance however, the deposit method does not accept a string. So this line of code does not work.
                        //bank.deposit((properties.getPropertyOwner("Copacabana"),rent);
                        System.out.println("Paid rent.");
                    } else {
                        int price = properties.getPropertyPrice("Leblon");
                        if (bank.getBalance(player) >= price) {
                            bank.withdrawl(player, price);
                            properties.addPropertyOwner("Leblon", player.getName());
                            System.out.println("Player " + player.getName() + " bought the Leblon property");
                        } else {
                            System.out.println("Player " + player.getName() + " cannot afford the property");
                        }
                    }
                }
                break;
            case "Barra da Tijuca":
                if (properties.getPropertyOwner("Barra da Tijuca") == player.getPlayer()) {
                    System.out.println("You landed in your property");
                } else {
                    if (properties.getPropertyOwner("Barra da Tijuca") != null && properties.getPropertyOwner("Barra da Tijuca") != player.getPlayer()) {
                        int rent = properties.getPropertyRent("Barra da Tijuca");
                        bank.withdrawl(player, rent);
                        //This would deposit the rent amount in the Owner`s balance however, the deposit method does not accept a string. So this line of code does not work.
                        //bank.deposit((properties.getPropertyOwner("Barra da Tijuca"),rent);
                        System.out.println("Paid rent.");
                    } else {
                        int price = properties.getPropertyPrice("Barra da Tijuca");
                        if (bank.getBalance(player) >= price) {
                            bank.withdrawl(player, price);
                            properties.addPropertyOwner("Barra da Tijuca", player.getName());
                            System.out.println("Player " + player.getName() + " bought the Barra da Tijuca property");
                        } else {
                            System.out.println("Player " + player.getName() + " cannot afford the property");
                        }
                    }
                }
                break;
            case "Ipanema":
                if (properties.getPropertyOwner("Ipanema") == player.getPlayer()) {
                    System.out.println("You landed in your property");
                } else {
                    if (properties.getPropertyOwner("Ipanema") != null && properties.getPropertyOwner("Ipanema") != player.getPlayer()) {
                        int rent = properties.getPropertyRent("Ipanema");
                        bank.withdrawl(player, rent);
                        //This would deposit the rent amount in the Owner`s balance however, the deposit method does not accept a string. So this line of code does not work.
                        //bank.deposit((properties.getPropertyOwner("Ipanema"),rent);
                        System.out.println("Paid rent.");
                    } else {
                        int price = properties.getPropertyPrice("Ipanema");
                        if (bank.getBalance(player) >= price) {
                            bank.withdrawl(player, price);
                            properties.addPropertyOwner("Ipanema", player.getName());
                            System.out.println("Player " + player.getName() + " bought the Ipanema property");
                        } else {
                            System.out.println("Player " + player.getName() + " cannot afford the property");
                        }
                    }
                }

                break;
            case "Tax Office":
                if (firstRoll == secondRoll){
                int balance = bank.getBalance(player);
                //Takes 5% off player's balance if the first roll = second roll
                int amount1 = (int) (balance*0.05);
                bank.withdrawl(player, amount1);
                } else {
                int balance = bank.getBalance(player);
                //Takes 10% off player's balance if the first roll = second roll
                int amount2 = (int) (balance*0.1);
                bank.withdrawl(player, amount2);
                }
                break;
            case "Train Station":
                bank.withdrawl(player, spacesToMove*10);
                break;
        }
    }
    /**
     * Creating movePlayer() to test the Action class. With this I can define the value of the dices to test the moveToSpace() method.
     * @param player **this is**
     * @param thefirstRoll  **this is**
     * @param thesecondRoll **this is**
     * @param numspacesToMove **this is**
     * @return numspacesToMove **this is**
     */
    //This method is used in the ActionChecks
    //Created to test the conditional statements of moveToSpace()
    public int movePlayer(final Player player,final int thefirstRoll, final int thesecondRoll, final int numspacesToMove) {
        this.firstRoll = thefirstRoll;
        this.secondRoll = thesecondRoll;
        this.spacesToMove = numspacesToMove;
        return numspacesToMove;
    }
}

