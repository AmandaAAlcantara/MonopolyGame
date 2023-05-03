package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerChecks {
    @ParameterizedTest
    @CsvSource({"Lovelace, 2, 2", "Hamilton, -3, -3", "Turing, 5, 5","Jane, 7, 7"})
    void setPosition_updatesPosition(String playerName, int playerPosition, int expectedPosition) {
        Player player = new Player(playerName);
        player.setPosition(playerPosition);
        assertEquals(expectedPosition, player.getPosition());
    }

    @ParameterizedTest
    @ValueSource(strings = {"James", "Gosling", "Rossum", "Sagan"})
    void getPlayer_returnsPlayerName(String playerName) {
        Player player = new Player(playerName);
        String actualPlayerName = player.getPlayer();
        assertEquals(playerName, actualPlayerName);
    }

    @ParameterizedTest
    @CsvSource({"Bill, 0", "Carl, 0", "Bob, 0"})
    void testPlayer(String name, int startingPosition) {
        Player player = new Player(name);
        assertEquals(name, player.getPlayer());
        assertEquals(startingPosition, player.getPosition());
    }


    @Test
    void setPosition_updatesPositionAndReturnsPlayer() {
        Player player = new Player("Alice");

        assertAll("Player position and name",
                () -> assertEquals(0, player.getPosition(), "Initial position should be 0"),
                () -> assertEquals("Alice", player.getPlayer(), "Player name should be 'Alice'")
        );

        player.setPosition(2);

        assertAll("Player position and name",
                () -> assertEquals(2, player.getPosition(), "Position should be updated to 2"),
                () -> assertEquals("Alice", player.getPlayer(), "Player name should still be 'Alice'")
        );
    }
}
