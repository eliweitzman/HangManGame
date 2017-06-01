/*
 * Noah Bereketab and Eli Weitzman
 * Guessing
 * 5/30/2017
 * JDK Version 1.8.0
 */

package playHangMan;

//Imports for Guessing class
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Guessing {

    public static void guess(String[] args) {
      
        Scanner keyboard = new Scanner(System.in);//Creating Scanner object 
        StringBuilder temp;//Initializing temp;
        //Creating dashes for number of letters
        if (PlayHangMan.word.length() > 0) {
            char[] array = new char[PlayHangMan.word.length()];
            Arrays.fill(array, '-');
            temp = new StringBuilder(new String(array));
        } else {
            temp = new StringBuilder();
        }
        int length = PlayHangMan.word.length();//Initializing length to length of word
        //For loop that runs while turn is less than length and increments up
        for (PlayHangMan.turn = 0; PlayHangMan.turn < length; PlayHangMan.turn++) {
            System.out.print("\nEnter your letter guess: ");//Ask user for guess
            String guess = keyboard.nextLine();//Save user guess
            //Check to see if guess entered is more than 1 letter
            if (guess.length() != 1) {
                System.out.println("Guesses must each be a single letter.");
                continue;
            }
            char c = guess.charAt(0);//Initalizing c to first letter of guess
            int i = 0;//Initalizing i to 0
            //If word does not contain guess then run statements
            if (!PlayHangMan.word.contains(guess)) {
                System.out.println(temp.toString());//Printing temp
                System.out.println("Inorrect");//States incorrect
                HangMan.drawing.setUp();//Calls setUp() method for gui
                PlayHangMan.counter++;//Increments counter
                HangMan.drawing.repaint();//Calls the gui
                PlayHangMan.turn--;//Removes 1 from turn 
                if (PlayHangMan.counter == 10) {//If counter reaches 10 then break
                    break;
                }

            }//For loop that creates index for word and increments up
            for (i = PlayHangMan.word.indexOf(c); i >= 0; i
                    = PlayHangMan.word.indexOf(c, i + 1)) {
                temp.setCharAt(i, c);//Setting where to change letter for temp
                System.out.println(temp.toString());//Printing temp with new letters
                System.out.println("You got a letter!");//States user guessed correctly
            }
            //If all letters of word filled then user wins
            if (PlayHangMan.word.equals(temp.toString())) {
                System.out.println("\nYou won!");
                break;
            }

        }//Asks user to play again
        String again = JOptionPane.showInputDialog(null,
                "Would you like to play"
                + " again!" + "\nType yes or no!");
        //If user types "yes" then counter is reset and methods are recalled
        if (again.equalsIgnoreCase("yes")) {
            PlayHangMan.intro();
            PlayHangMan.counter = 0;
            Guessing.guess(args);
         //If user types anything else then the program will end
        } else {
            System.exit(0);
        }

    }

}
