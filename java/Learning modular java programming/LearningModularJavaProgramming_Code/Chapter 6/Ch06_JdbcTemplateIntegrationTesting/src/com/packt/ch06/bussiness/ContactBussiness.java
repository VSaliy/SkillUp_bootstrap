package com.packt.ch06.bussiness;

import java.util.List;

import com.packt.ch06.pojo.Contact;

public interface ContactBussiness {
	int addContact(Contact contact);
	public Contact findContact(String email);
	public List<Contact> findAllContcats() ;

}
