/**
 * StringHandler interface.
 * <p>
 * This class declares the methods to be implemented by each of the four "Handler" classes.
 * <p>
 * each method listed here is implemented by each class that ends with "Handler".
 * <p>
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs None known.
 */
public interface StringHandler {

    /**
     * Method checks whether the character passed in is numerical.
     * <p>
     * Gets implemented differently by each "Handler" class
     *
     * @param digit character to be processed as a digit.
     */
    void processDigit(char digit);

    /**
     * Method checks whether the character passed in is alphabetical.
     * <p>
     * Gets implemented differently by each "Handler" class
     *
     * @param letter character to be processed as a letter.
     */
    void processLetter(char letter);

    /**
     * Method checks whether the character passed in is numerical.
     * <p>
     * Gets implemented differently by each "Handler" class
     *
     * @param other character to be processed as a non-alphanumeric character.
     */
    void processOther(char other);
}
