package com.cm6123.monopoly.game;

public class Bankruptcy extends Bank {
    /**
     * Creating a private instance variable named bank of a class type Bank.
     */
    private Bank bank;
    /**
     * Creating a private instance variable named player of a class type Player.
     */
    private Player player;
    /**
     * Creating a private instance variable named properties of a class type Properties.
     */
    private Properties properties;
    /**
     * Creating a constructor method for the class Bankruptcy. The constructor takes the arguments of types Bank, Player, and Properties and initializes three instance variables.
     * @param thebank **this is**
     * @param theplayer **this is**
     * @param theproperties **this is**
     */
    public Bankruptcy(final Bank thebank, final Player theplayer, final Properties theproperties) {
        super();
        this.bank = thebank;
        this.player = theplayer;
        this.properties = theproperties;
    }
    /**
     * Creatinga avariable to count the price of the properties of the specific player.
     */
    private int accumulationOfassets = 0;
    /**
     * Creating a method accumulatedProperties(final Player aplayer) with if statements so that if the player is the owner of a propertie then the price of that is added to the variable accumulationOfassets.
     * @param aplayer **this is**
     * @return accumulationOfassets
     */
    public int accumulatedProperties(final Player aplayer) {
        if (aplayer.getPlayer() == properties.getPropertyOwner("Copacabana")){
            int property1 = properties.getPropertyPrice("Copacabana");
            accumulationOfassets += property1;
        }
        if (aplayer.getPlayer() == properties.getPropertyOwner("Leblon")) {
            int property2 = properties.getPropertyPrice("Leblon");
            accumulationOfassets += property2;
        }
        if (aplayer.getPlayer() == properties.getPropertyOwner("Barra da Tijuca")) {
            int property3 = properties.getPropertyPrice("Barra da Tijuca");
            accumulationOfassets += property3;
        }
        if (aplayer.getPlayer() == properties.getPropertyOwner("Ipanema")) {
            int property4 = properties.getPropertyPrice("Ipanema");
            accumulationOfassets += property4;
        }
        return accumulationOfassets;
    }
    /**
     * The method takes the argument player.It returns the total value of all properties owned by the player, which is then added to the balance variable and assigned to the accumulatedWealth variable.
     * @param aplayer **this is**
     * @return accumulatedWealth
     */
    public int accumulatedWealth(final Player aplayer){
        int balance = bank.getBalance(aplayer);
        int accumulatedWealth = accumulatedProperties(aplayer) + balance;
        return accumulatedWealth;
    }
    /**
     * The method takes the argument player and deposits the value of the property amount in the owner`s balance.
     * @param aplayer **this is**
     */
    public void sellProperty1(final Player aplayer){
        int balance = bank.getBalance(aplayer);
        int propertyAmount = properties.getPropertyPrice("Barra da Tijuca")-75;
        bank.deposit(aplayer,propertyAmount);
    }
    /**
     * The method takes the argument player and deposits the value of the property amount in the owner`s balance.
     * @param aplayer **this is**
     */
    public void sellProperty2(final Player aplayer){
        int balance = bank.getBalance(aplayer);
        int propertyAmount = properties.getPropertyPrice("Ipanema")-100;
        bank.deposit(aplayer,propertyAmount);
    }
    /**
     * The method takes the argument player and deposits the value of the property amount in the owner`s balance.
     * @param aplayer **this is**
     */
    public void sellProperty3(final Player aplayer){
        int balance = bank.getBalance(aplayer);
        int propertyAmount = properties.getPropertyPrice("Leblon")-125;
        bank.deposit(aplayer,propertyAmount);
    }
    /**
     * The method takes the argument player and deposits the value of the property amount in the owner`s balance.
     * @param aplayer **this is**
     */
    public void sellProperty4(final Player aplayer){
        int balance = bank.getBalance(aplayer);
        int propertyAmount = properties.getPropertyPrice("Copacabana")-200;
        bank.deposit(aplayer,propertyAmount);
    }
}
