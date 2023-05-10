package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Board;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    @Test
    void testBoardCreation() {
        Board board = new Board();

        //given the board constructed has 0 to 9 spaces
        //when looping trought the board
        //then the spaces 0 to 9 all have names

        assertEquals(10, board.spaces.size());

        for (int i = 0; i <= 9; i++) { //
            String spaceName = board.getCurrentSpace(i);
            //then
            assertNotNull(spaceName);
            assertFalse(spaceName.isEmpty()); //checking that the board is not empty
        }
    }
        @Test
        void testGetCurrentSpace() {
            Board board = new Board();

            //given the board constructed has 0 to 9 spaces
            //when the number of the space in the board is called
            //then the respective name of the space is displayed
            // Test that the getCurrentSpace() method returns the specific name (property, tax, station or road) related to the ID (space number)

            assertEquals("Home", board.getCurrentSpace(0));
            assertEquals("Road", board.getCurrentSpace(1));
            assertEquals("Copacabana", board.getCurrentSpace(2));
            assertEquals("Leblon", board.getCurrentSpace(3));
            assertEquals("Road", board.getCurrentSpace(4));
            assertEquals("Barra da Tijuca", board.getCurrentSpace(5));
            assertEquals("Ipanema", board.getCurrentSpace(6));
            assertEquals("Tax Office", board.getCurrentSpace(7));
            assertEquals("Road", board.getCurrentSpace(8));
            assertEquals("Train Station", board.getCurrentSpace(9));
        }

        @Test
        void testHashMapKeys() {
            //given the board constructed has 0 to 9 spaces
            //when looping trought the board
            //then only spaces from 0 to 9 are parts of the board

            //used ChatGPT 2 to understand how to implement keySet and HashSet in testing
            Board board = new Board();
            Set<Integer> keys = board.spaces.keySet();
            Set<Integer> invalidKeys = new HashSet<>();
            //when
            for (int i = 0; i <= 9; i++) {
                if (!keys.contains(i)) {
                    invalidKeys.add(i);
                }
            }
            assertTrue(invalidKeys.isEmpty(), "Invalid spaces (board does not contain this space): " + invalidKeys);
        }
    }

