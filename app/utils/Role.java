package utils;

import constants.Roles;
import java.util.ArrayList;

public class Role {
    private ArrayList<Roles> roles = new ArrayList<>();
    private String str;
    
    public Role(Roles role) {
        this.roles.add(role);
    }

    public ArrayList<Roles> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Roles> roles) {
        this.roles = roles;
    }    

    @Override
    public String toString() {
        str = "[";
        roles.forEach(role -> str =  roles.indexOf(role) == roles.size() - 1 ? str  + role + "]" :  role + ", ");
        return str;
    }

    

}
