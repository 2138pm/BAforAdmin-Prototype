package ku.cs.models;

public class Admin {
    private String username;
    private String id;

    private String password;
    //private int time;

    public Admin(String name,String id, String password){
        this.username = name;
        this.id = id;
        this.password = password;
        //this.time = time;

    }

    public boolean check(String username, String password){

        return this.username.equals(username) && this.password.equals(password) ;
    }

    public boolean isId(String id) {
        return this.id.equals(id);
    }


    public String getName(){
        return username;
    }
    public String getId(){
        return id;
    }

//    public String getPassword(){
//        return pw;
//    }
    //public int getTimes(){ return time;}


    public String toCsv(){
        return username + "," + id + "," + password;
    }


    @Override
    public String toString() {
        return "{" +
                "name: '" + username + '\'' +
                ", id: '" + id + '\'' +
                ", password: " + password + "}";
    }

}
