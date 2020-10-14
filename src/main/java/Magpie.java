/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response;
        if (statement.contains("I want to ")) {
            response = transformIWantToStatement(statement);
        } else if (statement.contains("I want ")) {
            response = transformIWantStatement(statement);
        } else if (statement.contains(" you") && statement.contains("I ")) {
            response = transformIYouStatement(statement);
        } else if (statement.contains("you ") && statement.contains(" me")) {
            response = transformYouMeStatement(statement);
        } else if (findWord(statement, "no") >= 0) {
            response = "Why so negative?";
        } else if (findWord(statement, "mother") >= 0 || findWord(statement, "father") >= 0 || findWord(statement, "brother") >= 0 || findWord(statement, "sister") >= 0) {
            response = "Tell me more about your family.";
        } else if (findWord(statement, "cat") >= 0 || findWord(statement, "dog") >= 0) {
            response = "Tell me more about your pets.";
        } else if (findWord(statement, "nathan") >= 0) {
            response = "He sounds like a good teacher.";
        } else if (findWord(statement, "programming") >= 0) {
            response = "I like programming too! Tell me more.";
        } else if (findWord(statement, "water") >= 0) {
            response = "I'm not a big fan of water, what do you think?";
        } else if (findWord(statement, "test") >= 0) {
            response = "Oh you have a test? Tell me more.";
        } else if (statement.trim().length() == 0) {
            response = "Say something, please.";
        } else {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 5;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        } else if (whichResponse == 4) {
            response = "Fascinating.";
        } else if (whichResponse == 5) {
            response = "Ok.";
        }
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        str = " " + str.trim().toLowerCase() + " ";
        return (str.contains(" " + word + " ")) ? str.indexOf(word) : -1;
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        return (statement.startsWith("I want ")) ? statement.replace("I want ", "Would you really be happy if you had ") + "?" : statement;
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        return statement.replace(" you", " me?").replace("I ", "Why do you ");
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        // your code here
        return (statement.startsWith("I want to ")) ? statement.replace("I want to ", "What would it mean to ") + "?" : statement;
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        return (statement.contains("you ") && statement.endsWith(" me")) ? "What makes you think that I " + statement.substring(statement.indexOf("you ") + 4).replace(" me", " you?") : statement;
    }
}
