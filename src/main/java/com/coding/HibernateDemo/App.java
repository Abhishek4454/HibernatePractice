package com.coding.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {
		AlienName an = new AlienName();
		an.setFname("chuchu");
		an.setMname("Neha");
		an.setLname("Sinha");
		Alien alien = new Alien();
		alien.setAid(101);
		alien.setAname(an);
		alien.setColor("Blue");

		
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		Transaction tx = session1.beginTransaction();
		//Because of 1st level cache hibernate is able to reuse the same query 
		Alien al = session1.get(Alien.class, 101);
		al = session1.get(Alien.class, 101);
		System.out.println(al.toString());  
		tx.commit();
		session1.close();
		
		//Here new session has been opened and same query is being fired but 
		//Query is not cached
		//Usecase to be done for EH Cache i.e 2nd level Caching
		Session session2 = sf.openSession();
		Transaction tx1 = session2.beginTransaction();
		Alien al2 = session2.get(Alien.class, 101);
		al2 = session2.get(Alien.class, 101);
		System.out.println(al.toString());  
		tx1.commit();
		session2.close();
		
		
		
		
	}

}
