package com.cm6123.monopoly.game;
import java.util.HashMap;
// Used code from Week 9 Sessions of the "Fundamental of Computing with Java" module as reference for use of external libraries.
public class Properties {
    /**
     * Declaring a private instance variable called player of type Player.
     */
    private Player player;
    /**
     * Creating a variable propertyPrice as a HashMap to stores the price of different properties, where
     * the keys are the names of the properties and the values are the prices.
     */
    private HashMap<String, Integer> propertyPrice;
    /**
     * Creating a variable propertyOwner as a HashMap to stores the owner of different properties, where
     * the keys are the names of the properties and the values are the names of the owners.
     */
    private HashMap<String, String> propertyOwner;
    /**
     * Creating a variable propertyRent as a HashMap to stores the rent of different properties, where
     * the keys are the names of the properties and the values are the rents.
     */
    private HashMap<String, Integer> propertyRent;
    /**
     * Creating a constructor to initialize the instance variables propertyPrice, propertyOwner, and propertyRent
     * as new HashMaps and initializing their values using the setPropertyPrice, setPropertyOwner, and setPropertyRent.
     */
    public Properties() {
        propertyPrice = new HashMap<String, Integer>();
        propertyOwner = new HashMap<String, String>();
        propertyRent = new HashMap<String, Integer>();
        setPropertyPrice();
        setPropertyOwner();
        setPropertyRent();
    }
    /**
     * Creating a method to populate the propertyPrice HashMap object with the different prices of the properties.
     * @param property **this is**
     * @param value **this is**
     */
    protected void addPropertyPrice(final String property, final Integer value) {
        propertyPrice.put(property, value);
    }
    /**
     * Creating a method to populate the propertyOwner HashMap object with the different owners of the properties.
     * @param property **this is**
     * @param owner **this is**
     */
    //Code for update owner, price and rent inspired by https://stackoverflow.com/questions/4157972/how-to-update-a-value-given-a-key-in-a-hashmap. [Access: 5 Apr 2023]
    public void addPropertyOwner(final String property, final String owner) {
        propertyOwner.put(property, owner);
    }
    /**
     * Creating a method to populate the propertyRent HashMap object with the different rents of the properties.
     * @param property **this is**
     * @param rent **this is**
     */
    protected void addPropertyRent(final String property, final Integer rent) {
        propertyRent.put(property, rent);
    }
    /**
     * Creating a method to retrieve the price of a specific property in the monopoly game by providing the name of the property.
     * @param property **this is**
     * @return propertyPrice.get(property)
     */
    public Integer getPropertyPrice(final String property) {
        return propertyPrice.get(property);
    }
    /**
     * Creating a method to retrieve the owner of a specific property in the monopoly game by providing the name of the property.
     * @param property **this is**
     * @return propertyOwner.get(property)
     */
    public String getPropertyOwner(final String property) {
        return propertyOwner.get(property);
    }
    /**
     * Creating a method to retrieve the rent of a specific property in the monopoly game by providing the name of the property.
     * @return propertyRent.get(property)
     * @param property **this is**
     */
    public Integer getPropertyRent(final String property) {
        return propertyRent.get(property);
    }
    /**
     * Populating the propertyPrice HashMap with the prices of each property.
     */
    public void setPropertyPrice(){
        addPropertyPrice("Copacabana",400);
        addPropertyPrice("Leblon",250);
        addPropertyPrice("Barra da Tijuca",150);
        addPropertyPrice("Ipanema",200);
    }
    /**
     * Populating the propertyOwner HashMap with null so that later on the owner can be assigned later.
     */
    public void setPropertyOwner(){
        addPropertyOwner("Copacabana",null);
        addPropertyOwner("Leblon",null);
        addPropertyOwner("Ipanema",null);
        addPropertyOwner("Barra da Tijuca", null);
    }
    /**
     * Populating the propertyRent HashMap with the specific rent of each property.
     */
    public void setPropertyRent(){
        addPropertyRent("Copacabana", 40);
        addPropertyRent("Leblon", 25);
        addPropertyRent("Ipanema", 15);
        addPropertyRent("Barra da Tijuca", 20);
    }
}



