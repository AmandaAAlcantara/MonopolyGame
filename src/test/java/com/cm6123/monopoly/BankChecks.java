package com.cm6123.monopoly.game;

import com.cm6123.monopoly.game.Bank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BankChecks {

    @Test
    public void testDeposit() {
        Bank bank = new Bank();
        Player player = new Player("John");
        bank.deposit(player, 500);
        assertEquals(1500, bank.getBalance(player));
    }

    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        Player player = new Player("Jane");
        bank.withdraw(player, 200);
        assertEquals(800, bank.getBalance(player));
    }

    @Test
    public void testGetBalance() {
        Bank bank = new Bank();
        Player player = new Player("Bob");
        assertEquals(1000, bank.getBalance(player));
        bank.deposit(player, 300);
        assertEquals(1300, bank.getBalance(player));
        bank.withdraw(player, 100);
        assertEquals(1200, bank.getBalance(player));
    }
}
