
import java.util.ArrayList;

public class Role {
    private ArrayList<RolesConstant> roles = new ArrayList<>();
    private String str;
    
    public Role(RolesConstant role) {
        this.roles.add(role);
    }

    public ArrayList<RolesConstant> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<RolesConstant> roles) {
        this.roles = roles;
    }    

    @Override
    public String toString() {
        str = "[";
        roles.forEach(role -> str =  roles.indexOf(role) == roles.size() - 1 ? str  + role + "]" :  role + ", ");
        return str;
    }

    

}
