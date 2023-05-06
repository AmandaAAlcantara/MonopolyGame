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
        //Given player Lovelace/Hamilton/Turing/Jane are playing Monopoly
        //When the method getPosition is used
        //Then getPosition returns the same value as expected postion
        Player player = new Player(playerName);
        player.setPosition(playerPosition);
        assertEquals(expectedPosition, player.getPosition());
    }

    @ParameterizedTest
    @ValueSource(strings = {"James", "Gosling", "Rossum", "Sagan"})
    void getPlayerReturnsPlayerName(String playerName) {
        //Given player James/Gosling/Rossum/Sagan are playing Monopoly
        //When the method getPlayer is used
        //Then getPlayer return player name James/Gosling/Rossum/Sagan
        Player player = new Player(playerName);
        String actualPlayerName = player.getPlayer();
        assertEquals(playerName, actualPlayerName);
    }

    @ParameterizedTest
    @CsvSource({"Bill, 0", "Carl, 0", "Bob, 0"})
    void testPlayerNameAndPlayerPosition(String name, int startingPosition) {
        //Given player Bill/Carl/Bob is in position 0
        //When the methods getPlayer and getPosition are used
        //Then getPlayer return player name Bill/Carl/Bob and position in board 0
        Player player = new Player(name);
        assertEquals(name, player.getPlayer());
        assertEquals(startingPosition, player.getPosition());
    }


    @Test
    void setPositionUpdatePositionAndReturnsPlayer() {
        Player player = new Player("Alice");

        //Given a player named Alice
        //And Alice did not move in the board
        //And alice did not change name
        //When the method getPosition is used
        //And the method getPlayer is called
        //Then Alice`s position is 0 and the getPlayed returns the player Alice
        assertAll("Player position and name",
                () -> assertEquals(0, player.getPosition(), "All players should start in space  0"),
                () -> assertEquals("Alice", player.getPlayer(), "Player name = 'Alice'")
        );

        //Given a player named Alice
        //And Alice moved to the space number 3 in the board
        //And Alice did not change name
        //When the method getPosition is used
        //And the method getPlayer is called
        //Then Alice`s position is 3 and the getPlayed returns the player Alice
        player.setPosition(3);
        assertAll("Player position and name",
                () -> assertEquals(3, player.getPosition(), "Position updated to 3"),
                () -> assertEquals("Alice", player.getPlayer(), "Same player 'Alice'")
        );
    }
    @Test
    void getPlayerName() {
        Player player = new Player("Jose");

        //Given a player named Jose
        //When the method getName() is used
        //Then that the name returned should be Jose
        assertEquals("Jose", player.getName());
        assertFalse(player.getName()=="Anna");

    }

}
