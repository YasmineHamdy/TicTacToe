/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardGames;

import java.util.ArrayList;

/**
 *
 * @author menagabara
 */
public interface PlayerInterface {
    //available moves
    public int play(String []board, String stone, ArrayList<Integer> randomNo);
}
