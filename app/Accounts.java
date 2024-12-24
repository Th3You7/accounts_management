
import constants.*;
import interfaces.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import utils.*;


public class Accounts implements AccountsServices, UserInput {
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
        IntStream.range(0, Gender.values().length).forEach(i -> System.out.println(i+1 + "- " + Gender.values()[i]));
        int genderIndex = handleUserListItemSelection(Gender.values().length);
        // role selection
        System.out.println("Select user role: ");
        IntStream.range(0, Roles.values().length).forEach(i -> System.out.println(i+1 + "- " + Roles.values()[i]));
        int roleIndex = handleUserListItemSelection(Roles.values().length);

        // create new role
        Role role = new Role(Roles.values()[roleIndex-1]);
        // create new user
        User user = new User(name, age, Gender.values()[genderIndex-1], role);
        // savce new user
        DB.add(user);
        System.out.println(Colors.ANSI_GREEN + "User added Succefully" + Colors.ANSI_RESET);
        System.out.println();
    }

    @Override
    public void list() {
       // if no book stored
        if(DB.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No user stored" + Colors.ANSI_RESET);
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
        int number;
        char editName; // n/N => No, y/Y => Yes
        char editAge; // n/N => No, y/Y => Yes
        char editRole; // n/N => No, y/Y => Yes


        // if no user stored
        if(DB.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No user stored" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        //list all users
        list();

        //get user selection
        System.out.println("Enter User number: ");
        number = handleUserListItemSelection(DB.size());

        // get book
        User user = DB.get(number-1);

         //Edit Name
         System.out.println();
         System.out.println("=> Edit name ? (" + user.getName() + ") (y/Y: Yes, n/N: No)");
         editName = handleUserYesNoSelection();
         if(editName == 'y' || editName == 'Y') {
             System.out.println("new name:");
             String newName = scan.nextLine();
             user.setName(newName);
         }
 
         //Edit Age 
         System.out.println();
         System.out.println("=> Edit Age ? (" + user.getAge() + ") (y/Y: Yes, n/N: No)");
         editAge = handleUserYesNoSelection();
         if(editAge == 'y' || editAge == 'Y') {
             System.out.println("new age:");
             int newAge = handleUserInputMismatch();
             user.setAge(newAge);
         }

         //Edit role 
         System.out.println();
         System.out.println("=> Edit role ? (" + user.getRole() + ") (y/Y: Yes, n/N: No)");
         editRole = handleUserYesNoSelection();
         if(editAge == 'y' || editAge == 'Y') {
            
            System.out.println("Select new role: ");
            IntStream.range(0, Roles.values().length).forEach(i -> System.out.println(i+1 + "- " + Roles.values()[i]));
            int roleIndex = handleUserListItemSelection(Roles.values().length);
            Role role = new Role(Roles.values()[roleIndex-1]);
            user.setRole(role);
         }

         // check if something changed and print a msg
        if(editAge == 'y' || editAge == 'Y' || editName == 'y' || editName == 'Y' || editRole == 'y' || editRole == 'Y') {
            System.out.println(Colors.ANSI_GREEN + "Book edited successfully" + Colors.ANSI_RESET);
        }else {
            System.out.println(Colors.ANSI_PURPLE + "Nothing has changed" + Colors.ANSI_RESET);
        }
        System.out.println();
    }

    @Override
    public void remove() {
        int number;

        // if no user stored
        if(DB.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No user stored" + Colors.ANSI_RESET);
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
        System.out.println(Colors.ANSI_GREEN + "User removed Succefully" + Colors.ANSI_RESET);
        System.out.println();
    }

    @Override
    public void search() {
        ArrayList<User> filtredUsers;
        // if no book stored
        if(DB.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book stored" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        System.out.println("Enter search keyword");
        String keyword = scan.nextLine();
        System.out.println();

        filtredUsers = new ArrayList<>(DB.stream().filter(user -> user.getName().contains(keyword)).toList()); 

        // no book found
        if(filtredUsers.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No user found" + Colors.ANSI_RESET);
            System.out.println();

            return;
        }
        //list filtred items
        IntStream.range(0, filtredUsers.size()).forEach(i -> System.out.println(i+1 + "- " + filtredUsers.get(i)));
        // check one
        System.out.println("Enter a user number to check details:");
        int input = handleUserListItemSelection(filtredUsers.size());
        System.out.println(filtredUsers.get(input-1));
        System.out.println();
    }

    


    
}
