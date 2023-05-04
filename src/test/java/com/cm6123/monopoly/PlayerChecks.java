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
    void setPositionUpdatesPosition(String playerName, int playerPosition, int expectedPosition) {
        Player player = new Player(playerName);
        player.setPosition(playerPosition);
        assertEquals(expectedPosition, player.getPosition());
    }

    @ParameterizedTest
    @ValueSource(strings = {"James", "Gosling", "Rossum", "Sagan"})
    void getPlayerReturnsPlayerName(String playerName) {
        Player player = new Player(playerName);
        String actualPlayerName = player.getPlayer();
        assertEquals(playerName, actualPlayerName);
    }

    @ParameterizedTest
    @CsvSource({"Bill, 0", "Carl, 0", "Bob, 0"})
    void testPlayerNameAndPlayerPosition(String name, int startingPosition) {
        Player player = new Player(name);
        assertEquals(name, player.getPlayer());
        assertEquals(startingPosition, player.getPosition());
    }


    @Test
    void setPositionUpdatePositionAndReturnsPlayer() {
        Player player = new Player("Alice");

        assertAll("Player position and name",
                () -> assertEquals(0, player.getPosition(), "All players should start in space  0"),
                () -> assertEquals("Alice", player.getPlayer(), "Player name = 'Alice'")
        );

        player.setPosition(3);

        assertAll("Player position and name",
                () -> assertEquals(3, player.getPosition(), "Position updated to 3"),
                () -> assertEquals("Alice", player.getPlayer(), "Same player 'Alice'")
        );
    }
    @Test
    void getPlayerName() {
        Player player = new Player("Jose");
        assertEquals("Jose", player.getName());
        assertFalse(player.getName()=="Anna");

    }

}
