package com.spring.ORM.springORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ORM.springORM.DAO.EmployeeDao;
import com.spring.ORM.springORM.DAO.EmployeeDaoImpl;
import com.spring.ORM.springORM.Entites.Employee;


public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	EmployeeDao empDao = (EmployeeDao)context.getBean("EmployeeDaoimpl");
//    	System.out.println(System.getProperty("java.class.path"));
//    	Employee emp1 = new Employee(1,"Aman","mumbai","aman@outlook.com");
//    	int r = empDao.insert(emp1);
//    	System.out.println("done" + r);
    	
    	//menu-driven appl..
    	 boolean flag = true;
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	while (flag) {
    		try {
    		System.out.println("PRESS 1 for adding new employee");
    		System.out.println("PRESS 2 for selecting single employee");
    		System.out.println("PRESS 3 for list of employees");
    		System.out.println("PRESS 4 for deleting an employee");
    		System.out.println("PRESS 5 to update an employee");
    		System.out.println("PRESS 6 to exit");
    		
    		int choice = Integer.parseInt(br.readLine());
    		
    		switch(choice) {
    		case 1:
    			//insert employee
    			System.out.println("enter employee id : ");
    			int id = Integer.parseInt(br.readLine());
    			System.out.println("enter name : ");
    			String name = br.readLine();
    			System.out.println("Enter address: ");
    			String address = br.readLine();
    			System.out.println("enter email: ");
    			String email = br.readLine();
    			
    			Employee emp = new Employee();
    			emp.setEmp_id(id);
    			emp.setEmp_Nae(name);
    			emp.setAddress(address);
    			emp.setEmail(email);
    			empDao.insert(emp);
    			break;
    		case 2:
    			//select single employee
    			System.out.println("Enter employee id to select : ");
    			int empid = Integer.parseInt(br.readLine());
    			Employee emp2 = new Employee();
    			emp2 = empDao.getEmployee(empid);
    			System.out.println(emp2);
    			break;
    		case 3:
    			//select all employees
    			List<Employee> emp_list = empDao.allEmployees();
    			for(Employee emps : emp_list) {
    				System.out.println(emps);
    			}
    			break;
    		case 4:
    			//delete employee
    			System.out.println("Enter employee id to delete : ");
    			int delEmpid = Integer.parseInt(br.readLine());
    			empDao.deleteEmployee(delEmpid);
    			break;
    		case 5:
    			//update employee
    			System.out.println("Enter Employee id to update: ");
    			int updateId = Integer.parseInt(br.readLine());
    			System.out.println("Current details : ");
    			Employee existingEmployee = empDao.getEmployee(updateId);
    			System.out.println(existingEmployee);
    			System.out.println("+++++++++++++++++++");
    			//name
    			System.out.println("Enter new name (Leave emppty if this field requires no change)");
    			String newName = br.readLine();
    			if(!newName.trim().isEmpty()) {
    				existingEmployee.setEmp_Nae(newName);
    			}
    			//address
    			System.out.println("Enter new address (Leave emppty if this field requires no change)");
    			String newAddress = br.readLine();
    			if(!newAddress.trim().isEmpty()) {
    				existingEmployee.setAddress(newAddress);
    			}
    			//email
    			System.out.println("Enter new email (Leave emppty if this field requires no change)");
    			String newEmail = br.readLine();
    			if(!newEmail.trim().isEmpty()) {
    				existingEmployee.setEmail(newEmail);
    			}
    			empDao.updateEmployee(existingEmployee);
    			System.out.println("Employee with id: " + updateId + "has been succesfully updated.");
    			break;
    		case 6:
    			flag = false;
    			break;
    		}
    		}catch(Exception e) {
    			System.out.println("Invalid input ,, pls enter a valid input...");
    			e.printStackTrace();
    		}
    	}
    }
}
