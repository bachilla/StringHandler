/**
 * US Telephone Number StringHandler class.
 * <p>
 * This class processes strings from the data.txt file that are identified as plausible US phone numbers.
 * <p>
 * Controls ensure that every character processed from the found phone number is a digit.
 * <p>
 * A few varying-arg constructors are included for those who want to play around with the code.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs None known.
 */
public class UsTelephoneStringHandler implements StringHandler, Validator {
    /**
     * integer used to hold the digit of the phone number being processed ("-" is included as a valid digit for this).
     */
    public int digit;

    /**
     * boolean used to ensure the digit being processed is strictly numerical.
     */
    public boolean validDigit;

    /**
     * string that contains the potential US telephone number to be processed.
     */
    public String phoneNumber;

    /**
     * integer used to identify a character as being non-numerical
     */
    public final int INVALID_NUMBER = -1;

    /**
     * No-arg constructor.
     */
    public UsTelephoneStringHandler() {

    }

    /**
     * Three-arg constructor takes a digit, boolean, and string as arguments.
     */
    public UsTelephoneStringHandler(int digit, boolean validDigit, String phoneNumber) {
        this.digit = digit;
        this.validDigit = validDigit;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method procceses a digit from the potential email address,
     * then confirms whether it can be used as part of a valid email address.
     *
     * @param s String that contains the potential US telephone number.
     * @return String that is the confirmed US telephone number.
     */
    public String getPhoneNumber(String s) {
        String temp;
        if (s.matches("1-\\d{3}-\\d{3}-\\d{4}")) {
            char[] digArray = s.toCharArray();
            for (char c : digArray) {
                processDigit(c);
                if (!isValid()) {
                    break;
                } else {
                    temp = s;
                    phoneNumber = temp;
                }
            }
        }
        return phoneNumber;
    }


    /**
     * Method returns whether the telephone number is a valid US telephone number.
     * <p>
     * If this is ever false, the telephone number might be skipped.
     *
     * @return Boolean that tells whether phone number is a valid US telephone number.
     */
    @Override
    public boolean isValid() {
        return validDigit;
    }

    /**
     * Method procceses a digit from the potential email address,
     * then confirms whether it can be used as part of a valid email address.
     *
     * @param digit single character of the potential email address to be processed.
     */
    @Override
    public void processDigit(char digit) {
        if (Character.isDigit(digit) || String.valueOf(digit).equals("-")) {
            validDigit = true;
        }
    }

    /**
     * Method procceses a letter from the potential phone number.
     * <p>
     * If character passed is indeed a letter, sets validDigit to false;
     *
     * @param letter single character of the potential email address to be processed.
     */
    @Override
    public void processLetter(char letter) {
        if (!Character.isDigit(letter)) {
            validDigit = false;
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
            validDigit = false;
        }
    }


}
