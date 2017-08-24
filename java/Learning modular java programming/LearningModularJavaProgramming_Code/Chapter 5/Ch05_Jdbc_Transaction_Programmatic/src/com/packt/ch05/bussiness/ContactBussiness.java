package com.packt.ch05.bussiness;

import java.util.List;

import com.packt.ch05.pojo.Contact;

public interface ContactBussiness {
	int addContact(Contact contact);
	public Contact findContact(String email);
	public List<Contact> findAllContcats() ;

}
