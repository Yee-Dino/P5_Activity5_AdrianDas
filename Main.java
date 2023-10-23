//Anagrams
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
* Authors: Aditya Das and Jonathan Adrian
* Date: October 22, 2023
* The game infinitely spits out different anagrams and you have to type out the words. If you fail, the game ends.
*/
class Main {
  public static void main(String[] args) {
    String introMessage = "Welcome to Anagrams! Type an anagram of the word you see within the time limit! Try to type as many as you can! An anagram is a word formed by using the letters of another word.";

    System.out.println(introMessage);
    String dictionaryWords = loadFile("WordList.csv");

                 
    String[] words = {"strain", "caters", "denter", "enlist", "poodle", "master", "starer", "rested", "spread", "points", "chaser", "stable", "remain", "assert", "learnt", "secant", "dilate"};


    boolean continueGame = true;
    while(continueGame == true){
      String word = words[(int)(Math.random() * words.length)];
      System.out.println(word);
      continueGame = isAnagram(word, dictionaryWords);
    }

  }


  public static boolean isAnagram(String word, String dictionaryWords) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter guess: ");
    String guess = sc.nextLine();
    ArrayList<Character> guessArr = new ArrayList<Character>();
    for (char c : guess.toCharArray()) {
        guessArr.add(c);
    }
    ArrayList<Character> wordArr = new ArrayList<Character>();
    for (char c : word.toCharArray()) {
        wordArr.add(c);
    }
    if (dictionaryWords.contains(guess)) {
      if (!guessArr.equals(wordArr)) {
        guessArr.sort(null);
        wordArr.sort(null);
        if(guessArr.equals(wordArr)) {
          System.out.println("Is anagram!\n\n");
          return true;
        }
        else {
          System.out.println("Is not anagram because wrong letters");
          return false;
        }
      }
      else {
        System.out.println("You entered the same word");
        return false;
      }
    }
    else {
      System.out.println("Not real word, you lost!");
      return false;
    }



  }



  private static String loadFile(String fileName) {
    String contents = "";
    try {
      BufferedReader input = new BufferedReader(new FileReader(fileName));
      String line;
      while ((line = input.readLine()) != null) {
          contents += line + "\n";
      }
  
      input.close();
    } catch (Exception e) {
      System.out.println("Unable to locate or read " + fileName);
    }
  
    return contents.trim();
    }
}
