
import java.util.InputMismatchException;
import java.util.Scanner;

interface UserInput {
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
                System.err.println(ColorsConstant.ANSI_RED + "Invalid Input!" + ColorsConstant.ANSI_RESET);
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
                System.err.println(ColorsConstant.ANSI_RED + "Invalid Input!" + ColorsConstant.ANSI_RESET);
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
                System.err.println(ColorsConstant.ANSI_RED + "Invalid Input!" + ColorsConstant.ANSI_RESET);
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
                System.err.println(ColorsConstant.ANSI_RED + "Invalid Input!" + ColorsConstant.ANSI_RESET);
                continue;
            }
            break;
        }
        return input;
    }
}
