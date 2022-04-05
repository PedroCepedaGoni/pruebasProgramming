public class student {

    private int id;
    private String name;
    private String email;


    public student( int idParam, String nameParam, String emailParam ) {
        this.id = idParam;
        this.name = nameParam;
        this.email = emailParam;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
