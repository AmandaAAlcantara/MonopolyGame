package com.cm6123.monopoly.game;

import com.cm6123.monopoly.game.Bank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankChecks {

    @ParameterizedTest
    @ValueSource(strings = {"Maria", "Anna", "Carl"})
    void testAddMoneyHome(String playerName) {
        Bank bank = new Bank(playerName);
        int startingBalance = bank.getBalance(playerName);
        bank.addMoneyHome(playerName);
        assertEquals(startingBalance + 200, bank.getBalance(playerName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Eduardo", "Cole", "Charlie"})
    void testTakeTaxMoney(String playerName) {
        Bank bank = new Bank(playerName);
        int startingBalance = bank.getBalance(playerName);
        bank.takeTaxMoney(playerName);
        int expectedBalance = startingBalance - (int) (startingBalance * 0.1);
        assertEquals(expectedBalance, bank.getBalance(playerName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Marie", "Kate", "Perry"})
    void testTakeTaxMoneyDoubleDiceValue(String playerName) {
        Bank bank = new Bank(playerName);
        int startingBalance = bank.getBalance(playerName);
        bank.takeTaxMoneyDoubleDiceValue(playerName);
        int expectedBalance = startingBalance - (int) (startingBalance * 0.05);
        assertEquals(expectedBalance, bank.getBalance(playerName));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 12})
    void testTakeTicketMoney(int diceValue) {
        Bank bank = new Bank("Babbage");
        int startingBalance = bank.getBalance("Babbage");
        if (diceValue > 12) {
            assertThrows(IllegalArgumentException.class, () -> {
                bank.takeTicketMoney("Babbage", diceValue);
            });
        } else {
            bank.takeTicketMoney("Babbage", diceValue);
            int expectedBalance = startingBalance - (diceValue * 10);
            assertEquals(expectedBalance, bank.getBalance("Babbage"));
        }
    }
}