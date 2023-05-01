package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Board;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    @Test
    void testBoardCreation() {
        //given
        Board board = new Board();

        //when
        // Test if the board is created and has 16 spaces
        assertEquals(10, board.spaces.size());

        for (int i = 1; i <= 10; i++) {
            String spaceName = board.getCurrentSpace(i);
            //then
            assertNotNull(spaceName);
            assertFalse(spaceName.isEmpty());
            // Verify that each space in the board are differentiated
        }
    }
        @Test
        void testGetCurrentSpace() {
            //given
            Board board = new Board();

            //when --- //then
            // Test that the getCurrentSpace() method returns the specific name (property, tax, station or road) related to the ID
            assertEquals("Home", board.getCurrentSpace(1));
            assertEquals("Road", board.getCurrentSpace(2));
            assertEquals("Copacabana", board.getCurrentSpace(3));
            assertEquals("Leblon", board.getCurrentSpace(4));
            assertEquals("Road", board.getCurrentSpace(5));
            assertEquals("Barra da Tijuca", board.getCurrentSpace(6));
            assertEquals("Ipanema", board.getCurrentSpace(7));
            assertEquals("Tax Office", board.getCurrentSpace(8));
            assertEquals("Road", board.getCurrentSpace(9));
            assertEquals("Train Station", board.getCurrentSpace(10));
        }

        @Test
        void testHashMapKeys() {
            //given
            Board board = new Board();
            Set<Integer> keys = board.spaces.keySet();
            Set<Integer> invalidKeys = new HashSet<>();
            //when
            for (int i = 1; i <= 10; i++) {
                if (!keys.contains(i)) {
                    invalidKeys.add(i);
                }
            }
            //then
            assertTrue(invalidKeys.isEmpty(), "Invalid spaces in board found: " + invalidKeys);
        }


    }