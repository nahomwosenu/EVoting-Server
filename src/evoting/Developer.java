package evoting;



public class Developer {
    private String id;
    private String firstName;
    private String lastName;
    private String sex;
    private String title;
    public Developer(String id,String fn,String ln,String sex,String title){
        this.id=id;
        this.firstName=fn;
        this.lastName=ln;
        this.sex=sex;
        this.title=title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public boolean insert(){
        String query="insert into developer(id,firstname,lastname,sex) values('"+id+"','"+firstName+"','"+lastName+"','"+sex+"')";
        String query2="insert into project(dev_id,title) values('"+id+"','"+title+"')";
        String query3="insert into score values('"+id+"','0','0')";
        if (DB.executeUpdate(query) && DB.executeUpdate(query2) && DB.executeUpdate(query3)){
            return true;
        }
        return false;
    }
}
