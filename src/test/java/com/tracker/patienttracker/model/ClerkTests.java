package com.tracker.patienttracker.model;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/*
 * @author: Burre Chandu (883619)
 * 
 */
@SpringBootTest
public class ClerkTests {

	@Test
	public void testSetClerkId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Clerk clerk = new Clerk();
        clerk.setClerkId("ramu123");
        final Field field = clerk.getClass().getDeclaredField("clerkId");
        field.setAccessible(true);
        assertEquals("Setter passed", field.get(clerk), "ramu123");
        //assertEquals("Setter failed", field.get(clerk), "ramu124");
	}
	
	@Test
	public void testGetClerkId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Clerk clerk = new Clerk();
        final Field field = clerk.getClass().getDeclaredField("clerkId");
        field.setAccessible(true);
        field.set(clerk, "ramu123");
        assertEquals("Getter passed",clerk.getClerkId(), "ramu123");
        //assertEquals("Getter failed",clerk.getClerkId(), "ramu124");
	}
}
