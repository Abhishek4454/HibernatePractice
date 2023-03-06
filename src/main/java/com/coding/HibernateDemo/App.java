package com.coding.HibernateDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {

		Employee emp= null;
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Query<Employee> query= session.createQuery("from Employee where salary<50000");
		
		List<Employee> list=query.list();
		System.out.println(list);
		System.out.println(list.size());
		
		Query<Object> query1= session.createQuery("select eid,ename,salary from Employee where eid=102");
		Object[] employee=(Object[]) query1.uniqueResult();
		
		for(Object emp1:employee) {
			System.out.println(emp1);
		}
		
		Query query2= session.createQuery("select eid,ename,salary from Employee where salary<50000");
		List<Object[]> employees=query2.list();
		
		for(Object[] emp1: employees) {
			System.out.println(emp1[0]+" : "+ emp1[1]+" : "+emp1[2]);
		}
		
		Query query3= session.createQuery("select sum(salary) from Employee where salary<50000");
	    Long totalSalary=(Long) query3.uniqueResult();
		
		System.out.println(totalSalary);
		

//		Random r=new Random();
//		for(int i=100;i<150;i++) {
//			emp= new Employee();
//			emp.setEid(i);
//			emp.setEname("name "+i);
//			emp.setSalary(r.nextInt(100000));
//			session.save(emp);
//			
//		}
		tx.commit();
		
		
		
	}

}
