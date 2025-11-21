package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "adh")
public class Aadhar {
	@Id
private long ano;
	private String aname;
	private int age;
	@OneToOne(cascade = CascadeType.ALL)
	private Person p;
public long getAno() {
		return ano;
	}
	public void setAno(long ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}


}
