import static org.junit.Assert.assertEquals;


import java.sql.SQLException;

import org.junit.Test;

public class AppTest 
{
@Test
    public void checkBookNotTaken() throws SQLException
    {
    	assertEquals(true, app.checkBook("Гаррі Поттер і філософський камінь"));
    }
    @Test
    public void checkBookTaken() throws SQLException
    {
    	assertEquals(false, app.checkBook("Як працює Google"));
    }
}
