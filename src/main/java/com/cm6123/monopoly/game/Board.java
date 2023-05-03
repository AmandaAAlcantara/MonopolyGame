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
