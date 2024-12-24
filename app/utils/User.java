package utils;

import constants.Gender;

public class User extends Person {
    Role role;

    public User(String name, int age, Gender gender, Role role) {
        super(name, age, gender);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        
        return super.getName().toUpperCase() + " => Roles: " + getRole().toString();
    }

}
