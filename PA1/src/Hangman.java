/**
 * This program runs a game of hangman.
 * CPSC 312-02, Fall 2019
 * Programming Assignment #1
 * No sources to cite
 *
 * @author Zach McKee
 * @version v1.0 9/5/19
 */

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Contains all code for the hangman game
 */
public class Hangman {

    private static char[] visibleLetters;
    private static String[] guessWords = {"grapefruit","monkey","sunglasses",
                                          "duck","jacket","pancreas","donkey",
                                          "refrigerator","automobile","pinecone"};
    private static String theWord;
    private static String guessedWords = "";
    private static boolean won = false;

    /**
     * Main method that starts and runs the game
     * @param args
     */
    public static void main(String[] args)
    {
        char[] availableLetters = {'a','b','c','d','e','f','g',
                                    'h','i','j','k','l','m','n',
                                    'o','p','q','r','s','t','u',
                                    'v','w','x','y','z'};
        //Initialize the remaining guesses variable
        //and get a random word
        int guessesRem = 7;
        Random r = new Random();
        int newWordIndex = r.nextInt(10);
        while(guessedWords.contains(newWordIndex + ""))
            newWordIndex = r.nextInt(10);
        theWord = guessWords[newWordIndex];
        guessedWords += newWordIndex;

        //Generate a string of dashs to represent the current attempt
        visibleLetters = new char[theWord.length()];
        for(int i = 0; i < visibleLetters.length; i++)
            visibleLetters [i] = '-';

        Scanner userIn = new Scanner(System.in);
        String curInput = "";
        System.out.println("\nThe word has " + theWord.length() + " letters to guess\n");
        //Game loop, keep running until out of guesses
        //or the game has been one
        while(guessesRem > 0 && !verifyDone())
        {
            System.out.println("\n" + getPrettyVisible());
            System.out.println("Available letters: " + getLetters(availableLetters));
            System.out.println(guessesRem + " incorrect guesses remaining.");
            System.out.print("Please enter your guess:");
            curInput = userIn.nextLine();
            curInput = curInput.toLowerCase();
            if(verifyInput(curInput))
            {
                if(verifyUnguessed(curInput, availableLetters)) {
                    if (theWord.contains(curInput))
                        System.out.println("Nice! \'" + curInput + "\' is in the word.");
                    else {
                        guessesRem--;
                        System.out.println("\'" + curInput + "\' is not in the string. Too bad. " + guessesRem +
                                            " incorrect guesses remaining.");
                    }
                    updateFields(curInput, availableLetters);
                }
                else
                    System.out.println("You've already guessed \'" + curInput + "\', try again");
            }
            else
                System.out.println("Invalid character(s) \'" + curInput + "\', please enter single letters only");
        }
        System.out.println();
        if(verifyDone())
            System.out.println("Congradulations! You guess the word \"" + getPrettyVisible() + "\" with " + guessesRem + " guesses remaining!");
        else
            System.out.println("Better luck next time! The word was \"" + theWord + "\".");
        System.out.println("\nWould you like to play again? (y/n)");
        String keepPlaying = userIn.nextLine();
        if (keepPlaying.equalsIgnoreCase("y")) {
            main(args);
        }
        userIn.close();
    }

    /**
     * Returns the available letters array in a pretty format
     *
     * @param availableLetters
     * @return The available letters array in a pretty format
     */
    public static String getLetters(char[] availableLetters)
    {
        String retString = "";
        for(char letter:availableLetters)
            retString += letter;
        return retString;
    }

    /**
     * Formats the guessed letters into a pretty string
     *
     * @return The guessed letters in a pretty format
     */
    public static String getPrettyVisible()
    {
        String retString = "";
        for(char c:visibleLetters)
            retString += c;
        return retString;
    }

    /**
     * Verifies the input given by curInput is valid (one char a-z)
     * @param curInput
     * @return True if the input is valid, false otherwise
     */
    public static boolean verifyInput(String curInput)
    {
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(curInput);
        return m.matches();
    }

    /**
     * Makes sure the input (curInput) has not been guessed yet
     * @param curInput
     * @param availableLetters
     * @return True if the char has not been guessed, otherwise false
     */
    public static boolean verifyUnguessed(String curInput, char[] availableLetters)
    {
        char curInputChar = curInput.toCharArray()[0];
        for(char curChar:availableLetters)
            if (curChar == curInputChar)
                return true;
        return false;
    }

    /**
     * Updates the availableLetters and visibleLetters fields to account
     * for new user input
     *
     * @param curInput
     * @param availableLetters
     */
    public static void updateFields(String curInput, char[] availableLetters)
    {
        int indexOfNewChar = theWord.indexOf(curInput);
        char curInputChar = curInput.toCharArray()[0];
        while(indexOfNewChar != -1)
        {
            visibleLetters[indexOfNewChar] = curInputChar;
            indexOfNewChar = theWord.indexOf(curInput, indexOfNewChar + 1);
        }
        availableLetters[curInputChar - 97] = ' ';
    }

    /**
     * Checks to see if the user has guessed the word
     *
     * @return True if the word has been guessed, otherwise false
     */
    public static boolean verifyDone()
    {
        for(char c:visibleLetters)
            if (c == '-')
                return false;
        return true;
    }

}
