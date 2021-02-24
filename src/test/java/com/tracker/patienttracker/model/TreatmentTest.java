package com.tracker.patienttracker.model;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TreatmentTest {

	private Treatment obj=new Treatment();
	
	@Test
	public void testSettreatmentId() throws NoSuchFieldException, IllegalAccessException{
		obj.setTreatmentId(1);
		final Field field =obj.getClass().getDeclaredField("treatmentId");
		field.setAccessible(true);
		assertEquals("Setter Method for treatmentId Passed", field.get(obj),1);
	}
	@Test
	public void testGettreatmentId() throws NoSuchFieldException, IllegalAccessException{
		final Field field =obj.getClass().getDeclaredField("treatmentId");
		field.setAccessible(true);
		field.set(obj, 1);
		assertEquals("Getter Method for treatmentId Passed", obj.getTreatmentId(),1);
	}
	
	@Test
	public void testSettreatmentDescription() throws NoSuchFieldException, IllegalAccessException{
		obj.setTreatmentDescription("Malaria Test");
		final Field field =obj.getClass().getDeclaredField("treatmentDescription");
		field.setAccessible(true);
		assertEquals("Setter Method for treatmentDescription Passed", field.get(obj),"Malaria Test");
	}
	@Test
	public void testGettreatmentDescription() throws NoSuchFieldException, IllegalAccessException{
		final Field field =obj.getClass().getDeclaredField("treatmentDescription");
		field.setAccessible(true);
		field.set(obj, "Malaria Test");
		assertEquals("Getter Method for treatmentDescription Passed", obj.getTreatmentDescription(),"Malaria Test");
	}
	
	@Test
	public void testSettreatmentCost() throws NoSuchFieldException, IllegalAccessException{
		obj.setTreatmentCost(2000.50);
		final Field field =obj.getClass().getDeclaredField("treatmentCost");
		field.setAccessible(true);
		assertEquals("Setter Method for treatmentCost Passed", field.get(obj),2000.50);
	}
	@Test
	public void testGettreatmentCost() throws NoSuchFieldException, IllegalAccessException{
		final Field field =obj.getClass().getDeclaredField("treatmentCost");
		field.setAccessible(true);
		field.set(obj, 2000.50);
		assertEquals("Getter Method for treatmentCost Passed", obj.getTreatmentCost(),2000.50,0.0);
	}
	
	@Test
	public void testSetdietExcerciseDescription() throws NoSuchFieldException, IllegalAccessException{
		obj.setDietExcerciseDescription("Drink Water");
		final Field field =obj.getClass().getDeclaredField("dietExcerciseDescription");
		field.setAccessible(true);
		assertEquals("Setter Method for treatmentDescription Passed", field.get(obj),"Drink Water");
	}
	@Test
	public void testGetdietExcerciseDescription() throws NoSuchFieldException, IllegalAccessException{
		final Field field =obj.getClass().getDeclaredField("dietExcerciseDescription");
		field.setAccessible(true);
		field.set(obj, "Drink Water");
		assertEquals("Getter Method for dietExcerciseDescription Passed", obj.getDietExcerciseDescription(),
				"Drink Water");
	}

}
