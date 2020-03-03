package com.techm.springboot.curdrestdemo.dao;

import java.util.List;
import com.techm.springboot.curdrestdemo.entity.Employee;

public interface EmployeeDAO {
	
	//to get all the entries from table
	public List<Employee> findAll();

	//to get specific employee data
	public Employee findById(int theId);
	
	//save employee data
	public void saveEmp(Employee theEmployee);
	
	//delete employee data
	public void deleteById(int theId);
	
}
