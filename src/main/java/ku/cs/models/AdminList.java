package ku.cs.models;

import ku.cs.services.FXRouter;
import ku.cs.services.exceptions.AuthenticationFailedException;

import java.io.IOException;
import java.util.ArrayList;

public class AdminList {
    private ArrayList<Admin> admins;

    public AdminList() {
        admins = new ArrayList<>();
    }

    public void addNewAdmin(String name, String id, String password) {
        name = name.trim();
        id = id.trim();
        if (!id.equals("") && !name.equals("")) {
            Admin exist = findAdminById(id);
            if (exist == null) {
                admins.add(new Admin(name, id, password));
            }
        }
    }

    public boolean isExists(String username, String id){
        for (Admin admin : admins) {
            if (admin.getName().equals(username) || admin.getId().equals((id)) ) {
                return true;
            }
        }
        return false;
    }

    public Admin authen(String username, String password) {
        for (Admin admin : admins) {
            if (admin.check(username, password)) {
                return admin;
            }
        }
        throw new AuthenticationFailedException("Invalid username or password!");
    }

    public Admin findAdminById(String id) {
        for (Admin admin : admins) {
            if (admin.isId(id)) {
                return admin;
            }
        }
        return null;
    }



    public ArrayList<Admin> getAdmins() {
        return admins;
    }
}
