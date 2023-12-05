package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wishfy.EMS.entity.Employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Yash"))
                .andExpect(jsonPath("$[1].name").value("Yogesh"));
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        mockMvc.perform(get("/employees/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    public void testSaveEmployee() throws Exception {
        Employee newEmployee = new Employee(null, "New Employee", "new@example.com", "Marketing", new Date());

        ResultActions result = mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newEmployee)))
                .andExpect(status().isOk());

        // You can extract the created employee from the response for further assertions if needed
        // Example: Employee createdEmployee = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(), Employee.class);
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        mockMvc.perform(delete("/employees/{id}", 1))
                .andExpect(status().isOk());
    }

}

