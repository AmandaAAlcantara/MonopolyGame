package com.cm6123.monopoly;
import com.cm6123.monopoly.game.Properties;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PropertyCheck{

    @ParameterizedTest
    @CsvSource({ "Copacabana, 400, null, 40", "Leblon, 250, null, 25", "Barra da Tijuca, 150, null, 20","Ipanema, 200, null, 15"})
    void testGetValuesForProperty(String property, int price, String owner, int rent) {
        Properties properties = new Properties();
        assertEquals(price, properties.getPropertyPrice(property));
        assertNull(properties.getPropertyOwner(property));
        assertEquals(rent, properties.getPropertyRent(property));
    }

    @ParameterizedTest
    @CsvSource({"Leblon, 250, null, 25", "Ipanema, 200, null, 15"})
    void testGetValuesWhenPropertyOwned(String property, int price, String owner, int rent) {
        Properties properties = new Properties();
        assertEquals(price, properties.getPropertyPrice(property));
        assertTrue(properties.getPropertyOwner("Leblon")==null);
        assertTrue(properties.getPropertyOwner("Ipanema")==null);
        assertEquals(rent, properties.getPropertyRent(property));
    }


}







