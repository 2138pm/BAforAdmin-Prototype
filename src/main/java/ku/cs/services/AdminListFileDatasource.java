package ku.cs.services;

import ku.cs.models.AdminList;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class AdminListFileDatasource implements Datasource<AdminList>{
    private String directoryName;
    private String fileName;

    public AdminListFileDatasource(String directoryName, String fileName) {
        this.directoryName = directoryName;
        this.fileName = fileName;
        checkFileIsExisted();
    }

    // ตรวจสอบว่ามีไฟล์ให้อ่านหรือไม่ ถ้าไม่มีให้สร้างไฟล์เปล่า
    private void checkFileIsExisted() {
        File file = new File(directoryName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = directoryName + File.separator + fileName;
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public AdminList readData() {
        AdminList admins = new AdminList();
        String filePath = directoryName + File.separator + fileName;
        File file = new File(filePath);

        // เตรียม object ที่ใช้ในการอ่านไฟล์
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        InputStreamReader inputStreamReader = new InputStreamReader(
                fileInputStream,
                StandardCharsets.UTF_8
        );
        BufferedReader buffer = new BufferedReader(inputStreamReader);

        String line = "";
        try {
            // ใช้ while loop เพื่ออ่านข้อมูลรอบละบรรทัด
            while ( (line = buffer.readLine()) != null ){
                // ถ้าเป็นบรรทัดว่าง ให้ข้าม
                if (line.equals("")) continue;

                // แยกสตริงด้วย ,
                String[] data = line.split(",");

                // อ่านข้อมูลตาม index แล้วจัดการประเภทของข้อมูลให้เหมาะสม
                String id = data[0].trim();
                String name = data[1].trim();
                String password = data[2].trim();

                // เพิ่มข้อมูลลงใน list
                admins.addNewAdmin(id, name, password);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return admins;
    }


}
