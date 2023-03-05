package com.coding.HibernateDemo;

import javax.persistence.Cacheable;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import javax.persistence.Transient;

@Entity(name = "alien_table")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)//By Default no startegy is configured
public class Alien {  //POJO
	
	@Id
	private int aid;
	//@Transient   //will not include this firld as column name if we use this 
	private AlienName aname;
	//@Column(name = "alien_color")
	private String color;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	
	

}
