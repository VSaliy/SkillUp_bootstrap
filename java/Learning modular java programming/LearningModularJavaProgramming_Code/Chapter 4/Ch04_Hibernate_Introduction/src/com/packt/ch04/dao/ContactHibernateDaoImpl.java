package com.packt.ch04.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.packt.ch04.pojo.Contact;

public class ContactHibernateDaoImpl implements ContactHibernateDao {

	public String insertContact(Contact contact) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory;
		Transaction transaction=null;
		try{
		sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		String email=(String)session.save(contact);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return email;
		}catch (ConstraintViolationException e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}
		return null;
	}

}
