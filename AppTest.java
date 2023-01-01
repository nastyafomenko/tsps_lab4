import static org.junit.Assert.assertEquals;


import java.sql.SQLException;

import org.junit.Test;

public class AppTest
{
    App app = new App();

    public void checkRightOrderCreating() throws SQLException
    {
        assertEquals("order created", app.createOrder("2", "Замок", "o1978shew", true, true));
    }
    @Test
    public void checkBookFalseOrderCreating() throws SQLException
    {
        assertEquals("Book already reserved", app.createOrder("2", "Як працює Google", "o1978shew", false, true));
    }
    @Test
    public void checkStudentFalseOrderCreating() throws SQLException
    {
        assertEquals("Student has 10 books", app.createOrder("2", "Як працює Google", "o1978shew", true, false));
    }
    @Test
    public void checkBothFalseOrderCreating() throws SQLException
    {
        assertEquals("Book already reserved", app.createOrder("2", "Як працює Google", "o1978shew", false, false));
    }

}
