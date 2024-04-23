package ku.cs.models;

public class Admin {
    private String name;
    private String id;

    private String pw;

    public Admin(String name,String id){
        this.name = name;
        this.id = id;
        pw = "CS38";
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

}
