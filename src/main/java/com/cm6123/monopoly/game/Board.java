package com.cm6123.monopoly.game;
import java.util.HashMap;


public class Board {
    /**
     * Creating a HashMap to store the names and spaces for the monopoly game.
     */
    public HashMap<Integer, String> spaces;
    /**
     * Defining the name of the spaces (number and name).
     */
    public Board(){
        spaces = new HashMap<>();
        theBoard();
    }
    protected void boardSpaces(final int numberID, final String space) {
        spaces.put(numberID, space);
    }
    /**
     * Method so that based on the position of the player, the code shows which space name t is located.
     * @param numberID ** this is **
     * @return spaces.get(numberID)
     */
    public String getCurrentSpace(final Integer numberID) {
        return spaces.get(numberID);
    }
    /**
     * Adding the specific names and space numbers to the board.
     */

    public void theBoard(){
        boardSpaces(1,"Home");
        boardSpaces(2,"Road");
        boardSpaces(3,"Copacabana");
        boardSpaces(4,"Leblon");
        boardSpaces(5,"Road");
        boardSpaces(6,"Barra da Tijuca");
        boardSpaces(7,"Ipanema");
        boardSpaces(8,"Tax Office");
        boardSpaces(9,"Road");
        boardSpaces(10,"Train Station");
    }

}

