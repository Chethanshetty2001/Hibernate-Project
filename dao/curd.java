package dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import dto.demo;

public class curd {
	EntityManagerFactory e = Persistence.createEntityManagerFactory("dev");
	EntityManager m = e.createEntityManager();
	EntityTransaction t = m.getTransaction();
	
	public void add(String name,String address,long number){
		demo d = new demo();
		d.setName(name);
		d.setAddress(address);
		d.setNumber(number);
		
		t.begin();
		m.persist(d);
		t.commit();
	}
	public void update(int id,String newname){
		demo d = m.find(demo.class,id);
		d.setName(newname);
		t.begin();
		m.merge(d);
		t.commit();
		System.out.println("updated");
	}
	public void fetch(int id){
		demo d = m.find(demo.class,id);
		System.out.println(d.getId());
		System.out.println(d.getName());
		System.out.println(d.getAddress());
		System.out.println(d.getNumber());
		System.out.println(".........");
	}
	public void remove(int id){
		demo d = m.find(demo.class,id);
		t.begin();
		m.remove(d);
		t.commit();
		System.out.println("removed");
	}
}
