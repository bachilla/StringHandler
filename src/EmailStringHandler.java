/**
 * Email StringHandler class.
 * <p>
 * This class processes strings from the data.txt file that are identified as RFC 5322 compliant emails.
 * <p>
 * If the email found contains invalid characters/sequences of invalid characters, it will be skipped.
 * <p>
 * A few varying-arg constructors are included for those who want to play around with the code.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs None known.
 */
public class EmailStringHandler implements StringHandler, Validator {

    /**
     * Integer containing the number to be returned if a char is found to be invalid.
     */
    public final int INVALID_NUMBER = -1;

    /**
     * Boolean that gets returned to verify e-mail found is an RFC 5322 compliant email address.
     */
    public boolean validEmail;

    /**
     * String that contains the potential RFC 5322 compliant email address.
     */
    public String eMail;

    /**
     * Integer that specifies the length of the email address.
     */
    public int length = 0;

    /**
     * No-arg constructor.
     */
    public EmailStringHandler() {

    }

    /**
     * Single-arg constructor that takes an email address as a string.
     */
    public EmailStringHandler(String eMail) {
        this.eMail = eMail;
    }

    /**
     * 3-arg constructor that takes a boolean, email address, and length.
     */
    public EmailStringHandler(boolean validEmail, String eMail, int length) {
        this.validEmail = validEmail;
        this.eMail = eMail;
        this.length = length;
    }

    /**
     * Meta method that essentially parses the potential email string similarly to StringParser's parse method.
     *
     * @param s String that contains the potential RFC 5322 compliant email address.
     * @return String that is the validated email address, might be null if not RFC 5322 compliant.
     */
    public String getEMail(String s) {
        String temp;

        char[] digArray = s.toCharArray();
        for (char c : digArray) {
            if (Character.isDigit(c)) {
                processDigit(c);
            } else if (Character.isLetter(c)) {
                processLetter(c);
            } else {
                processOther(c);
            }
            if (!isValid()) {
                break;
            } else {
                temp = s;

                if (temp.matches
                        ("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
                    eMail = temp;
                }
            }
        }
        return eMail;
    }

    /**
     * Method returns whether the email of this object is RFC 5322 compliant.
     * <p>
     * If this is ever false, the email should be skipped.
     *
     * @return Boolean that tells whether the email address is RFC 5322 compliant or not.
     */
    @Override
    public boolean isValid() {
        return validEmail;
    }

    /**
     * Method procceses a digit from the potential email address,
     * then confirms whether it can be used as part of a valid email address.
     *
     * @param digit single character of the potential email address to be processed.
     */
    @Override
    public void processDigit(char digit) {
        if (Character.isDigit(digit)) {
            validEmail = true;
            length++;
        } else {
            throw new IllegalArgumentException();

        }
    }

    /**
     * Method procceses a letter from the potential email address,
     * then confirms whether it can be used as part of a valid email address.
     *
     * @param letter single character of the potential email address to be processed.
     */
    @Override
    public void processLetter(char letter) {
        if (Character.isLetter(letter)) {
            validEmail = true;
            length++;

        } else {
            throw new IllegalArgumentException();

        }
    }

    /**
     * Method procceses a non-alphanumeric character from the potential email address,
     * then confirms whether it can be used as part of a valid email address.
     *
     * @param other single character of the potential email address to be processed.
     */
    @Override
    public void processOther(char other) {
        if (!Character.isLetterOrDigit(other) && !Character.isISOControl(other)) {
            validEmail = false;
        } else {
            throw new IllegalArgumentException();
        }
    }


}
