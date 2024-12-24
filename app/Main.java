
import constants.Colors;
import interfaces.*;



public class Main implements UserInput {

    public static void main(String[] args) {

        AccountsServices users = new Accounts();
        
        
        loop: while(true) {
            System.out.println(Colors.ANSI_BLUE + "************************************* Choose an operation *************************************" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "1- ADD / 2- LIST / 3- EDIT / 4- REMOVE / 5- SEARCH (EXIT: 0)" + Colors.ANSI_RESET);
            
            int choice = new Main().handleUserInputMismatch(); 
            System.out.println();

            switch (choice) {
                case 1:
                    users.add();
                    break;
                case 2: 
                    users.list();
                    break;
                case 3: 
                    users.edit();
                    break;
                case 4: 
                    users.remove();
                    break;
                case 5:
                    users.search();
                case 0:
                    break loop;
                default:
                System.out.println(Colors.ANSI_RED + "Invalid Option" + Colors.ANSI_RESET);
            }
        }
    }
}