package interfaces;

import constants.Colors;
import constants.Patterns;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;




public interface UserInput {
    Scanner scan = new Scanner(System.in);
    // handle mismatch exception
    default  int handleUserInputMismatch() {
        int number;
        while (true) {
            try {
                number = scan.nextInt();
                scan.nextLine();
                break;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.err.println(Colors.ANSI_RED + "Invalid Input!" + Colors.ANSI_RESET);
            }
        }

        return number;
    }
    // handle user yes or no selection
    default char handleUserYesNoSelection() {
        char input;
        while (true) {
            input = scan.nextLine().charAt(0);
            if(input != 'Y' && input != 'y' && input != 'N' && input != 'n'){
                System.err.println(Colors.ANSI_RED + "Invalid Input!" + Colors.ANSI_RESET);
                continue;
            }

            break;
        }

        return input;
    }
    // handle user wrong 
    default int handleUserListItemSelection(int size) {
        int input;
        while (true) { 
            input = handleUserInputMismatch();
            if(input > size || input <= 0 ) {
                System.err.println(Colors.ANSI_RED + "Invalid Input!" + Colors.ANSI_RESET);
                continue;
            }
            break;
        }
        return input;
    }

    default int handleUserListItemSelectionWithZero(int size) {
        int input;
        while (true) { 
            input = handleUserInputMismatch();
            if(input > size || input < 0 ) {
                System.err.println(Colors.ANSI_RED + "Invalid Input!" + Colors.ANSI_RESET);
                continue;
            }
            break;
        }
        return input;
    }

    default String handleEmail() {
        String input;
        while (true) {
            input = scan.nextLine();
            Matcher matcher = Patterns.VALID_EMAIL_ADDRESS_REGEX.matcher(input);

            if(!matcher.matches()) {
                System.err.println(Colors.ANSI_RED + "Invalid email!" + Colors.ANSI_RESET);
                continue;
            }
            break;
        }

        return input;
    }
}
