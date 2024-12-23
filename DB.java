
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DB implements DBOperations, UserInput {
    private final ArrayList<User> DB = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("Enter user name: ");
        String name = scan.nextLine();
        System.out.println("Enter user age: ");
        int age = handleUserInputMismatch();
        // gender selection
        System.out.println("Select user gender: ");
        IntStream.range(0, GenderConstants.values().length).forEach(i -> System.out.println(i+1 + "- " + GenderConstants.values()[i]));
        int genderIndex = handleUserListItemSelection(GenderConstants.values().length);
        // role selection
        System.out.println("Select user role: ");
        IntStream.range(0, RolesConstant.values().length).forEach(i -> System.out.println(i+1 + "- " + RolesConstant.values()[i]));
        int roleIndex = handleUserListItemSelection(RolesConstant.values().length);

        // create new role
        Role role = new Role(RolesConstant.values()[roleIndex-1]);
        // create new user
        User user = new User(name, age, GenderConstants.values()[genderIndex-1], role);
        // savce new user
        DB.add(user);
        System.out.println(ColorsConstant.ANSI_GREEN + "User added Succefully" + ColorsConstant.ANSI_RESET);
        System.out.println();
    }

    @Override
    public void list() {
       // if no book stored
        if(DB.isEmpty()) {
            System.out.println(ColorsConstant.ANSI_PURPLE + "No user stored" + ColorsConstant.ANSI_RESET);
            System.out.println();
            return;
        }
        // list books
        // DB.stream().forEach(user -> System.out.println(user));
        IntStream.range(0, DB.size()).forEach(i -> System.out.println(i+1 + "- " + DB.get(i)));
        System.out.println();
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove() {
        int number;

        // if no user stored
        if(DB.isEmpty()) {
            System.out.println(ColorsConstant.ANSI_PURPLE + "No user stored" + ColorsConstant.ANSI_RESET);
            System.out.println();
            return;
        }

        // list users
        list();

        //get user selection
        System.out.println("Enter user number: ");
        number = handleUserListItemSelection(DB.size());
        System.out.println();


        // remove user
        DB.remove(number-1);
        System.out.println(ColorsConstant.ANSI_GREEN + "User removed Succefully" + ColorsConstant.ANSI_RESET);
        System.out.println();
    }

    


    
}
