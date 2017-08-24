package com.packt.ch06.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.packt.ch06.dao.ContactDAO;
import com.packt.ch06.pojo.Contact;

@Component(value = "contactBussiness")
public class ContactBussinessImpl implements ContactBussiness {

	@Autowired
	ContactDAO contactDAO;

	@Transactional
	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		if (checkContact(contact)) {
			System.out.println(" invoked adddao");
			return contactDAO.addContact(contact);
		}
		return 0;
	}
	
	@Transactional(readOnly = true,propagation=Propagation.MANDATORY)
	private boolean checkContact(Contact contact) {
		if (contactDAO.findContactToAdd(contact.getEmail()) == 0) {
			return true;
		}
		return false;
	}

	@Transactional(readOnly = true)
	public Contact findContact(String email) {
		// TODO Auto-generated method stub
		return contactDAO.findContact(email);
	}

	@Transactional(readOnly = true)
	public List<Contact> findAllContcats() {
		// TODO Auto-generated method stub
		return contactDAO.findAllContcats();
	}

}
