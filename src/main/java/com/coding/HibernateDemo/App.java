package com.coding.HibernateDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
		
		int b=50000;
		Query query4= session.createQuery("select sum(salary) from Employee where salary< "+b);
	    Long totalSalary1=(Long) query4.uniqueResult();
		
		System.out.println(totalSalary1);
		
		Query query5= session.createQuery("select sum(salary) from Employee where salary< :b");
		query5.setParameter("b", b);
	    Long totalSalary2=(Long) query5.uniqueResult();
		
		System.out.println(totalSalary2);
		
		//Native Query
		SQLQuery query6=session.createSQLQuery("Select eid,salary from employee e where e.eid < 125");
		query6.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List employees1=query6.list();
		
		for(Object o: employees1) {
			Map m= (Map)o;
			System.out.println(m.get("eid")+" : "+m.get("salary"));
		}
		
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
