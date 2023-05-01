package com.cm6123.monopoly;

import com.cm6123.monopoly.game.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActionChecks {

    @Test
    public void testMoveToSpace_Home() {
        Bank bank = new Bank();
        Board board = new Board();
        Action action = new Action(bank, board);

        Player player = new Player("Alice");
        int initialBalance = bank.getBalance(player);

        // Move player to Home space
        action.moveToSpace(player, 1);

        // Check if player balance has increased by 200
        int newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200, newBalance);
    }

    @Test
    public void testMoveToSpace_UtilitySpace() {
        Bank bank = new Bank();
        Board board = new Board();
        Action action = new Action(bank, board);

        Player player = new Player("Bob");
        int initialBalance = bank.getBalance(player);

        // Move player to Copacabana space
        action.moveToSpace(player, 3);

        // Check if player balance has decreased by 400
        int newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance - 400, newBalance);

        // Move player to Leblon space
        action.moveToSpace(player, 4);

        // Check if player balance has decreased by 250
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance - 400 - 250, newBalance);

        // Move player to Barra da Tijuca space
        action.moveToSpace(player, 6);

        // Check if player balance has decreased by 150
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance - 400 - 250 - 150, newBalance);

        // Move player to Ipanema space
        action.moveToSpace(player, 7);

        // Check if player balance has decreased by 200
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance - 400 - 250 - 150 - 200, newBalance);

        // Move player to Tax Office space
        action.moveToSpace(player, 8);

        // Check if player balance has decreased by 100
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance - 400 - 250 - 150 - 200 - 100, newBalance);
    }
}
