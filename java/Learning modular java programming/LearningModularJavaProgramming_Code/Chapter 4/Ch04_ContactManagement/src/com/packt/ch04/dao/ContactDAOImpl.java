package com.packt.ch04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.packt.ch04.pojo.Contact;

public class ContactDAOImpl implements ContactDAO{
	private Connection connection;
	public ContactDAOImpl() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactDB","root","mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addContact(Contact contact)
	{
		int record=0;
		try {
			PreparedStatement ps=connection.prepareStatement("insert into Contact_CORE values(?,?,?,?,?,?)");
			ps.setString(1,contact.getFirstName());
			ps.setString(2,contact.getLastName());
			ps.setInt(3,contact.getGender());
			ps.setString(4,contact.getAddress());
			ps.setString(5,contact.getEmail());
			ps.setString(6,contact.getPhone_number());
			record=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}

}
