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
        //Given a player named James
        //When James is defined as owner
        //of the Copacabana, Leblon, Barra da Tijuca and Ipanema properties
        //Then the added value of the accumulated properties should equal to 1000. (400+250+200+150)

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
        //Given a player named Carol with balance of 1000
        //When Carol is defined as the owner of the Ipanema and Copacabana properties
        //Then the accumulated weath of Carol is the balance + the value of the owned properties
        // (1000+400+200)

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
        //Given a player named Carol with balance of 1000
        //And owner of all the properties in Rio de Janeiro Monopoly
        //When Carol sells the properties she owns
        //Then she will get 50% of the value she bought the property for

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
