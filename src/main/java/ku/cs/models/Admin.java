package ku.cs.models;

import java.util.Objects;

public class Admin {
    private String name;
    private String id;

    private String pw;

    public Admin(String name,String id, String password){
        this.name = name;
        this.id = id;
        this.pw = password;
    }

    public boolean isId(String id) {
        return this.id.equals(id);
    }


    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }

    public String getPassword(){
        return pw;
    }

    public void setPw(String password) {
        if (!Objects.equals(password, "")) {
            this.pw = password;
        }
    }



    @Override
    public String toString() {
        return "{" +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", score: " + pw +
                '}';
    }

}
