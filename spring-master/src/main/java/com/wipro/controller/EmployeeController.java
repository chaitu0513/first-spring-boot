package com.wipro.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.exception.ResourceNotFoundException;
import com.wipro.model.Employee;
import com.wipro.repository.EmployeeRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1")
@ApiResponse(responseCode="200",description="OK",content= {@Content(mediaType="application/json",schema=@Schema(type="object",implementation=Employee.class))})
public class EmployeeController {
	
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public Iterable<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		System.out.println(employee);
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmpId(employeeDetails.getEmpId());
		employee.setEmpName(employeeDetails.getEmpName());
		employee.setEmpName(employeeDetails.getEmpDes());
		employee.setEmpEmail(employeeDetails.getEmpEmail());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/healthcheck")
    private String Healthcheck()
    {
    	return "Application Springboot is running....";
    } 
	@Autowired
	  private BuildProperties buildProperties;
	  @GetMapping("/build-info")
	  public BuildProperties buildInfo() {
	    return this.buildProperties;
	  }
	  
	  @Autowired
	  private Environment environment;

	  @GetMapping("/profile-info")
	  private String[] ProfileInfo() {
		  return environment.getActiveProfiles();

	  }
	  
	  @GetMapping("/ping/google")
	  public int Responsecode() throws URISyntaxException
	  {
	  RestTemplate restTemplate = new RestTemplate();
	  final String baseUrl = "https://www.google.com";
	  URI url = new URI(baseUrl);
	  ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	  int statuCode = response.getStatusCodeValue();
	return statuCode;
	  }
}