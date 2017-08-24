package com.packt.ch05.dao;

import java.util.List;

import com.packt.ch05.pojo.Contact;

public interface ContactDAO {
	int addContact(Contact contact);
	Contact findContact(String email);
	int findContactToAdd(String email);
}
