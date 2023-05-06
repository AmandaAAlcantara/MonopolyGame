package com.cm6123.monopoly.game;
import java.util.HashMap;

public class Board {
    /**
     * Creating a HashMap to store the names and spaces for the monopoly game.
     */
    public HashMap<Integer, String> spaces;
    /**
     * The Bord() constructor initializes the spaces instance variable as a new empty HashMap and then initializes the game board with theBoard().
     */
    public Board(){
        spaces = new HashMap<>();
        theBoard();
    }
    /**
     * Creating method to add the spaces HashMap object in the Board class with the number and name of the space.
     * @param space **this is**
     * @param numberID **this is**
     */
    protected void boardSpaces(final int numberID, final String space) {
        spaces.put(numberID, space);
    }
    /**
     * Method so that, based on the position of the player, the code shows which space name is located.
     * @param numberID ** this is **
     * @return spaces.get(numberID)
     */
    public String getCurrentSpace(final Integer numberID) {
        return spaces.get(numberID);
    }
    /**
     * Adding the specific names and space numbers to the board (HashMap).
     */
    public void theBoard(){
        boardSpaces(0,"Home");
        boardSpaces(1,"Road");
        boardSpaces(2,"Copacabana");
        boardSpaces(3,"Leblon");
        boardSpaces(4,"Road");
        boardSpaces(5,"Barra da Tijuca");
        boardSpaces(6,"Ipanema");
        boardSpaces(7,"Tax Office");
        boardSpaces(8,"Road");
        boardSpaces(9,"Train Station");
    }
}
