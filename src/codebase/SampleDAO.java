package codebase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SampleDAO {
	private static final Connection CONNECTION = DatabaseConnection.getInstance();
	
	public List<String> getStudents() throws SQLException{
		String query = "select first_name from students;";
		
		List<String> studentNames = new ArrayList<String>();
		
		PreparedStatement statement = CONNECTION.prepareStatement(query);
		System.out.println(statement);
		//statement.setString(1, username);
		//statement.setString(2, password);
		
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			studentNames.add(resultSet.getString(1));
		}
		resultSet.close();
		CONNECTION.close();
		return studentNames;
	}
	
	public static void main (String [] args) throws SQLException{
		System.out.println(new SampleDAO().getStudents());
	}
}