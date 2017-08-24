package com.packt.ch07.dao;

import java.util.List;

import com.packt.ch07.pojo.Contact;

public interface ContactDAO {
	int addContact(Contact contact);
	public Contact findContact(String email);
	public List<Contact> findAllContcats() ;
	int findContactToAdd(String email);
}
