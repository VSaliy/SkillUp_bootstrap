package com.packt.ch04.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.packt.ch04.pojo.Contact;

public class ContacHibDao {
	
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int addContact(Contact contact)
	{
		hibernateTemplate.persist(contact);
		return 0;
	}
}
