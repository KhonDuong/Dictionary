package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testCheckWord() {
        Dictionary dictionary = new Dictionary(new HashMap<String, String>());
        String correctWord = "arabesque tutelage";
        assertTrue("Checking whether a correct word is allowed to be added.", dictionary.checkWord(correctWord));
        String incorrectWord = "123 @@ #$ *!;";
        assertFalse("Checking whether an incorrect word is rejected.", dictionary.checkWord(incorrectWord));
    }

    public void testAddAndGetWord() {
        Dictionary dictionary = new Dictionary(new HashMap<String, String>());
        String correctWord = "arabesque tutelage";
        String correctDefinition = "this is a definition that is a definition that is a definition";
        dictionary.addWord(correctWord, correctDefinition);
        assertEquals("Testing whether adding a word then getting it returns the word.", correctWord + " : " + correctDefinition, dictionary.getWord(correctWord));
        String incorrectWord = "123 @@ #$ *!;";
        dictionary.addWord(incorrectWord, correctDefinition);
        assertEquals("Testing whether adding an incorrect word then getting it says that the word doesn't exist.", "We don't have the definition for that word.", dictionary.getWord(incorrectWord));
    }

    public void testRemoveWord() {
        Dictionary dictionary = new Dictionary(new HashMap<String, String>());
        String correctWord = "arabesque tutelage";
        String correctDefinition = "this is a definition that is a definition that is a definition";
        dictionary.addWord(correctWord, correctDefinition);
        dictionary.removeWord(correctWord);
        assertEquals("Testing whether removing the word worked.", "We don't have the definition for that word.", dictionary.getWord(correctWord));
    }

    public void testGetAllWords() {
        Dictionary dictionary = new Dictionary(new HashMap<String, String>());
        dictionary.addWord("erbium","a trivalent metallic element of the rare earth group");
        dictionary.addWord("nanometer", "a metric unit of length equal to one billionth of a meter");
        assertFalse("Testing whether getting all words returns words.", dictionary.getAllWords().isEmpty());
    }
}
