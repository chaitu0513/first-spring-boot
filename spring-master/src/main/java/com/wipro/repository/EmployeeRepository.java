package com.wipro.repository;
import org.springframework.data.repository.CrudRepository;  
import com.wipro.model.Employee;  
public interface EmployeeRepository extends CrudRepository<Employee, Long>  {

	//Optional<Employee> findById(Long employeeId);

}
