package com.wipro.model;
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;

@Entity
@Table
public class Employee {
 
	@Id
	@Column
	private int emp_id;
	
	@Column
	private String emp_name;
	 
	@Column
	private String emp_des;
	
	@Column  
	private String emp_email;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_des() {
		return emp_des;
	}

	public void setEmp_des(String emp_des) {
		this.emp_des = emp_des;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}  
	
}
