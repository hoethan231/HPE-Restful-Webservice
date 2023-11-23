import java.beans.EventHandler;

public class Employee {

    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;

    public Employee(int id, String first, String last, String email, String title) {

        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;

    }

    public int get_id() {
        return this.employee_id;
    }

    public String get_first_name() {
        return this.first_name;
    }

    public String get_last_name() {
        return this.last_name;
    }

    public String get_email() {
        return this.email;
    }

    public String get_title() {
        return this.title;
    }


    public void set_id(int id) {
        this.employee_id = id;
    }

    public void set_first(String first_name) {
        this.first_name = first_name;
    }

    public void set_last(String last) {
        this.last_name = last;
    }

    public void set_email(String email) {
        this.email = email;
    }

    public void set_title(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Employee " + employee_id + ": \n" +
                "firstname = " + first_name + "\n" +
                "lastname = " + last_name + "\n" +
                "email = " + email + "\n" +
                "title = " + title + "\n";
    }

}
