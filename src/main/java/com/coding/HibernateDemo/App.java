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
//		AlienName an = new AlienName();
//		an.setFname("chuchu");
//		an.setMname("Neha");
//		an.setLname("Sinha");
//		Alien alien = new Alien();
//		alien.setAid(101);
//		alien.setAname(an);
//		alien.setColor("Blue");

		
//		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
//		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
//		SessionFactory sf = con.buildSessionFactory(reg);
//		Session session1 = sf.openSession();
//		Transaction tx = session1.beginTransaction();
//		//Because of 1st level cache hibernate is able to reuse the same query 
//		//Alien al = session1.get(Alien.class, 101);
//		//al = session1.get(Alien.class, 101);
//		Query<Alien> q1=session1.createQuery("from alien_table where aid=101");
//		q1.setCacheable(true);
//		Alien al=q1.uniqueResult();
//		System.out.println(al.toString());  
//		tx.commit();
//		session1.close();
//		
//		//Here new session has been opened and same query is being fired but 
//		//Query is not cached
//		//Usecase to be done for EH Cache i.e 2nd level Caching
//		Session session2 = sf.openSession();
//		Transaction tx1 = session2.beginTransaction();
//		//Alien al2 = session2.get(Alien.class, 101);
//		//al2 = session2.get(Alien.class, 101);
//		Query<Alien> q2=session2.createQuery("from alien_table where aid=101");
//		q2.setCacheable(true);
//		al=q2.uniqueResult();
//		System.out.println(al.toString());  
//		tx1.commit();
//		session2.close();
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
