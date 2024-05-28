package kea.eksamen.bowling;

import com.fasterxml.jackson.databind.ObjectMapper;
import kea.eksamen.bowling.controller.EmployeeController;
import kea.eksamen.bowling.entity.Employee;
import kea.eksamen.bowling.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;


    @Test
    public void getAllEmployees_returnsOk() throws Exception {
        mockMvc.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void getEmployee_returnsOk() throws Exception {
        Employee employee = new Employee();
        employee.setId(1L);
        when(employeeService.getEmployeeById(1L)).thenReturn(employee);

        mockMvc.perform(get("/employees/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addEmployee_returnsOk() throws Exception {
        Employee employee = new Employee();
        employee.setName("John Doe");
        
        when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(employee);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        Employee returnedEmployee = objectMapper.readValue(response.getContentAsString(), Employee.class);
        assertEquals("John Doe", returnedEmployee.getName());
    }



}