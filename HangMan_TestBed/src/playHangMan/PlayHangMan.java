/*
 * Noah Bereketab and Eli Weitzman
 * PlayHangMan
 * 5/30/2017
 * JDK Version 1.8.0
 */

package playHangMan;

//Imports for PlayHangMan class
import javax.swing.*;

public class PlayHangMan {

    //Declaring public variable word
    public static String word;
    //Initalizing public variable counter
    public static int counter = 0;
    //Initalizing public variable turn
    public static int turn = 0;

    public static void intro() {
        //Introducing game to user
        JOptionPane.showMessageDialog(null, "Welcome to HANGMAN!:"
                + "\nA Game By Noah Bereketab and Eli Weitzman");
        //Saving user imput in word
        word = JOptionPane.showInputDialog(null, "Enter a word for HANGMAN!");
    }

}
