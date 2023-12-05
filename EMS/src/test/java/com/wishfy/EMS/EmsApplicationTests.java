package com.wishfy.EMS;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.wishfy.EMS.entity.Employee;
import com.wishfy.EMS.repository.EmployeeRepository;
import com.wishfy.EMS.service.EmployeeService;


@SpringBootTest
class EmsApplicationTests {

	 @Mock
	    private EmployeeRepository employeeRepository;

	    @InjectMocks
	    private EmployeeService employeeService;

	    @Test
	    public void testGetAllEmployees() {
	        // Mocking repository behavior
	        Mockito.when(employeeRepository.findAll()).thenReturn(Arrays.asList(
	                new Employee(1L, "Yash", "yash@example.com", "IT", new Date()),
	                new Employee(2L, "Yogesh", "yogesh@example.com", "HR", new Date())
	        ));

	        // Testing service method
	        List<Employee> employees = employeeService.getAllEmployees();

	        // Assertions
	        assertEquals(2, employees.size());
	        assertEquals("Yash", employees.get(0).getName());
	        assertEquals("Yogesh", employees.get(1).getName());
	    }



}
