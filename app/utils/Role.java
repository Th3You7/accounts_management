package utils;

import constants.Roles;

public class Role {
    private Roles role;
    
    public Role(Roles role) {
        this.role = role;
    }

    public Roles getRoles() {
        return role;
    }

    public void setRoles(Roles role) {
        this.role = role;
    }    

    @Override
    public String toString() {
        return role.toString().toUpperCase();
    }

    

}
