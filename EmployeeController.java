import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager manager;

    public Employees getEmployees() {
        return manager.getEmployees();
    }

    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

        Integer id = manager.getEmployees().size() + 1;

        employee.set_id(id);
        manager.addEmployee(employee);

        URi location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.get_id).toUri();
    }
}