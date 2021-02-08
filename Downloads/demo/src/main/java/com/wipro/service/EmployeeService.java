package com.wipro.service;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.wipro.model.Employee;  
import com.wipro.repository.EmployeeRepository;  

@Service
public class EmployeeService {

	@Autowired 
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee()   
	{  
	List<Employee> employee = new ArrayList<Employee>();  
	employeeRepository.findAll().forEach(emp -> employee.add(emp));  
	return employee;  
	}  
	
	public Employee getEmployeeById(int id)   
	{  
	return employeeRepository.findById(id).get();  
	}  
	public void saveOrUpdate(Employee employee)   
	{  
		employeeRepository.save(employee);  
	}  
	
	public void delete(int id)   
	{  
	employeeRepository.deleteById(id);  
	}  
}
