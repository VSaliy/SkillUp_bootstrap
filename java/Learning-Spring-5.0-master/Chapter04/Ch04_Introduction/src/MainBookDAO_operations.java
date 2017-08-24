import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO;
import com.packt.ch03.dao.BookDAO_new;

public class MainBookDAO_operations {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("connection_new.xml");
		BookDAO bookDAO=(BookDAO) context.getBean("bookDAO_jdbcTemplate");
		//add book
		int rows=bookDAO.addBook(new Book("Java EE 7 Developer Handbook", 97815674L,"PacktPub publication",332,"explore the Java EE7 programming","Peter pilgrim"));
	    if(rows>0)
	    {
	    	System.out.println("book inserted successfully");
	    }
	    else
	    	System.out.println("SORRY!cannot add book");

	    //update the book
		rows=bookDAO.updateBook(97815674L,432);
	    if(rows>0)
	    {
	    	System.out.println("book updated successfully");
	    }
	    else
	    	System.out.println("SORRY!cannot update book");

	    String desc=((BookDAO_new)bookDAO).getDescription(97815674L);
	    System.out.println(desc);
	    
	    //delete the book
	    boolean deleted=bookDAO.deleteBook(97815674L);
	    if(deleted)
	    {
	    	System.out.println("book deleted successfully");
	    }
	    else
	    	System.out.println("SORRY!cannot delete book");

	}


}
