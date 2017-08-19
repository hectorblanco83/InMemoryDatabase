package hb;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Simple test with in memory database
 */
public class TestInMemoryDatabase {
	
	
	@Test
	public void testH2() throws Exception {
		// simply open the connection to a "testcase" database,
		// using sa as user with no password
		Class.forName("org.h2.Driver");
		Connection dbConnection = DriverManager.getConnection("jdbc:h2:mem:testcase", "sa", null);
		
		// get a Statement object
		Statement stmt = dbConnection.createStatement();
		
		// create a table
		stmt.execute("CREATE TABLE foo (id INTEGER)");
		dbConnection.commit();
		
		// insert data on that table
		stmt.execute("INSERT INTO foo(id) VALUES (1)");
		
		// and query for it
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM foo");
		if (resultSet.next()) {
			assert 1 == resultSet.getInt(1);
		}
	}
	
	
	@Test
	public void testHSQL() throws Exception {
		// simply open the connection to a "testcase" database,
		// using sa as user with no password
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		Connection dbConnection = DriverManager.getConnection("jdbc:hsqldb:mem:testcase", "sa", null);
		
		// get a Statement object
		Statement stmt = dbConnection.createStatement();
		
		// create a table
		stmt.execute("CREATE TABLE foo (id INTEGER)");
		dbConnection.commit();
		
		// insert data on that table
		stmt.execute("INSERT INTO foo(id) VALUES (1)");
		
		// and query for it
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM foo");
		if (resultSet.next()) {
			assert 1 == resultSet.getInt(1);
		}
	}
	
}
