package project.library;

//import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.net.MalformedURLException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
		AppUser apUs = new AppUser();
	    @Test
    public void checkRightAuthorization() throws MalformedURLException
    {
    	assertEquals("right password", apUs.authorization("anna12lr"));
    }
    @Test
    public void checkWrongAuthorization() throws MalformedURLException
    {
    	assertEquals("wrong password", apUs.authorization("Bnna12lr"));
    }
    @Test
    public void checkRegistration() throws MalformedURLException
    {
    	assertEquals("User registred", apUs.register("anOlks19", "Богданова Анна Олександрівна", "12.04.1999", "+380958324651"));
    }
}


