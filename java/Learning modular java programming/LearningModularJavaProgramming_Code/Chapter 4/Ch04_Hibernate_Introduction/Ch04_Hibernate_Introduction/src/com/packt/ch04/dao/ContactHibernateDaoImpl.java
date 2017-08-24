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
		SessionFactory sessionFactory=null;
		Transaction transaction = null;
		Session session = null;
		String email=null;
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			email = (String) session.save(contact);
			transaction.commit();
			
		} catch (ConstraintViolationException e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		return email;
	}

}
