package com.packt.ch07.bussiness;

import java.util.List;

import com.packt.ch07.pojo.Contact;

public interface ContactBussiness {
	int addContact(Contact contact);
	public Contact findContact(String email);
	public List<Contact> findAllContcats() ;

}
