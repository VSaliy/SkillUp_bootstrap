package com.packt.ch06.dao;

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

import com.packt.ch06.pojo.Contact;

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

	public List<Contact> findAllContcats() {
		// TODO Auto-generated method stub
		String sql = "select firstname,lastname,gender,address,email,phone_number from Contact_CORE";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		List<Contact> allContacts = new ArrayList<Contact>();
		if (list != null && !list.isEmpty()) {
			for (Map<String, Object> contacts : list) {

				Contact contact=new Contact();
				Object []ob_arr=new Object[6];
				int i=0;
				for (Iterator<Map.Entry<String, Object>> it = contacts.entrySet()
						.iterator(); it.hasNext();) {
					Map.Entry<String, Object> entry = it.next();
					String key = entry.getKey();
					 ob_arr[i]=entry.getValue();
					 
					 i++;
				}
				contact.setFirstName((String)ob_arr[0]);
				contact.setLastName((String)ob_arr[1]);
				contact.setGender((Integer)ob_arr[2]);
				contact.setAddress((String)ob_arr[3]);
				contact.setEmail((String)ob_arr[4]);
				contact.setPhone_number((String)ob_arr[5]);
				allContacts.add(contact);
			}
		}
		return allContacts;

	}
}
