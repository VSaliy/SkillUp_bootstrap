package com.packt.ch05.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.packt.ch05.pojo.Contact;

public class ContactDAOImpl implements ContactDAO {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		int record = 0;
		String SQL_INSERT_CONTACT = "insert into Contact_CORE values(?,?,?,?,?,?)";
		try{
		record = jdbcTemplate.update(
				SQL_INSERT_CONTACT,
				new Object[] { contact.getFirstName(), contact.getLastName(),
						contact.getGender(), contact.getAddress(),
						contact.getEmail(), contact.getPhone_number() });
		}catch (DuplicateKeyException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return record;
	}
	public int findContactToAdd(String email)
	{
		String sql = "select COUNT(*) from Contact_CORE where email=?";
		return jdbcTemplate.queryForInt(sql,email);
	}
	
	public Contact findContact(String email) {
		// TODO Auto-generated method stub
		
		String sql = "select firstname,lastname,gender,address,email,phone_number from Contact_CORE where email=?";
		return (Contact) jdbcTemplate.queryForObject(sql, new RowMapper<Contact>() {

			public Contact mapRow(ResultSet rs, int row_num) throws SQLException {
				// TODO Auto-generated method stub

				Contact contact = new Contact();
				contact.setFirstName(rs.getString(1));
				contact.setLastName(rs.getString(2));
				contact.setGender(rs.getInt(3));
				contact.setAddress(rs.getString(4));
				contact.setEmail(rs.getString(5));
				contact.setPhone_number(rs.getString(6));
				return contact;
			}
		}, email);
	}


}
