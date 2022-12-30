import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App
{
    Connection c = null;
    Statement st = null;
    public String createOrder (String student_id, String book_name, String user, boolean avaliable, boolean student) {
        if (avaliable == true && student == true) {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
                System.out.println( "Open Successfully!" );
                st = c.createStatement();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now = LocalDateTime.now();
                String issue_date = dtf.format(now);
                ResultSet rs = st.executeQuery("SELECT id FROM books WHERE book_name = "+"'"+book_name+"'");
                String book_id = null;
                while(rs.next()) {
                    book_id = rs.getString("id");
                }

                String sql = "INSERT INTO orders(student_id,book_id,librarian,issue_date) "+ "VALUES(" + "'"+student_id + "'"+"," + "'"+book_id+"'"+","+ "'"+ user +"'"+ "," + "'"+issue_date + "'"+ ")";
                st.executeUpdate(sql);
                st.close();
                c.close();
                return "order created";
            } catch (Exception e) {
                System.out.println("Connection Failed");
                e.printStackTrace();
                return "fail connection";
            }
        }
        else if(avaliable == false) {
            return "Book already reserved";
        }else {
            return "Student has 10 books";
        }
    }

}
