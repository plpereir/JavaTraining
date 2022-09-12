package com.aula.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aula.model.Person;

public class PersonDao {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:./TestDataBase";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private String sql = null;
	private String defaultOrder = "ASC";
	
	

	private Connection connectionDB()

	{
		this.conn = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Database connected!");
			// STEP 4: Clean-up environment
		} catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("Database not connected, error: " + se.toString());
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("Database not connected, error: " + e.toString());

		}

		return this.conn;
	}

	private Boolean closeConnection() {
		try {
			this.conn.close();
			System.out.println("Database connection was closed with successful!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Database connection don't closed error: " + e.toString());
			return false;
		}
	}
	
	public Boolean createTable(String sqlCreate) {
		this.connectionDB();
		// STEP 3: Execute a query
		try {
			this.stmt = this.conn.createStatement();
			this.sql = sqlCreate;
			this.stmt.executeUpdate(sql);
			System.out.println("table created was successful!");
			
			this.sql = "SELECT * FROM INFORMATION_SCHEMA.TABLES";	
			this.rs = this.stmt.executeQuery(sql);

			// STEP 4: Extract data from result set
			while (this.rs.next()) {
				if (rs.getString(2).equals("PUBLIC"))
				{
					System.out.println("TABLE_CATALOG: 		"+rs.getString(1));
					System.out.println("TABLE_SCHEMA: 		"+rs.getString(2));
					System.out.println("TABLE_NAME: 		"+rs.getString(3));
					System.out.println("TABLE_TYPE: 		"+rs.getString(4));
					System.out.println("STORAGE_TYPE: 		"+rs.getString(5));
					System.out.println("SQL: 				"+rs.getString(6));
					System.out.println("REMARKS: 			"+rs.getString(7));
					System.out.println("LAST_MODIFICATION:  "+rs.getString(8));
					System.out.println("ID: 				"+rs.getString(9));
					System.out.println("TYPE_NAME: 			"+rs.getString(10));
					System.out.println("TABLE_CLASS: 		"+rs.getString(11));
					System.out.println("ROW_COUNT_ESTIMATE: "+rs.getString(12));
					System.out.println("--------------------------------------------------------------------------------------------------");
					
				}
				
			}			
			
			this.stmt.close();
			this.closeConnection();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Don't create table error: " + e.toString());
			this.connectionDB();
			return false;
		}	
	}

	public Boolean addPerson(Person person) {
		this.connectionDB();
		// STEP 3: Execute a query
		try {
			this.stmt = this.conn.createStatement();
			this.sql = "INSERT INTO PERSON (\"FIRST\", \"LAST\", AGE)" + "VALUES ( '" + person.getLast() + "', '"
					+ person.getFirst() + "', " + person.getAge() + ")";
			this.stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table with successful!");
			this.stmt.close();
			this.closeConnection();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Don't inserted records into the table error: " + e.toString());
			this.connectionDB();
			return false;
		}
	}

	public List<Person> addListPerson(List<Person> persons) {
		this.connectionDB();
		for (Person person : persons) {
			// STEP 3: Execute a query
			try {
				this.stmt = this.conn.createStatement();
				this.sql = "INSERT INTO PERSON (\"FIRST\", \"LAST\", AGE)" + "VALUES ( '" + person.getLast()
						+ "', '" + person.getFirst() + "', " + person.getAge() + ")";
				this.stmt.executeUpdate(sql);
				System.out.println("Inserted records into the table with successful!");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Don't inserted records into the table error: " + e.toString());
				this.connectionDB();

			}
		}

		this.closeConnection();
		return this.getAllPersons(this.defaultOrder);

	}

	public List<Person> removeListPerson(List<Person> persons) {
		this.connectionDB();
		for (Person updatePerson : persons) {
			try {
				this.stmt = this.conn.createStatement();
				this.sql = "DELETE PERSON " + "WHERE ID = " + updatePerson.getID() + "; ";
				this.stmt.executeUpdate(this.sql);

				// STEP 5: Clean-up environment

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("remove records as error: " + e.toString());
				this.connectionDB();
			}
		}

		this.closeConnection();
		return this.getAllPersons(this.defaultOrder);

	}

	public Person getPerson(int ID) {
		Person person = null;
		this.connectionDB();
		// STEP 3: Execute a query
		try {
			this.stmt = this.conn.createStatement();
			this.sql = "select * from PERSON where (PERSON.ID like " + ID + ")";
			this.rs = this.stmt.executeQuery(sql);

			// STEP 4: Extract data from result set
			while (this.rs.next()) {
				// Display values
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(", Age: " + rs.getInt("age"));
				System.out.print(", First: " + rs.getString("first"));
				System.out.println(", Last: " + rs.getString("last"));
				person = new Person(rs.getString("last"), rs.getString("first"), rs.getInt("age"), rs.getInt("id"));
			}
			// STEP 5: Clean-up environment
			this.rs.close();
			this.stmt.close();
			this.closeConnection();
			return person;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("list records as error: " + e.toString());
			this.connectionDB();
			return person;
		}
	}

	public List<Person> getAllPersons(String orderBy) {
		List<Person> persons = new ArrayList<Person>();
		this.connectionDB();
		// STEP 3: Execute a query
		try {
			this.stmt = this.conn.createStatement();
			this.sql = "select * from PERSON ORDER BY ID " + orderBy + "";
			this.rs = this.stmt.executeQuery(sql);

			// STEP 4: Extract data from result set
			while (this.rs.next()) {
				// Display values
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(", Age: " + rs.getInt("age"));
				System.out.print(", First: " + rs.getString("first"));
				System.out.println(", Last: " + rs.getString("last"));
				persons.add(new Person(rs.getString("last"), rs.getString("first"), rs.getInt("age"), rs.getInt("id")));
			}
			// STEP 5: Clean-up environment
			this.rs.close();
			this.stmt.close();
			this.closeConnection();
			return persons;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("list records as error: " + e.toString());
			this.connectionDB();
			return persons;
		}
	}

	public Person updatePerson(Person updatePerson) {
		Person person = null;
		this.connectionDB();
		// STEP 3: Execute a query
		try {
			this.stmt = this.conn.createStatement();
			this.sql = "UPDATE PERSON " + "SET AGE = " + updatePerson.getAge() + ", " + "\"FIRST\" = '"
					+ updatePerson.getFirst() + "', " + "\"LAST\" = '" + updatePerson.getLast() + "' " + "WHERE ID = "
					+ updatePerson.getID() + "; ";
			this.stmt.executeUpdate(this.sql);

			this.sql = "select * from PERSON where (PERSON.ID like " + updatePerson.getID() + ")";
			this.rs = this.stmt.executeQuery(sql);

			// STEP 4: Extract data from result set
			while (this.rs.next()) {
				// Display values
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(", Age: " + rs.getInt("age"));
				System.out.print(", First: " + rs.getString("first"));
				System.out.println(", Last: " + rs.getString("last"));
				person = new Person(rs.getString("last"), rs.getString("first"), rs.getInt("age"), rs.getInt("id"));
			}
			// STEP 5: Clean-up environment
			this.rs.close();
			this.stmt.close();
			this.closeConnection();
			return person;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("update records as error: " + e.toString());
			this.connectionDB();
			return person;
		}
	}

	public Boolean removePerson(Person updatePerson) {
		this.connectionDB();
		// STEP 3: Execute a query
		try {
			this.stmt = this.conn.createStatement();
			this.sql = "DELETE PERSON " + "WHERE ID = " + updatePerson.getID() + "; ";
			this.stmt.executeUpdate(this.sql);

			this.sql = "select * from PERSON ";
			this.rs = this.stmt.executeQuery(sql);

			// STEP 4: Extract data from result set
			while (this.rs.next()) {
				// Display values
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(", Age: " + rs.getInt("age"));
				System.out.print(", First: " + rs.getString("first"));
				System.out.println(", Last: " + rs.getString("last"));
			}
			// STEP 5: Clean-up environment
			this.rs.close();
			this.stmt.close();
			this.closeConnection();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("remove records as error: " + e.toString());
			this.connectionDB();
			return false;
		}
	}

}
