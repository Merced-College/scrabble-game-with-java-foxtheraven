//Xandra Quevedo
//10-14-2025
//CPSC-39 - Scrabble game with binary search and OOD

//make an improvement of some kind

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ScrabbleGame {

    //Data structure to hold the dictionary
    private static List<Word> dictionary = new ArrayList<Word>();

    public static void main(String[] args) {

        //Read text file of words and defs into the ArrayList
        //  (Try catch ensures our program does not implode
        //  if the file is not found)
        Scanner input = null;
        try {
            input = new Scanner(new File("ScrabbleWordList.txt"));
            while(input.hasNextLine()) {
                String word = input.next();
                //Trim removes all whitespace
                String definition = input.nextLine().trim();
                dictionary.add(new Word(word, definition));
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("error");
			e.printStackTrace();
        }

        //Print the dictionary
        //Commenting this out because eeyikes
        /*
        for (Word w : dictionary) {
            System.out.println(w);
        }
        */

        System.out.println("Your four letters:");

        //Use Random to generate a random letter, using ASCII codes (A is 65, Z is 90)
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int randomInt = random.nextInt(90 - 65 + 1) + 65;
            char randomChar = (char) randomInt;
            System.out.print(randomChar + " ");
        }

        System.out.println();
        System.out.println("Enter a word using the four letters:");

        Scanner scnr = new Scanner(System.in);
        String userWord = scnr.next();
        System.out.println("Your word: " + userWord);

        Word word1 = new Word(userWord, "N/A");

        boolean found = BinarySearch(dictionary, word1);

        if (found) {
            System.out.println("Valid word - congrats!");
            int points = word1.getPoints(userWord);

            if (points > 1) {
                System.out.println("You earned " + points + " points!");
            }
            else {
                System.out.println("You earned " + points + " point!");
            }
        }
        else {
            System.out.println("Invalid word - sorry!");
        }

        scnr.close();


    }

    //Binary search method - returns true if the user word is found in the 
    //dictionary, false if not
    public static boolean BinarySearch(List<Word> dictionary, Word key) {

        int low = 0;
        int high = dictionary.size() - 1;

        while (high >= low) {
            int mid = (low + high) / 2;

            //Current middle word
            Word midWord = dictionary.get(mid);

            //Compare user word to current middle word
            int wordCompare = key.compareTo(midWord);

            //If user word is alphabetically smaller than the
            //middle word, then search lower half of array
            if(wordCompare < 0) {
                high = mid - 1;
            }
            //If user word is alphabetically larger than the
            //middle word, then search upper half of array
            else if(wordCompare > 0) {
                low = mid + 1;
            }
            //If user word matches the current middle word in
            //the dictionary, then the word is found
            else if(wordCompare == 0) {
                return true;
            }
        }

        //Word not found
        return false;
    }

}