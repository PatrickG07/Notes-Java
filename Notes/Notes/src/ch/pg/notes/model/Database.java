package ch.pg.notes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

	public static String data = "";
	public static int ID;

	public List<String> Liste01 = new ArrayList<String>();

	static String brek = System.getProperty("line.separator");

	static Connection con;

	private void database() {
		try {
			Class.forName("org.sqlite.JDBC").newInstance();
			con = DriverManager.getConnection("jdbc:sqlite:Notes.db");
			System.out.println("connection made...");

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
	}

	public void databaseinsert() throws SQLException {
		database();
		PreparedStatement stmt = con.prepareStatement("INSERT INTO notesT(text) VALUES(?)");
		try {
			stmt.setString(1, data);
			stmt.execute();
			System.out.println("Data is inserted 1");
			stmt.close();
		} catch (SQLException e1) {
		}
	}

	public void databaseupdate() throws SQLException {
			PreparedStatement stmt = con.prepareStatement("UPDATE notesT SET text = ? WHERE ID = ?");
			try {
				stmt.setString(1, data);
				stmt.setInt(2, ID);
				stmt.execute();
				System.out.println("Data is inserted 1");
				stmt.close();
			} catch (SQLException e1) {
				System.out.println("whrong");
			}
	}

	public void databaseselect() throws SQLException {
		database();

		String select = "SELECT text FROM notesT";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(select);
		System.out.print(rs);
		try {
			while (rs.next()) {
				String name = rs.getString("text");
				Liste01.add(name);
			}
			System.out.println(Liste01);
			stmt.close();
		} catch (SQLException e1) {
		}
	}

	public void databaseselectID() throws SQLException {
		database();
		String select = "SELECT ID FROM notesT WHERE TEXT = '" + data + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(select);
		System.out.print(rs);
		try {
			ID = rs.getInt("ID");
			stmt.close();
		} catch (SQLException e1) {
		}
	}

	public void databasedelete() throws SQLException {
		database();
		String select = "DELETE FROM notesT WHERE text = '" + data + "'";
		Statement stmt = con.createStatement();
		stmt.executeQuery(select);
		stmt.close();
	}
}
