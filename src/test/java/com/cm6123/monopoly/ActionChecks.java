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

        //given a player with the initial balance of 1000
        //when the player lands on the space 0 = Home
        //then the player receives 200
        //and then the plaayer balance (+200)
        action.moveToSpace(player, 0);
        int newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200, newBalance);

        //given a player with the initial balance of 1000
        //when the player lands on the space 1 = Road
        //then the player stays with the same balance
        action.moveToSpace(player, 1);
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200, newBalance);

        //given a player with the initial balance of 1000
        //when the player lands on the space 2 = the copacabana property
        //then the player pays 400 if they want to buy the property
        //and then the player balance (-400)
        action.moveToSpace(player, 2);
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200 - 400, newBalance);

        //given a player with the initial balance of 1000
        //when the player lands on the space 3 = the leblon property
        //then the player pays 250 if they want to buy the property
        //and then the player balance (-250)
        action.moveToSpace(player, 3);
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200 - 400 - 250, newBalance);

        //given a player with the initial balance of 1000
        //when the player lands on the space 5 = the Ipanema property
        //then the player pays 150 if they want to buy the property
        //and then the player balance (-150)
        action.moveToSpace(player, 5);
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200 - 400 - 250 - 150, newBalance);

        //given a player with the initial balance of 1000
        //when the player lands on the space 6 = the Barra da Tijuca property
        //then the player pays 200 if they want to buy the property
        //and then player final balance (-200)
        action.moveToSpace(player, 6);
        newBalance = bank.getBalance(player);
        Assertions.assertEquals(initialBalance + 200 - 400 - 250 - 150 - 200, newBalance);
    }

    @Test
    void testIfPlayerMovesWithMoveMethod() {
        //Given a player named Toby
        //When the method move(player) is called
        //Then the player should move to the space >0 as the spaces go from 0 to 9
        //And then the player should not move more than 9 spaces as the board number goes from 0 t0 9
        Player player = new Player("Toby");
        Board board = new Board();
        Bank bank = new Bank();
        Action action = new Action(bank, board);
        Assertions.assertTrue(action.move(player)>0);
        Assertions.assertFalse(action.move(player)>9);
        }

    @Test
    void testIfPlayerInTrainStation() {
        // If the dice does not run then the player stays with the value it had.
        // The ticket depends on the value of the dice.

        //Given a player named Amy
        //When Amy is placed in the space 9
        //Then the balance should not change (remains 1000) as the ticked depends on the dice roll
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
    public void testTaxOfficeFirstRollEqualToSecondRoll() {
        //Given a player named Player A with 1000
        //And dice value 1 == dice value 2
        //When Player A is placed in the space 7
        //Then the value charged (the tax fee) should be 5% of the balance of Player A
        Bank bank = new Bank();
        Board board = new Board();
        Action action = new Action(bank, board);
        Player player = new Player("Player A");
        action.moveToSpace(player, 7);
        assertEquals(950, bank.getBalance(player));
    }
    @Test
    public void testTaxOfficeFirstRollDiffToSecondRoll() {
        //Given a player named Player B with 1000
        //And dice value 1 != dice value 2
        //When Player B is placed in the space 7
        //Then the value charged (the tax fee) should be 10% of the balance of Player B
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




