/**
 * String Parser class.
 * <p>
 * This class creates String Parsers using a specific type of Handler.
 * <p>
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs None known.
 */
public class StringParser {

    /**
     * The handler used to process the string: Email, hex, password, or US telephone number
     * */
    private StringHandler handler;

    /**
     * no-arg constructor.
     * */
    public StringParser() {

    }

    /**
     * Single-arg constructor takes a StringHandler as an argument.
     * */
    public StringParser(StringHandler handler) {
        this.handler = handler;
    }

    /**
     * Method parses the String according the type of handler the String Parser is created with.
     *
     * @param s String that contains the potential element of the handler this String Parser object uses.
     * */
    public void parse(String s) {
        char[] tempArray = s.toCharArray();

        for (char c : tempArray) {
            if (Character.isDigit(c)) {
                handler.processDigit(c);
            } else if (Character.isLetter(c)) {
                handler.processLetter(c);
            } else {
                handler.processOther(c);
            }
        }
    }
}
