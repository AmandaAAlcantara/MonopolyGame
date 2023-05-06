package com.cm6123.monopoly.game;

import com.cm6123.monopoly.game.Bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BankChecks {
    @Test
    public void testGetBalance() {
        Bank bank = new Bank();
        Player player = new Player("Bob");
        assertEquals(1000, bank.getBalance(player));
        bank.deposit(player, 300);
        assertEquals(1300, bank.getBalance(player));
        bank.withdrawl(player, 100);
        assertEquals(1200, bank.getBalance(player));
        assertFalse(bank.getBalance(player) == 0);
        assertFalse(bank.getBalance(player) == 1000);
    }

    @Test
    public void testDepositMethod() {
        Bank bank = new Bank();
        Player player = new Player("John");
        bank.deposit(player, 553);
        assertEquals(1553, bank.getBalance(player));
        assertFalse(bank.getBalance(player) == 0);
        assertFalse(bank.getBalance(player) == 1000);
    }

    @Test
    public void testWithdrawMethod() {
        Bank bank = new Bank();
        Player player = new Player("Anna");
        bank.withdrawl(player, 200);
        assertEquals(800, bank.getBalance(player));
        bank.withdrawl(player, 300);
        assertEquals(500, bank.getBalance(player));
        bank.withdrawl(player, 200);
        assertFalse(bank.getBalance(player) == 0);
        assertFalse(bank.getBalance(player) == 1000);
    }
}
