package codebase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public final class DatabaseConnection {
	private static final Connection CONNECTION_INSTANCE = getConnection();

	public static void main (String []args){
		System.out.println(getConnection());
	}
	private static final Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String userName = getUserName();
			String url = getDatabaseUrl();
			String password = getPassword();
			System.out.println(url + "\t" + "\t" + userName + "\t" + password);
			return DriverManager.getConnection(url, userName, password);
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static Connection getInstance(){
		return CONNECTION_INSTANCE;
	}

	public static String getUserName(){
		String userName = "";

		try (
				FileReader fr = new FileReader("utils//databaseInfo.txt");
				BufferedReader bfr = new BufferedReader(fr);){
			String currentLine = "";
			while ((currentLine = bfr.readLine()) != null){
				currentLine = currentLine.trim();
				if (currentLine.startsWith("username:")){
					String [] splitString = currentLine.split(": ");
					if (splitString.length == 2){
						userName = splitString[1].trim();
					}
				}
			}
		} catch (IOException e) {
			return userName;
		}
		return userName;
	}

	public static String getPassword(){
		String password = "";

		try (
				FileReader fr = new FileReader("utils//databaseInfo.txt");
				BufferedReader bfr = new BufferedReader(fr);){
			String currentLine = "";
			while ((currentLine = bfr.readLine()) != null){
				currentLine = currentLine.trim();
				if (currentLine.startsWith("password:")){
					String [] splitString = currentLine.split(": ");
					if (splitString.length == 2){
						password = splitString[1].trim();
					}
				}
			}
		} catch (IOException e) {
			return password;
		}
		return password;
	}

	public static String getDatabaseUrl(){
		String databaseURL = "";

		try (
				FileReader fr = new FileReader("utils//databaseInfo.txt");
				BufferedReader bfr = new BufferedReader(fr);){
			String currentLine = "";
			while ((currentLine = bfr.readLine()) != null){
				currentLine = currentLine.trim();
				if (currentLine.startsWith("url:")){
					String [] splitString = currentLine.split(": ");
					if (splitString.length == 2){
						databaseURL = splitString[1].trim();
					}
				}
			}
		} catch (IOException e) {
			return databaseURL;
		}
		return databaseURL;
	}
}