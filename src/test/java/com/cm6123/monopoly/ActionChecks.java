package com.cm6123.monopoly;

import com.cm6123.monopoly.dice.Dice;
import com.cm6123.monopoly.game.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import org.mockito.Mockito.*;

public class ActionChecks {

    @Test
    public void testMoveToSpaceUtilitySpace() {
        Bank bank = new Bank();
        Board board = new Board();
        Action action = new Action(bank, board);
        Player player = new Player("Bob");
        int initialBalance = bank.getBalance(player);

        // Move player to Home space, check if player received 200
        action.moveToSpace(player, 0);
        int newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200, newBalance);

        // Move player to Copacabana space, check if player balance has decreased by 400
        action.moveToSpace(player, 1);
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200, newBalance);

        // Move player to Copacabana space, check if player balance has decreased by 400
        action.moveToSpace(player, 2);
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200 - 400, newBalance);

        // Move player to Leblon space, check if player balance has decreased by 250
        action.moveToSpace(player, 3);
        // Check if player balance has decreased by 250
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200 - 400 - 250, newBalance);

        // Move player to Barra da Tijuca space, check if player balance has decreased by 150
        action.moveToSpace(player, 5);
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200 - 400 - 250 - 150, newBalance);

        // Move player to Ipanema space, check if player balance has decreased by 200
        action.moveToSpace(player, 6);
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200 - 400 - 250 - 150 - 200, newBalance);
    }

    @Test
    void testIfPlayerMovesWithMoveMethod() {
        //Given a player named Toby
        Player player = new Player("Toby");
        Board board = new Board();
        Bank bank = new Bank();
        //When the method move(player) is called
        Action action = new Action(bank, board);
        //Then the player should move more the 0 spaces as minimum spaces to move is 2 (1+1)
        Assertions.assertTrue(action.move(player)>0);
        //And---Then the player should not move more the 13 spaces as max spaces to move is 12 (6+6)
        Assertions.assertFalse(action.move(player)>13);
        }

    @Test
    void testIfPlayerInTrainStation() {
        // if the dice does not run then the player stays with the value it had. The ticket depends on the value of the dice.
        Bank bank = new Bank();
        Board board = new Board();
        Action action = new Action(bank, board);
        Player player = new Player("Amy");
        int initialBalance = bank.getBalance(player);

        action.moveToSpace(player, 9);
        int newBalance = bank.getBalance(player);
        Assertions.assertEquals((initialBalance), newBalance);
    }
    @Test
    void TestTax() {
        Bank bank = new Bank();
        Board board = new Board();
        Action action = new Action(bank, board);
        Player player = new Player("Amy");
        int initialBalance = bank.getBalance(player);

        action.moveToSpace(player, 7);
        int newBalance = bank.getBalance(player);
        Assertions.assertTrue(newBalance<=990);
    }

    @Test
    public void testTaxOfficeFirstRollEqualToSecondRoll() {
        Bank bank = new Bank();
        Board board = new Board();
        Action action = new Action(bank, board);
        Player player = new Player("Player A");
        action.moveToSpace(player, 7);
        assertEquals(950, bank.getBalance(player));
    }
    @Test
    public void testTaxOfficeFirstRollDiffToSecondRoll() {
        Bank bank = new Bank();
        Board board = new Board();
        Action action = new Action(bank, board);
        Player player = new Player("Player B");
        int theFirstRoll = 3;
        int theSecondRoll = 4;
        int numSpacesToMove = theFirstRoll + theSecondRoll;
        int newPosition = action.movePlayer(player, theFirstRoll, theSecondRoll, numSpacesToMove);
        action.moveToSpace(player, newPosition);
        assertEquals(900, bank.getBalance(player));
    }
}





