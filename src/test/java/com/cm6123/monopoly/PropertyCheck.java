package com.cm6123.monopoly;
import com.cm6123.monopoly.game.Properties;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PropertyCheck{

    @ParameterizedTest
    //CsvSource use in testGetValuesForProperty Test adapted from: https://junit.org/junit5/docs/5.8.1/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/CsvSource.html
    //Access: 3 May 2023
    @CsvSource({ "Copacabana, 400, null, 40", "Leblon, 250, null, 25", "Barra da Tijuca, 150, null, 20","Ipanema, 200, null, 15"})
    void testGetValuesForProperty(String property, int price, String owner, int rent) {

        //Given properties Copacabana/Leblon/Barra da Tijuca/Ipanema
        //When the methods getPropoertyPrice, getPropertyOwner and getPropertyRent are called
        //Then the property price is equal to the values defined beforehand
        //And the Owner is null
        //And the Rent is equal to the values defined beforehand
        Properties properties = new Properties();
        assertEquals(price, properties.getPropertyPrice(property));
        assertNull(properties.getPropertyOwner(property));
        assertEquals(rent, properties.getPropertyRent(property));
    }

    @ParameterizedTest
    //CsvSource use in testGetValuesWhenPropertyOwned Test adapted from: https://junit.org/junit5/docs/5.8.1/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/CsvSource.html
    //Access: 3 May 2023
    @CsvSource({"Leblon, 250, null, 25", "Ipanema, 200, null, 15"})
    void testGetValuesWhenPropertyOwned(String property, int price, String owner, int rent) {

        //Given properties Leblon/Ipanema
        //When the methods getPropoertyPrice, getPropertyOwner and getPropertyRent are called
        //Then the property price is equal to the values defined beforehand
        //And the Owner is null
        //And the Rent is equal to the values defined beforehand
        Properties properties = new Properties();
        assertEquals(price, properties.getPropertyPrice(property));
        assertTrue(properties.getPropertyOwner("Leblon")==null);
        assertTrue(properties.getPropertyOwner("Ipanema")==null);
        assertEquals(rent, properties.getPropertyRent(property));
    }
}








