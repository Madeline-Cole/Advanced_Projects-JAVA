package lab07;

import java.util.*;

/**
 * This class breaks up a string into a sequence of tokens using both whitespace and a list of special characters.
 * The special characters in this case are used to tokenize an arithmetic expression. For example, 
 * the expression "2*3.8/(4.95-7.8)" would be tokenized as "2", "*", "3.8", "/", "(", "4.95", "-", "7.8", ")" 
 * even though it has no whitespace to separate these tokens.
 * 
 */
public class StringSplitter {

    // Queue to hold characters from the string being split
    private Queue<Character> characters;

    // Current token being processed
    private String token;

    // Special characters that act as delimiters for tokenization
    public static final String SPECIAL_CHARACTER = "()+-*/^";

    /**
     * Constructs a new StringSplitter for the specified string.
     * This constructor tokenizes the input string by loading it into a queue
     * and finding the first token.
     * 
     * @param line The string to be tokenized
     */
    public StringSplitter(String line) {
        characters = new LinkedList<Character>();
        for (int i = 0; i < line.length(); i++) {
            characters.add(line.charAt(i));
        }
        findNextToken();
    }

    /**
     * Returns true if there is another token in the string.
     * 
     * @return boolean true if there is another token, false otherwise
     */
    public boolean hasNext() {
        return token != null;
    }

    /**
     * Returns and consumes the next token in the string.
     * 
     * @return String representing the next token
     * @throws NoSuchElementException if no token is available
     */
    public String next() {
        checkToken();
        String result = token;
        findNextToken();
        return result;
    }

    /**
     * Returns the next token without consuming it.
     * 
     * @return String representing the next token
     * @throws NoSuchElementException if no token is available
     */
    public String peek() {
        checkToken();
        return token;
    }

    /**
     * Finds the next token from the string. Tokens are determined by either 
     * being special characters or sequences of non-whitespace, non-special characters.
     * This method is responsible for updating the `token` variable with the next available token.
     */
    private void findNextToken() {
        while (!characters.isEmpty() && Character.isWhitespace(characters.peek())) {
            characters.remove();
        }
        if (characters.isEmpty()) {
            token = null;
        } else {
            token = "" + characters.remove();
            if (!SPECIAL_CHARACTER.contains(token)) {
                boolean done = false;
                while (!characters.isEmpty() && !done) {
                    char ch = characters.peek();
                    if (Character.isWhitespace(ch) || SPECIAL_CHARACTER.indexOf(ch) >= 0) {
                        done = true;
                    } else {
                        token = token + characters.remove();
                    }
                }
            }
        }
    }

    /**
     * Ensures that there is a token available. If no token is available, 
     * this method throws a NoSuchElementException.
     * 
     * @throws NoSuchElementException if there are no tokens left
     */
    private void checkToken() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }
}
