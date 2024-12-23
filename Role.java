
import java.util.ArrayList;

public class Role {
    private ArrayList<RolesConstant> roles;
    
    public Role(RolesConstant role) {
        this.roles.add(role);
    }

    public ArrayList<RolesConstant> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<RolesConstant> roles) {
        this.roles = roles;
    }    

}
