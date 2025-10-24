package com.spring.ORM.springORM.DAO;

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

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
