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

        //binary search to search for the word the user entered 

        //Add function to exchange a letter


    }

}