import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class App 
{
Connection c = null;
	Statement st = null;
public boolean checkBook(String name) {
		String id = null;
		try {
    		Class.forName("org.postgresql.Driver");
    		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
    		System.out.println( "Open Successfully!" );
    		st = c.createStatement(); 
    		ResultSet rs = st.executeQuery("SELECT id FROM books WHERE book_name = " +"'" +name +"'");
    		while(rs.next()) {
    			id = rs.getString("id");
    		}
    		System.out.println("id: " + id);
    		rs.close();
    		String r = null;
    		ResultSet rslt = st.executeQuery("SELECT id FROM orders WHERE book_id = " +"'" +id +"'"+ "AND back_date IS NULL");
    		while(rslt.next()) {
    			r = rslt.getString("id");
    		}
    		rslt.close();
    		st.close();
    		c.close();
    		if(r != null) {
    			//System.out.println("Book taken");
    			
    			return false;
    		}else {
    			//System.out.println("Book avaliable");
    			return true;
    		}
    	} catch (Exception e) {
    		System.out.println("Connection Failed");
    		e.printStackTrace();
    		return false;
    	}
		
		
	}

}
