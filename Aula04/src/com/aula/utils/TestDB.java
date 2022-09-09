package com.aula.utils;

import java.util.ArrayList;
import java.util.List;

import com.aula.factory.DBManager;
import com.aula.model.Person;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBManager db = new DBManager();
		Person person = new Person(14);
		//System.out.println(db.addPerson(person));
		//System.out.println(db.getPerson(4));
		
		
		System.out.println(db.getAllPersons("DESC"));
		
		//System.out.println(db.updatePerson(person));
		
		// System.out.println(db.removePerson(person));
		/*
		List<Person> persons = new ArrayList<Person>();
		person = new Person(14);
		persons.add(person);
		person = new Person(15);
		persons.add(person);
		person = new Person(16);
		persons.add(person);
		person = new Person(17);
		persons.add(person);
		person = new Person(18);
		persons.add(person);
		person = new Person(19);
		persons.add(person);
		person = new Person(20);
		persons.add(person);
		*/
		//System.out.println(db.addListPerson(persons));
		
		//System.out.println(db.removeListPerson(persons));
		
		//System.out.println(db.createTable("CREATE TABLE IF NOT EXISTS TEST2(ID INT IDENTITY PRIMARY KEY, NAME VARCHAR(255));"));
		
		
	}

}
