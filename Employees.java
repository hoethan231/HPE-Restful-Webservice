import java.util.ArrayList;
import java.util.List;

public class Employees {

    private List<Employee> employeeList;

    public List<Employee> getList() {

        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }

        return employeeList;
    }

    public void setList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}