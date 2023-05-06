package com.cm6123.monopoly.game;
import java.util.Map;
import java.util.HashMap;
    public class Bank {
        /**
         * Creating a Map to store the balances of specific players.
         */
            private Map<Player, Integer> balances;
        /**
         * Creating a public instance variable for the bank and initiating the HasMap.
         */
            public Bank() {
                this.balances = new HashMap<>();
            }
        /**
         * Creating a deposit method so the value defined in the action class, depending on the space, is added to the balance value.
         * @param player **this is**
         * @param amount **this is**
         */
        public void deposit(final Player player, final int amount) {
            int currentBalance = balances.getOrDefault(player, 1000); // set starting balance to 1000
            balances.put(player, currentBalance + amount);
        }
        /**
         * Creating a withdrawl method so, the value defined in the action class depending on the space is deducted from the players balance.
         * @param player **this is**
         * @param amount **this is**
         */
        public void withdrawl(final Player player,final int amount) {
            int currentBalance = balances.getOrDefault(player, 1000); // set starting balance to 1000
            balances.put(player, currentBalance - amount);
        }
        /**
         * Creating a getBalance method so that I can access the balance of each player using it.
         * @param player **this is**
         * @return balances.getOrDefault(player, 1000)
         */
        public int getBalance(final Player player) {
            return balances.getOrDefault(player, 1000); // set starting balance to 1000
        }
    }
