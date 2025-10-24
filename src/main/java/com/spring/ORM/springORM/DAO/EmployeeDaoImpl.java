package com.spring.ORM.springORM.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.ORM.springORM.Entites.Employee;



public class EmployeeDaoImpl implements EmployeeDao{

	private HibernateTemplate hibernateTemplate;
	@Transactional
	@Override
	public int insert(Employee emp) {
		int i = (int)this.hibernateTemplate.save(emp);
		return i;
	}
	//to get single employee
	public Employee getEmployee(int id) {
		Employee emp = this.hibernateTemplate.get(Employee.class, id);
		return emp;
	}
	//to get all employees
	public List<Employee>allEmployees(){
		List<Employee> all = this.hibernateTemplate.loadAll(Employee.class);
		return all;
	}
	//delete method
	public void deleteEmployee(int id) {
		Employee emp = this.hibernateTemplate.get(Employee.class, id);
		this.hibernateTemplate.delete(emp);
		System.out.println("Deleted id ; " + id);
	}
	//update method
	public void updateEmployee(Employee emp) {
		this.hibernateTemplate.update(emp);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
