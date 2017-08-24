package com.packt.ch04.dao;

import java.util.List;

import com.packt.ch04.pojo.Contact;

public interface ContactDAO {
	int addContact(Contact contact);
	public Contact findContact(String email);
	public List<Contact> findAllContcats() ;


}
