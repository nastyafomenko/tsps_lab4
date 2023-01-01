import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.sql.SQLException;

import org.junit.Test;

public class AppTest1
{
    App1 app = new App1();
    @Test
    public void checkAddingBook() throws SQLException
    {
        assertEquals("Book Added", app.addNewBook("28541", "Роберт Мартін", "Чиста архітектура", "2020", "Фабула", "Харків", "абонемент", "688"));
    }

}
