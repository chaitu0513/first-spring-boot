package com.wipro.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;  
import com.wipro.model.Employee;  
public interface EmployeeRepository extends CrudRepository<Employee, Integer>  {

	Optional<Employee> findById(Long employeeId);

}
