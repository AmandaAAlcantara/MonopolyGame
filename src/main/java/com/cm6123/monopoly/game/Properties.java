package com.cm6123.monopoly.game;
import java.util.HashMap;

public class Properties {
    /**
     * Defining the name of the spaces (number and name).
     */
    Player player;
    /**
     * Defining the name of the spaces (number and name).
     */
    private HashMap<String, Integer> propertyPrice;
    /**
     * Defining the name of the spaces (number and name).
     */
    private HashMap<String, String> propertyOwner;
    /**
     * Defining the name of the spaces (number and name).
     */
    private HashMap<String, Integer> propertyRent;
    /**
     * Defining the name of the spaces (number and name).
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
     * Defining the name of the spaces (number and name).
     * @param property **this is**
     * @param value **this is**
     */
    protected void addPropertyPrice(final String property, final Integer value) {
        propertyPrice.put(property, value);
    }

    protected void addPropertyOwner(final String property, final String owner) {
        propertyOwner.put(property, owner);
    }

    protected void addPropertyRent(final String property, final Integer rent) {
        propertyRent.put(property, rent);
    }
    /**
     * Defining the name of the spaces (number and name).
     * @param property **this is**
     * @return propertyPrice.get(property)
     */
    public Integer getPropertyPrice(final String property) {
        return propertyPrice.get(property);
    }
    /**
     * Defining the name of the spaces (number and name).
     * @param property **this is**
     * @return propertyOwner.get(property)
     */
    public String getPropertyOwner(final String property) {
        return propertyOwner.get(property);
    }
    /**
     * Defining the name of the spaces (number and name).
     * @return propertyRent.get(property)
     * @param property **this is**
     */
    public Integer getPropertyRent(final String property) {
        return propertyRent.get(property);
    }
    /**
     * Defining the name of the spaces (number and name).
     */
    public void setPropertyPrice(){
        addPropertyPrice("Copacabana",400);
        addPropertyPrice("Leblon",250);
        addPropertyPrice("Barra da Tijuca",150);
        addPropertyPrice("Ipanema",200);
    }
    /**
     * Defining the name of the spaces (number and name).
     */
    public void setPropertyOwner(){
        addPropertyOwner("Copacabana",null);
        addPropertyOwner("Leblon",null);
        addPropertyOwner("Ipanema",null);
        addPropertyOwner("Barra da Tijuca", null);
    }
    /**
     * Defining the name of the spaces (number and name).
     */
    public void setPropertyRent(){
        addPropertyRent("Copacabana", 40);
        addPropertyRent("Leblon", 25);
        addPropertyRent("Ipanema", 15);
        addPropertyRent("Barra da Tijuca", 20);
    }

}



