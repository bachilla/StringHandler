/**
 * Hex StringHandler class.
 * <p>
 * This class processes strings from the data.txt file that are identified as containing exclusively valid hex digits.
 * <p>
 * If the hex string found after the flag contains invalid characters, it should be skipped.
 * <p>
 * A few constructors varying-arg are included for those who want to play around with the code.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs None known.
 */
public class HexStringHandler implements StringHandler, Validator {

    /**
     * number indicating that a digit is an invalid hex.
     */
    public final int INVALID_NUMBER = -1;

    /**
     * number used to indicate base 16. (hex)
     */
    public final int NUMBER_SYSTEM = 16;

    /**
     * number used to indicate base 10. (hex)
     */
    public final int NUMBER_LETTER_MIN = 10;

    /**
     * number used to indicate base 16. (hex)
     */
    public final int NUMBER_LETTER_MAX = 16;

    /**
     * boolean used to indicate whether a digit of the potential hex string is a valid hex digit.
     */
    public boolean validHex;

    /**
     * the potential hex value of the found hex-string
     */
    public int number;


    /**
     * No-arg constructor.
     */
    public HexStringHandler() {

    }

    /**
     * Two-arg constructor takes a boolean and int as parameters.
     *
     * @param validHex boolean that indicates whether the character is a valid hex digit or not.
     * @param number binary value of the character being processed.
     */
    public HexStringHandler(boolean validHex, int number) {
        this.validHex = validHex;
        this.number = number;
    }

    /**
     * Method checks whether the hex-string is valid or not
     *
     * @return String that is the converted hex number.
     * */
    public String getNumber() {
        int temp;
        if (isValid()) {
            temp = number;
        } else {
            temp = INVALID_NUMBER;
        }
        return String.valueOf(temp);
    }

    /**
     * Method returns whether the characters of the potential hex string are valid hex digits.
     * <p>
     * If non-valid hex digit is found, gets set to false. (maybe processed as password)
     *
     * @return Boolean that tells whether hex string contains only valid hex digits
     */
    @Override
    public boolean isValid() {
        return this.validHex;
    }

    /**
     * Method procceses a digit from the potential hex string.
     * then confirms whether it can be used as part of a valid hex string.
     *
     * @param digit single character of the potential hex string to be processed.
     */
    @Override
    public void processDigit(char digit) {
        if (Character.isDigit(digit)) {
            this.validHex = true;
            int d = Character.getNumericValue(digit);
            number = number * NUMBER_SYSTEM + d;
        } else {
            throw new IllegalArgumentException();

        }
    }

    /**
     * Method procceses a letter from the potential hex String.
     * then confirms whether it can be used as part of a valid hex string.
     *
     * @param letter single character of the potential email address to be processed.
     */
    @Override
    public void processLetter(char letter) {
        if (Character.isLetter(letter)) {
            this.validHex = true;
            int l = Character.getNumericValue(letter);
            if (l >= NUMBER_LETTER_MIN && l < NUMBER_LETTER_MAX) {
                number = number * NUMBER_LETTER_MAX + l;
            }
        } else {
            throw new IllegalArgumentException();

        }
    }

    /**
     * Method procceses a non-alphanumeric character from the potential hex string,
     * then confirms whether it can be used as part of a valid hex string.
     *
     * @param other single character of the potential hex string to be processed.
     */
    @Override
    public void processOther(char other) {
        if (!Character.isLetterOrDigit(other) && !Character.isISOControl(other)) {
            validHex = false;
        } else {
            throw new IllegalArgumentException();
        }

    }

}
