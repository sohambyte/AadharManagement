package com.logic;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Aadhar;
import com.model.HibernateUtil;
import com.model.Person;

public class Logic {
	Scanner sc=new Scanner(System.in);
public void insert() {
	Session ses=HibernateUtil.getSessionFactory().openSession();
	System.out.println("Enter Num of person you want to add :");
	int num=sc.nextInt();
	for(int i=1;i<=num;i++) {
		Person p=new Person();
		System.out.println("Enter Person Id :");
		p.setPid(sc.nextInt());
		System.out.println("Enter Person Name :");
		p.setPname(sc.next()+sc.nextLine());
		System.out.println("Enter Person Address :");
		p.setAddr(sc.next()+sc.nextLine());
		
		Aadhar a=new Aadhar();
		System.out.println("Enter Aadhar Number (must be 12 Digits):");
		a.setAno(sc.nextLong());
//		while(true) {
//			long an=sc.nextLong();
//			for(long j=an;j>0;j=j/10) {
//				long div=j%10;
//				
//			}
//			if(an<=12 && an>=12) {
//				a.setAno(an);
//				break;
//			}else {
//				System.out.println("Enter 12 Digits");
//			}
//		}
		System.out.println("Enter Name as on Aadhar Card:");
		a.setAname(sc.next()+sc.nextLine());
		System.out.println("Enter Age :");
		a.setAge(sc.nextInt());
		
		p.setA(a);
		a.setP(p);
		
		ses.persist(a);
	}
	
	ses.beginTransaction().commit();
}
public void showall() {
	Session ses=HibernateUtil.getSessionFactory().openSession();
	String hql="from Person";
	
	
	Query<Person> qa=ses.createQuery(hql,Person.class);
	List<Person> p=qa.getResultList();
	for(Person p1:p) {
	System.out.println("Person ID : "+p1.getPid());
	System.out.println("Person Name : "+p1.getPname());
	System.out.println("Person Address : "+p1.getAddr());
	System.out.println("Do you want to see addhar Details :(Yes-1/No-0) ");
	int ch=sc.nextInt();
	if(ch==1) {
		System.out.println("Aadhar Number is : "+p1.getA().getAno());
		System.out.println("Person Name on Adhar is : "+p1.getA().getAname());
		System.out.println("Age is : "+p1.getA().getAge());
	}
	}
	
	ses.beginTransaction().commit();
}
public void show() {
	Session ses=HibernateUtil.getSessionFactory().openSession();
	System.out.println("Enter Person Id :");
	int id=sc.nextInt();
	Person p=ses.get(Person.class, id);
	System.out.println("Person ID : "+p.getPid());
	System.out.println("Person Name : "+p.getPname());
	System.out.println("Person Address : "+p.getAddr());
	
	ses.beginTransaction().commit();
}
public void update() {
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	String hql="update Person set pname=?1 where pid=?2 ";
	System.out.println("Enter Person Id :");
	int id=sc.nextInt();
	System.out.println("Enter Person Name :");
	String nm=sc.next();
	
	Query<Person> q=ses.createQuery(hql,Person.class);
	q.setParameter(nm, 1);
	q.setParameter(id, 2);
	q.executeUpdate();
	tx.commit();
	ses.close();
	
	
}
public void delete() {
	
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	String hql="delete from Person where pid=?1 ";
	System.out.println("Enter Person Id :");
	int id=sc.nextInt();
	
	
	Query<Person> q=ses.createQuery(hql,Person.class);
	q.setParameter(id, 1);
	q.executeUpdate();
	tx.commit();
	ses.close();
}
}
