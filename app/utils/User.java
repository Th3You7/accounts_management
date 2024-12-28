package utils;

import constants.Gender;
import java.util.ArrayList;

public class User extends Person {
    private ArrayList<Role> roles = new ArrayList<>();
    private String email;
    private String password;
    // TODO: add email & password;
    public User(String name, int age, Gender gender, String email, String password, Role role) {
        super(name, age, gender);
        this.email = email;
        this.password = password;
        this.roles.add(role);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Role> getRole() {
        return roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setRole(ArrayList<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        
        return this.getName().toUpperCase() + " => Roles: " + getRole().toString();
    }

}
