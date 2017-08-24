package com.packt.ch04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.packt.ch04.pojo.Contact;

public class ContactDAOImpl implements ContactDAO {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		int record = 0;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("insert into Contact_CORE values(?,?,?,?,?,?)");
			ps.setString(1, contact.getFirstName());
			ps.setString(2, contact.getLastName());
			ps.setInt(3, contact.getGender());
			ps.setString(4, contact.getAddress());
			ps.setString(5, contact.getEmail());
			ps.setString(6, contact.getPhone_number());
			record = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return record;
	}

}
