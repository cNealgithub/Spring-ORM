package com.spring.ORM.springORM;

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
    	System.out.println(System.getProperty("java.class.path"));
    	Employee emp1 = new Employee(1,"Aman","mumbai","aman@outlook.com");
    	int r = empDao.insert(emp1);
    	System.out.println("done" + r);
    }
}
