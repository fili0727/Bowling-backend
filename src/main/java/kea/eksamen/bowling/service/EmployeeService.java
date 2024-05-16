package kea.eksamen.bowling.service;

import kea.eksamen.bowling.entity.Employee;
import kea.eksamen.bowling.entity.Product;
import kea.eksamen.bowling.repositories.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
    }

    public Employee addEmployee(Employee employee){
        if(employee.getId() != null){
            throw new IllegalArgumentException("You cannot provide the id for a new employee");
        }
        return employeeRepository.save(employee);
    }

    public ResponseEntity deleteEmployee(Long id){
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        employeeRepository.delete(employeeToDelete);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
