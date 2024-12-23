

public class Main implements UserInput {

    public static void main(String[] args) {

        DB users = new DB();
        
        loop: while(true) {
            System.out.println(ColorsConstant.ANSI_BLUE + "************************************* Choose an operation *************************************" + ColorsConstant.ANSI_RESET);
            System.out.println(ColorsConstant.ANSI_BLUE + "1- ADD / 2- LIST / 4- REMOVE (EXIT: 0)" + ColorsConstant.ANSI_RESET);
            
            int choice = new Main().handleUserInputMismatch(); 
            System.out.println();

            switch (choice) {
                case 1:
                    users.add();
                    break;
                case 2: 
                    users.list();
                    break;
                case 4: 
                    users.remove();
                    break;
                case 0:
                    break loop;
                default:
                System.out.println(ColorsConstant.ANSI_RED + "Invalid Option" + ColorsConstant.ANSI_RESET);
            }
        }
    }
}