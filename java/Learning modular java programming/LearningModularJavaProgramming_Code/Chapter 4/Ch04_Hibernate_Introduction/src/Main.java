import com.packt.ch04.dao.ContactHibernateDao;
import com.packt.ch04.dao.ContactHibernateDaoImpl;
import com.packt.ch04.pojo.Contact;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContactHibernateDao dao=new ContactHibernateDaoImpl();
		Contact contact=new Contact();
		contact.setEmail("billy@abc.com");
		contact.setAddress("Pune");
		contact.setFirstName("billy");
		contact.setLastName("brown");
		contact.setGender(1);
		contact.setPhone_number("7876432123");
		
		String email=dao.insertContact(contact);
		if(email!=null)
		{
		System.out.println("data inserted successfully with id:- "+email);
		}
		else {
			System.out.println("please choose new mail ID");
		}

	}

}
