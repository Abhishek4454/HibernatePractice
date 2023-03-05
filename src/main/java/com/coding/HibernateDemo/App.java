package com.coding.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
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
//
//		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		
		Laptop laptop= new Laptop();
		laptop.setLid(101);
		laptop.setLname("HP");
		
		Student student= new Student();
		student.setMarks(56);
		student.setRollno(1);
		student.setName("Abhishek");
		student.setLaptop(laptop);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
//		session.save(alien);
		
		// Alien alien= session.get(Alien.class,101);
		
		session.save(laptop);
		session.save(student);
		tx.commit();
		//System.out.println(alien.toString());
	}

}
