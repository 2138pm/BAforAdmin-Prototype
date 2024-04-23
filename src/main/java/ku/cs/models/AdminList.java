package ku.cs.models;

import java.util.ArrayList;

public class AdminList {
    private ArrayList<Admin> admins;

    public AdminList() {
        admins = new ArrayList<>();
    }

    public void addNewAdmin(String id, String name) {
        id = id.trim();
        name = name.trim();
        if (!id.equals("") && !name.equals("")) {
            Admin exist = findAdminById(id);
            if (exist == null) {
                admins.add(new Admin(id.trim(), name.trim()));
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

//    public void givePasswordToId(String id, String pw) {
//        Admin exist = findAdminById(id);
//        if (exist != null) {
//            exist.addBalance(balance);
//        }
//    }

//    public String viewTierOfId(String id) {
//        Customer exist = findCustomerById(id);
//        if (exist != null) {
//            return exist.tier();
//        }
//        return null;
//    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }
}
