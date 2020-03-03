package com.techm.springboot.curdrestdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.techm.springboot.curdrestdemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {
	
	//Define field for EntityManager
	private EntityManager entityManager;
	
	//Set up constructor injections
	//theEntityManager created by Springboot
	@Autowired
	public EmployeeDAOHibernateImp (EntityManager theEntityManager) {
		entityManager=theEntityManager;
     }

//Overrides the employeeDAO Interface function
	@Override
	public List<Employee> findAll() {
		
		//get the current Hibernate session
		Session currentSession =entityManager.unwrap(Session.class);
		
	    //create query 
		//we are using native Hibernate API for this
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		//execute the query and get result
		List<Employee> employees=theQuery.getResultList();
		
		//return result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get current hibernate session
		Session currentSession =entityManager.unwrap(Session.class);
		
		// get the employee
				Employee theEmployee =
						currentSession.get(Employee.class, theId);
				
				// return the employee
				return theEmployee;
	}

	@Override
	//How to return the recently saved employee?
	public void saveEmp(Employee theEmployee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
