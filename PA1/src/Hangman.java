import java.util.Random;
public class Hangman {
    private static char[] availableLetters;
    private static char[] visibleLetters = {'a','b','c','d','e','f','g',
                                            'h','i','j','k','l','m','n',
                                            'o','p','q','r','s','t','u',
                                            'v','w','x','y','z'};
    private static String[] guessWords = {"grapefruit","monkey","sunglasses",
                                          "duck","jacket","pancreas","donkey",
                                          "refrigerator","automobile","pinecone"};
    static int guessRem;
    static String theWord;
    public static void main(String[] args)
    {
        guessRem = 7;
        Random r = new Random();
        theWord = guessWords[r.nextInt(10) - 1];
        System.out.println(theWord);
    }
}
