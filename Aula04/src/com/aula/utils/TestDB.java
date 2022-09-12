package com.aula.utils;

import java.util.ArrayList;
import java.util.List;

import com.aula.factory.PersonDao;
import com.aula.model.Person;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonDao dao = new PersonDao();
		Person person = new Person("Pereira","Pedro",41,28);
		//System.out.println(dao.addPerson(person));
		//System.out.println(dao.getPerson(4));
		
		
		//System.out.println(dao.getAllPersons("DESC"));
		
		//System.out.println(dao.updatePerson(person));
		
		System.out.println(dao.removePerson(person));
		/*
		List<Person> persons = new ArrayList<Person>();
		person = new Person(21);
		persons.add(person);
		person = new Person(22);
		persons.add(person);
		person = new Person(23);
		persons.add(person);
		person = new Person(24);
		persons.add(person);
		person = new Person(25);
		persons.add(person);
		person = new Person(26);
		persons.add(person);
		person = new Person(27);
		persons.add(person);
		*/
		//System.out.println(dao.addListPerson(persons));
		
		//System.out.println(dao.removeListPerson(persons));
		
		//System.out.println(dao.createTable("CREATE TABLE IF NOT EXISTS TEST2(ID INT IDENTITY PRIMARY KEY, NAME VARCHAR(255));"));
		
		
	}

}
