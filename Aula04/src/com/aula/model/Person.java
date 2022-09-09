package com.aula.model;

public class Person {
	
	private String last;
	private String first;
	private int age;
	private int ID;
	
	public Person(int ID) {
		this.setID(ID);
	}
	
	public Person(String last, String first, int age) {
		this.setAge(age);
		this.setFirst(first);
		this.setLast(last);
	}
	
	public Person(String last, String first, int age, int ID) {
		
		this.setID(ID);
		this.setAge(age);
		this.setFirst(first);
		this.setLast(last);
	}
	
	
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "Person [last=" + last + ", first=" + first + ", age=" + age + ", ID=" + ID + "]";
	}
	
	

}
