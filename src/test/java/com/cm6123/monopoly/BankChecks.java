package com.cm6123.monopoly.game;

import com.cm6123.monopoly.game.Bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BankChecks {
    @Test
    public void testGetBalance() {
        //Given a player named Bob with 1000
        //When Bob starts game
        //Then he should have 1000 as his balance
        Bank bank = new Bank();
        Player player = new Player("Bob");
        assertEquals(1000, bank.getBalance(player));

        //Given a player named Bob with 1000
        //When Bob wins 300
        //Then he should have 1300 as his balance
        bank.deposit(player, 300);
        assertEquals(1300, bank.getBalance(player));

        //Given a player named Bob with 1300
        //When Bob loses 100
        //Then he should have 1200 as his balance
        bank.withdrawl(player, 100);
        assertEquals(1200, bank.getBalance(player));
        assertFalse(bank.getBalance(player) == 0);
        assertFalse(bank.getBalance(player) == 1000);
    }

    @Test
    public void testDepositMethod() {
        //Given a player named John with 1000
        //When the bank deposits 553 to John`s balance
        //Then he should have 1553 as new balance
        //And balance != 0
        //And balance != 1000

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
        //Given a player named Anna with 1000 of balance
        //When the bank withdrawls 200 form to John`s balance
        //Then he should have 800 as new balance
        //And balance != 0
        //And balance != 1000
        bank.withdrawl(player, 200);
        assertEquals(800, bank.getBalance(player));

        //Given a player named Anna with 800 of balance
        //When the bank withdrawls 300 form to John`s balance
        //Then he should have 500 as new balance
        bank.withdrawl(player, 300);
        assertEquals(500, bank.getBalance(player));

        assertFalse(bank.getBalance(player) == 0);
        assertFalse(bank.getBalance(player) == 1000);
    }
}
