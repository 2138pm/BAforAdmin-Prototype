package ku.cs.models;

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
