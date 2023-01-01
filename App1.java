import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class App1
{
    Connection c = null;
    Statement st = null;
    public String addNewBook (String id, String author,String book_name,String publication_year,String publisher,String publication_city,String location,String cost) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
            System.out.println( "Open Successfully!" );
            st = c.createStatement();
            String sql = "INSERT INTO books(id,author,book_name,publication_year,publisher,publication_city,location,cost) "+ "VALUES(" + "'"+id + "'"+"," + "'"+author+"'"+","+ "'"+ book_name +"'"+ "," + "'"+publication_year + "'"+"," +"'"+ publisher + "'"+"," + "'"+publication_city + "'"+"," + "'"+location + "'"+"," + "'"+cost + "'"+ ")";
            st.executeUpdate(sql);
            st.close();
            c.close();
            return "Book Added";
        } catch (Exception e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return "fail";
        }
    }
}
