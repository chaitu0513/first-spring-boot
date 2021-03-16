package com.wipro.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Employee {
 
	@Id
	@Column
	private long empId;
	
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNo;
	
	@Column
	private String empName;
	 
	@Column
	private String empDes;
	
	@Column  
	private String empEmail;

	public int getEmpId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
