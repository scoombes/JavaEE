/**
 * 
 */
package com.seanjohn.nhl.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.derby.jdbc.ClientDataSource;

/**
 * @author black
 *
 */
public class GenericIO {

	protected Connection db = null;
	protected String username = null;
	protected String password = null;
	
	public GenericIO(String username, String password) {
		this.username = username;
		this.password = password;
		aquireConnection();
	}
	
	protected Connection aquireConnection() {
	
		String user = "jsteel";
		String pass = "password";
		
		Properties connectionProps = new Properties();
		try {
			connectionProps.put(this.username, user);
			connectionProps.put(this.password, pass);
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			int traceLevel = ClientDataSource.TRACE_STATEMENT_CALLS  | 
							 ClientDataSource.TRACE_CONNECTION_CALLS | 
							 ClientDataSource.TRACE_RESULT_SET_CALLS;
			String derbyURI = String.format("jdbc:derby://localhost:1527/sample;traceFile=trace.out;"
					+ "traceLevel=%d", traceLevel);
			db = DriverManager.getConnection(derbyURI, connectionProps);
		} catch (SQLException e) {
			System.err.println("Failed to connect to Derby server.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Derby driver not found.");
			e.printStackTrace();
		}

		return db;
	}
}
