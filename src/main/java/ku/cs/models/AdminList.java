package ku.cs.models;

import java.util.ArrayList;

public class AdminList {
    private ArrayList<Admin> admins;

    public AdminList() {
        admins = new ArrayList<>();
    }

    public void addNewAdmin(String id, String name, String password) {
        id = id.trim();
        name = name.trim();
        if (!id.equals("") && !name.equals("")) {
            Admin exist = findAdminById(id);
//            Admin exist1 = findAdminByPassword(password);
            if (exist == null) {
                admins.add(new Admin(id, name, password));
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

//    public Admin findAdminByPassword(String pw) {
//        for (Admin admin : admins) {
//            if (admin.isPassword(pw)) {
//                return admin;
//            }
//        }
//        return null;
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
