package com.cm6123.monopoly.game;
import java.util.HashMap;

public class Properties {
    Player player;

    private HashMap<String, Integer> propertyPrice;
    private HashMap<String, String> propertyOwner;
    private HashMap<String, Integer> propertyRent;

    public Properties() {
        propertyPrice = new HashMap<String, Integer>();
        propertyOwner = new HashMap<String, String>();
        propertyRent = new HashMap<String, Integer>();
        setPropertyPrice();
        setPropertyOwner();
        setPropertyRent();
    }

    protected void addPropertyPrice(String property, Integer value) {
        propertyPrice.put(property, value);
    }

    protected void addPropertyOwner(String property, String owner) {
        propertyOwner.put(property, owner);
    }

    protected void addPropertyRent(String property, Integer rent) {
        propertyRent.put(property, rent);
    }

    public Integer getPropertyPrice(String property) {
        return propertyPrice.get(property);
    }

    public String getPropertyOwner(String property) {
        return propertyOwner.get(property);
    }

    public Integer getPropertyRent(String property) {
        return propertyRent.get(property);
    }

    public void setPropertyPrice(){
        addPropertyPrice("Copacabana",400);
        addPropertyPrice("Leblon",250);
        addPropertyPrice("Barra da Tijuca",150);
        addPropertyPrice("Ipanema",200);
    }

    public void setPropertyOwner(){
        addPropertyOwner("Copacabana",null);
        addPropertyOwner("Leblon",null);
        addPropertyOwner("Ipanema",null);
        addPropertyOwner("Barra da Tijuca", null);
    }

    public void setPropertyRent(){
        addPropertyRent("Copacabana", 40);
        addPropertyRent("Leblon", 25);
        addPropertyRent("Ipanema", 15);
        addPropertyRent("Barra da Tijuca", 20);
    }

}



