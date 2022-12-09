
package inventory_casheringsystem;


public class UsersInfo {
      private int id;
    private String firstname;
    private String middle;
    private String lastname;
    private String address;
    private int age;
    private String user;
    private String pass;
    private String gender;
    private String usertype;
    private String status;
   

    public UsersInfo(int id, String firstname, String middle, String lastname,
                     String address, int age, String user, String pass, String  gender , String usertype, String status ) {
        this.id = id;
        this.firstname = firstname;
        this.middle = middle;
        this.lastname = lastname;
        this.address = address;
        this.age = age;
        this.user = user;
        this.pass = pass;
        this.gender = gender;
        this.usertype = usertype;
        this.status = status;
        
    }

    public int getID() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getMiddlename() {
        return middle;
    }
    public String getLastname() {
        return lastname;
    }
     public String getAddress() {
        return address;
    }
      public int getAge() {
        return age;
    }
    public String getUsername(){
        return user;
    }
    public String getPassword(){
        return pass;
    }
    public String getGender(){
        return gender;
    }
    public String getUsersType() {
        return usertype;
    }
     public String getUserStatus() {
        return status;
    }

}
