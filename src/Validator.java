/**
 * Validator interface.
 * <p>
 * This class declares the methods to be implemented by each "Handler" class with the exception of the PasswordSecurityHandler class.
 * <p>
 * each method listed here is implemented by all "Handler" classes except for PasswordSecurityHandler.
 * <p>
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs None known.
 */
public interface Validator {

    /**
     * Method returns the boolean indicating whether a character is valid or invalid within its handler class.
     * <p>
     * Gets implemented differently by each "Handler" class.
     *
     * @return boolean that indicates whether the character is valid or not, respective to its handler class.
     */
    boolean isValid();
}
