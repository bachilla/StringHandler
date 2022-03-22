import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;

/**
 * StringHandler App class.
 * <p>
 * This class processes strings from the data.txt file, and processes them differently based on their content.
 * <p>
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs None known.
 */
public class StringHandlerApp {
    /**
     * FileInOut object used to create the file that gets read from.
     * */
    private static FileInOut fIo = new FileInOut();

    /**
     * main method first sets flags used to identify the type of string to be processed.
     * Am arbitrary string is then set, if it doesnt match any of the flags, the line/string is skipped.
     * Controls ensure the type of string to be processed gets processed by the correct String Parser.
     *
     * @throws FileNotFoundException if file to be read from isn't found.
     * @throws IllegalArgumentException if data from the file cannot be read.
     * @throws NoSuchElementException if the data has reached the end of the file (mostly)
     * */
    public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException, NoSuchElementException {
        String hexFlag = "h";
        String pwFlag = "p";
        String pnFlag = "n";
        String eMailFlag = "e";
        fIo.setInFilename("data.txt");

        try {
            Scanner reader = new Scanner(new File(fIo.getInFilename()));
            do {
                String s = reader.nextLine();

                if (s.equalsIgnoreCase(hexFlag)) {
                    s = reader.nextLine();
                    HexStringHandler hsh = new HexStringHandler();
                    StringParser hexParser = new StringParser(hsh);
                    hexParser.parse(s);
                    System.out.println(s + " = " + hsh.getNumber());
                }
                if (s.equalsIgnoreCase(pwFlag)) {
                    s = reader.nextLine();
                    PasswordSecurityHandler psh = new PasswordSecurityHandler();
                    StringParser binParser = new StringParser((psh));
                    binParser.parse(s);
                    System.out.println(s + "'s security is: " + psh.securityLevel());

                }
                if (s.equalsIgnoreCase(pnFlag)) {
                    s = reader.nextLine();
                    UsTelephoneStringHandler utsh = new UsTelephoneStringHandler();
                    StringParser phoneNumParser = new StringParser(utsh);
                    phoneNumParser.parse(s);
                    System.out.println("US phone number found: " + utsh.getPhoneNumber(s));

                }
                if (s.equalsIgnoreCase(eMailFlag)) {
                    s = reader.nextLine();
                    EmailStringHandler esh = new EmailStringHandler();
                    StringParser eMailParser = new StringParser(esh);
                    eMailParser.parse(s);
                    System.out.println("RFC 5322 validated email found!: " + esh.getEMail(s));
                }

            } while (reader.hasNextLine());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (NoSuchElementException ex) {
            System.out.println("-------------------------------------");
            System.out.println("***End of File***");
        }
    }
}