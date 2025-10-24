package com.spring.ORM.springORM.DAO;

import java.util.List;

import com.spring.ORM.springORM.Entites.Employee;

public interface EmployeeDao {

	public int insert(Employee emp);
	public Employee getEmployee(int id);
	//to get all employees
	public List<Employee>allEmployees();
	//delete method
	public void deleteEmployee(int id); 
	//update method
	public void updateEmployee(Employee emp);
}