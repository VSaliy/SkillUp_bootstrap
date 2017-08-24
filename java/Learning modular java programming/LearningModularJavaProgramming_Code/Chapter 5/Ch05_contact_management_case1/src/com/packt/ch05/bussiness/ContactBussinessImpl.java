package com.packt.ch05.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.packt.ch05.dao.ContactDAO;
import com.packt.ch05.pojo.Contact;

@Component(value="contactBussiness")
public class ContactBussinessImpl implements ContactBussiness {

	@Autowired
	ContactDAO contactDAO;

	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		if(checkContact(contact))
		{
			return contactDAO.addContact(contact);
		}
		return 0;

	}
	
	private boolean checkContact(Contact contact)
	{
		if(contactDAO.findContactToAdd(contact.getEmail())==0)
		{
			return true;
		}
		return false;
	}

}
