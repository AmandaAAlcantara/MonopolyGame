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


public class BankruptcyCheks {

    @Test
    public void testAccumulatedProperties() {
        Bank bank = new Bank();
        Player player = new Player("James");
        Properties properties = new Properties();
        properties.addPropertyOwner("Copacabana", "James");
        properties.addPropertyOwner("Leblon", "James");
        properties.addPropertyOwner("Barra da Tijuca", "James");
        properties.addPropertyOwner("Ipanema", "James");
        Bankruptcy bankruptcy = new Bankruptcy(bank, player, properties);
        int result = bankruptcy.accumulatedProperties(player);
        assertEquals(1000, result);
    }

    @Test
    public void testAccumulatedWealth() {
        Bank bank = new Bank();
        Player testPlayer = new Player("Carol");
        Properties properties = new Properties();
        Bankruptcy bankruptcy = new Bankruptcy(bank, testPlayer,properties);
        properties.addPropertyOwner("Ipanema", "Carol");
        properties.addPropertyOwner("Copacabana", "Carol");
        int result = bankruptcy.accumulatedWealth(testPlayer);
        assertEquals(1600,result);
    }

    @Test
    public void testsellAccumulatedWealth() {
        Bank bank = new Bank();
        Player testPlayer = new Player("Carol");
        Properties properties = new Properties();
        Bankruptcy bankruptcy = new Bankruptcy(bank, testPlayer,properties);
        properties.addPropertyOwner("Barra da Tijuca", "Carol");
        properties.addPropertyOwner("Ipanema", "Carol");
        properties.addPropertyOwner("Leblon", "Carol");
        properties.addPropertyOwner("Copacabana", "Carol");
        bankruptcy.sellProperty1(testPlayer);
        bankruptcy.sellProperty2(testPlayer);
        bankruptcy.sellProperty3(testPlayer);
        bankruptcy.sellProperty4(testPlayer);
        // check that the player's balance has increased by the price of the property minus 75
        assertEquals(1500, bank.getBalance(testPlayer));
    }

}
