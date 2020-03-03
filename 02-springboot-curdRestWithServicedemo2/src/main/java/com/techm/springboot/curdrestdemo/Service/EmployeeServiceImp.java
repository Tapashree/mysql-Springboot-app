package com.techm.springboot.curdrestdemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techm.springboot.curdrestdemo.dao.EmployeeDAO;
import com.techm.springboot.curdrestdemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	//Constructor injection
	@Autowired
	public EmployeeServiceImp (EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// delegate the call the DAO		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
	// delegate the call the DAO
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void saveEmp(Employee theEmployee) {
		// delegate the call the DAO
		employeeDAO.saveEmp(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// delegate the call the DAO
		 employeeDAO.deleteById(theId);
	}

}
