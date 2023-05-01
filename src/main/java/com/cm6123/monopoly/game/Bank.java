package com.cm6123.monopoly.game;
import java.util.Map;
import java.util.HashMap;


    public class Bank {
        /**
         * Creating a Map to store the players balances, essential so that they can pay tax, ticket and properties.
         */
        private Map<String, Integer> balances;
        /**
         * Creating an int variable to store the dice value.
         */
        private int diceValue;
        /**
         * Defining the initial balance for each player.
         * @param playerName **this is**
         */
        public Bank(final String playerName) {
            balances = new HashMap<>();
            balances.put(playerName, 1000);
        }
        /**
         * Creating a String variable to store the player value.
         * @return return balances.get(playerName)
         * @param playerName **this is**
         */
        public int getBalance(final String playerName) {
            return balances.get(playerName);
        }
        /**
         * Creating a String variable to store the player value.
         * @param playerName **this is**
         */
        public void addMoneyHome(final String playerName) {
            int currentBalance = balances.get(playerName);
            balances.put(playerName, currentBalance + 200);
        }
        /**
         * Creating a String variable to store the player value.
         * @param playerName **this is**
         */
        public void takeTaxMoney(final String playerName) {
            int currentBalance = balances.get(playerName);
            int taxAmount = (int) (currentBalance * 0.1);
            balances.put(playerName, currentBalance - taxAmount);
        }
        /**
         * Creating a String variable to store the player value.
         * @param playerName **this is**
         */
        public void takeTaxMoneyDoubleDiceValue(final String playerName) {
            int currentBalance = balances.get(playerName);
            int taxAmount = (int) (currentBalance * 0.05);
            balances.put(playerName, currentBalance - taxAmount);
        }
        /**
         * Defining the action for when the given player needs to pay Ticket, dependent on the dice value.
         * @param diceValue **this is**
         * @param playerName **this is**
         */
        public void takeTicketMoney(final String playerName, final int diceValue) {
            int currentBalance = balances.get(playerName);
            int ticketAmount = (int) (diceValue * 10);
            balances.put(playerName, currentBalance - ticketAmount);
        }
    }
