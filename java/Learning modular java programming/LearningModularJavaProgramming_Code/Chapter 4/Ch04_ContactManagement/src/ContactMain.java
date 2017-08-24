import com.packt.ch04.dao.ContactDAO;
import com.packt.ch04.dao.ContactDAOImpl;
import com.packt.ch04.pojo.Contact;


public class ContactMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactDAO contactDAO=new ContactDAOImpl();
		Contact contact=new Contact();
		contact.setFirstName("John");
		contact.setLastName("Ray");
		contact.setGender(1);
		contact.setAddress("JB Road");
		contact.setEmail("john@gmail.com");
		contact.setPhone_number("9845321234");
		int record=contactDAO.addContact(contact);
		if(record==1)
		{
			System.out.println("RECORD INSERTED SUCCESSFULLY");
		}
		else {
			System.out.println("RECORD NOT INSERTED PLEASE TRY AGAIN");
		}

	}

}
