package ku.cs.services;

import ku.cs.models.AdminList;

public class AdminHardCodeDatasource {
    public AdminList readData() {
        AdminList list = new AdminList();
        list.addNewAdmin("6410400001", "August", "CS38");
        list.addNewAdmin("6410400002", "Frame", "CS38");
        return list;
    }
}
