package com.packt.ch04.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.packt.ch04.pojo.Contact;

public class ContactDAOImpl extends JdbcDaoSupport implements ContactDAO {

	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		int record = 0;
		String SQL_INSERT_CONTACT = "insert into Contact_CORE values(?,?,?,?,?,?)";
		try {
			record = getJdbcTemplate().update(
					SQL_INSERT_CONTACT,
					new Object[] { contact.getFirstName(),
							contact.getLastName(), contact.getGender(),
							contact.getAddress(), contact.getEmail(),
							contact.getPhone_number() });
		} catch (DuplicateKeyException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return record;
	}
}
