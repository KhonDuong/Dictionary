package org.example;

import java.util.HashMap;
import java.util.Scanner;
import org.tinylog.Logger;

public class App
{
    public static void main(String[] args) {
        Logger.info("Started up the Dictionary app.");
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary(new HashMap<String, String>());
        addSampleWords(dictionary);

        String instructionPrompt = "Enter 1 to add a word, 2 to look up a word, 3 to remove a word, 4 to list all words and their definitions.";
        String addPromptWord = "Write the name of the word you want.";
        String addPromptDefinition = "Write the definition of the word.";
        String lookupPrompt = "What word do you want to know the definition of?";
        String removePrompt = "What word do you want to remove?";
        String listAllPrompt = "Here are all the words we have and their definitions.";
        String word, definition;

        while (true) {
            System.out.println(instructionPrompt);
            int userChoice = 0;
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
            }

            switch (userChoice) {
                case 1: // Add a word
                    System.out.println(addPromptWord);
                    word = scanner.nextLine();
                    System.out.println(addPromptDefinition);
                    definition = scanner.nextLine();
                    dictionary.addWord(word, definition);
                    System.out.println(dictionary.getWord(word));
                    Logger.info("Added the word \"" + word + "\" to the dictionary.");
                    break;
                case 2: // Look up a word
                    System.out.println(lookupPrompt);
                    word = scanner.nextLine();
                    System.out.println(dictionary.getWord(word));
                    Logger.info("Looked up the word \"" + word + "\" from the dictionary.");
                    break;
                case 3: // Remove a word
                    System.out.println(removePrompt);
                    word = scanner.nextLine();
                    dictionary.removeWord(word);
                    Logger.info("Removed the word \"" + word + "\" from the dictionary.");
                    break;
                case 4: // Listed all words
                    System.out.println(listAllPrompt);
                    System.out.println(dictionary.getAllWords());
                    Logger.info("Listed all words from the dictionary.");
                    break;
                default:
                    Logger.error("The user entered an invalid option.");
                    System.out.println("You entered an invalid option.");
            }
        }
    }

    public static void addSampleWords(Dictionary dictionary)
    {
        dictionary.addWord("erbium","a trivalent metallic element of the rare earth group");
        dictionary.addWord("nanometer", "a metric unit of length equal to one billionth of a meter");
        dictionary.addWord("transdermal", "through the unbroken skin");
        dictionary.addWord("yttrium", "a silvery metallic element that is common in rare-earth minerals; used in magnesium and aluminum alloys");
        dictionary.addWord("hypodermic needle", "a hollow needle");
        dictionary.addWord("wavelength", "a way of thinking or coming to mutual understanding");
        dictionary.addWord("epidermal", "of or relating to a cuticle or cuticula");
        dictionary.addWord("tensile strength", "the strength of material expressed as the greatest longitudinal stress it can bear without tearing apart");
        dictionary.addWord("hypodermic", "a piston syringe that is fitted with a needle for injections");
        dictionary.addWord("guinea", "a former British gold coin worth 21 shillings");
        dictionary.addWord("jab", "poke or thrust abruptly");
        dictionary.addWord("penetration", "the act of entering into or through something");
        dictionary.addWord("aerospace", "the atmosphere and outer space considered as a whole");
        dictionary.addWord("piston", "mechanical device that has a plunging or thrusting motion");
        dictionary.addWord("garnet", "any of a group of hard glassy minerals (silicates of various metals) used as gemstones and as an abrasive");
        dictionary.addWord("facial", "of or concerning the front of the head");
        dictionary.addWord("colleague", "an associate that one works with");
        dictionary.addWord("Seoul", "the capital of South Korea and the largest city of Asia");
        dictionary.addWord("motor neuron", "a neuron conducting impulses outwards from the brain or spinal cord");
    }
}
