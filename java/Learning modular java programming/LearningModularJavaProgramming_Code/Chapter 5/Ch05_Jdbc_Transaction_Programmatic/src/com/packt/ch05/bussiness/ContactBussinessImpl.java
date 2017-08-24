package com.packt.ch05.bussiness;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.packt.ch05.dao.ContactDAO;
import com.packt.ch05.pojo.Contact;

@Component(value = "contactBussiness")
public class ContactBussinessImpl implements ContactBussiness {

	@Autowired
	ContactDAO contactDAO;
	@Autowired
	PlatformTransactionManager transactionManager;

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}


	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		TransactionDefinition definition=new DefaultTransactionDefinition();
		
		TransactionStatus status=transactionManager.getTransaction(definition);
		if (checkContact(contact)) {
			transactionManager.commit(status);
			return contactDAO.addContact(contact);
		}
		
		return 0;
	}
	

	private boolean checkContact(Contact contact) {
		if (contactDAO.findContactToAdd(contact.getEmail()) == 0) {
			return true;
		}
		return false;
	}

	
	public Contact findContact(String email) {
		// TODO Auto-generated method stub
		TransactionDefinition definition=new DefaultTransactionDefinition();
		((DefaultTransactionDefinition)definition).setReadOnly(true);
		TransactionStatus status=transactionManager.getTransaction(definition);
		return contactDAO.findContact(email);
	}

	
	public List<Contact> findAllContcats() {
		// TODO Auto-generated method stub
		TransactionDefinition definition=new DefaultTransactionDefinition();
		((DefaultTransactionDefinition)definition).setReadOnly(true);
		TransactionStatus status=transactionManager.getTransaction(definition);
		return contactDAO.findAllContcats();
	}

}
