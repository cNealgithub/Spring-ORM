package com.spring.ORM.springORM.Entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeesdao")
public class Employee {

	@Id
	private int emp_id;
	@Column(name="Name")
	private String emp_Nae;
	private String address;
	private String email;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int emp_id, String emp_Nae, String address, String email) {
		super();
		this.emp_id = emp_id;
		this.emp_Nae = emp_Nae;
		this.address = address;
		this.email = email;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_Nae() {
		return emp_Nae;
	}
	public void setEmp_Nae(String emp_Nae) {
		this.emp_Nae = emp_Nae;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_Name=" + emp_Nae + ", address=" + address + ", email=" + email
				+ "]";
	}
	
	
	
}
