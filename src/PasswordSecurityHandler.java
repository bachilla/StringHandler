/**
 * Password Security StringHandler class.
 * <p>
 * This class processes strings from the data.txt file that are identified as passwords containing any mix of alphanumeric
 * and non-alphanumeric digits.
 * <p>
 * No password should be skipped regardless of its content, so long as the flag is found
 * <p>
 * A few varying-arg constructors are included for those who want to play around with the code.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs None known.
 */
public class PasswordSecurityHandler implements StringHandler {

    /**
     * string used to identify a password's security level as being weak.
     */
    private final String SECURITY_LEVEL_WEAK = "weak";

    /**
     * string used to identify a password's security level as being medium.
     */
    private final String SECURITY_LEVEL_MEDIUM = "medium";

    /**
     * string used to identify a password's security level as being strong.
     */
    private final String SECURITY_LEVEL_STRONG = "strong";

    /**
     * integer used to hold the length of the password being processed.
     */
    private int length;

    /**
     * boolean used to determine if the character being processed is a numerical digit.
     */
    private boolean digit;

    /**
     * boolean used to determine if the character being process is non-alphanumerical.
     */
    private boolean otherCharacter;


    /**
     * No-arg constructor.
     */
    public PasswordSecurityHandler() {

    }

    /**
     * Three-arg constructor that takes a length, and two booleans as arguments.
     */
    public PasswordSecurityHandler(int length, boolean digit, boolean otherCharacter) {
        this.length = length;
        this.digit = digit;
        this.otherCharacter = otherCharacter;
    }

    /**
     * Protected getter method, I dont use this in this project.
     *
     * @return integer that is the length of the password.
     */
    protected int getLength() {
        return this.length;
    }

    /**
     * Protected getter method, I dont use this in this project.
     *
     * @return boolean that tells whether or not digit is strictly numerical.
     */
    protected boolean getDigit() {
        return this.digit;
    }

    /**
     * Protected getter method, I dont use this in this project.
     *
     * @return boolean that tells whether or not the character it non-alphanunmerical.
     */
    protected boolean getOtherCharacter() {
        return this.otherCharacter;
    }

    /**
     * Method determines the security level of the found password.
     *
     * @return string that contains the security level of the password.*/
    public String securityLevel() {
        String sec = null;
        if (this.length >= 8) {
            if (this.digit && this.otherCharacter) {
                sec = SECURITY_LEVEL_STRONG;
            } else if (this.digit || this.otherCharacter) {
                sec = SECURITY_LEVEL_MEDIUM;
            } else {
                sec = SECURITY_LEVEL_WEAK;
            }
        } else {
            sec = SECURITY_LEVEL_WEAK;
        }
        return sec;
    }

    /**
     * Method procceses a digit from the potential password.
     *
     * @param digit single character of the potential password to be processed.
     */
    @Override
    public void processDigit(char digit) {
        if (Character.isDigit(digit)) {
            this.digit = true;
            length++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method procceses a letter from the potential password.
     *
     * @param letter single character of the potential password to be processed.
     */
    @Override
    public void processLetter(char letter) {
        if (Character.isLetter(letter)) {
            length++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method procceses a non-alphanumeric character from the password.
     *
     * @param other single character of the potential password to be processed.
     */
    @Override
    public void processOther(char other) {
        if (!Character.isLetterOrDigit(other) || !Character.isISOControl(other)) {
            this.otherCharacter = true;
            length++;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
