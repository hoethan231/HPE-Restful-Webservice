
public class EmployeeManager {

    private Employees list = new Employees();

    //Example employees
    static {

        list.add(
            new Employee(
                1,
                "Anthony",
                "Dong",
                "AD@gmail.com",
                "employee"
            )
        );

        list.add(
            new Employee(
                2,
                "Vincent",
                "Young",
                "VY@gmail.com",
                "employee"
            )
        );

        list.add(
            new Employee(
                3,
                "Yuji",
                "Kim",
                "YK@gmail.com",
                "employee"
            )
        );

        list.add(
            new Employee(
                3,
                "Emi",
                "Satoru",
                "ES@gmail.com",
                "employee"
            )
        );


    }

    public Employees getEmployees() {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getList().add(employee);
    }

    public void removeEmployee(Employee employee) {
        list.getList().remove(employee);
    }

}