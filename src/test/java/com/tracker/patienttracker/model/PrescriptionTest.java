package com.tracker.patienttracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PrescriptionTest {
	@Autowired
	Prescription prescription;
	
	@Test
	@Order(1)
	public void testGetPrescriptionId() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		final Prescription prescription = new Prescription();
		final Field field = prescription.getClass().getDeclaredField("prescriptionId");
		field.setAccessible(true);
		field.set(prescription, 1);
		
		assertEquals(1, prescription.getPrescriptionId());
	}
	
	@Test
	@Order(2)
	public void testSetPrescriptionId() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		final Prescription prescription = new Prescription();
		
		prescription.setPrescriptionId(1);
		
		final Field field = prescription.getClass().getDeclaredField("prescriptionId");
		field.setAccessible(true);
		
		assertEquals(1, field.get(prescription));
	}
	
	@Test
	@Order(3)
	public void testGetMedicinenId() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		final Prescription prescription = new Prescription();
		final Field field = prescription.getClass().getDeclaredField("medicineId");
		field.setAccessible(true);
		field.set(prescription, 1);
		
		assertEquals(1, prescription.getMedicineId());
	}
	
	@Test
	@Order(4)
	public void testSetMedicineId() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		final Prescription prescription = new Prescription();
		
		prescription.setMedicineId(1);
		
		final Field field = prescription.getClass().getDeclaredField("medicineId");
		field.setAccessible(true);
		
		assertEquals(1, field.get(prescription));
	}
	
	@Test
	@Order(5)
	public void testGetQuantity() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		final Prescription prescription = new Prescription();
		final Field field = prescription.getClass().getDeclaredField("quantity");
		field.setAccessible(true);
		field.set(prescription, 1);
		
		assertEquals(1, prescription.getQuantity());
	}
	
	@Test
	@Order(6)
	public void testSetQuantity() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		final Prescription prescription = new Prescription();
		
		prescription.setQuantity(1);
		
		final Field field = prescription.getClass().getDeclaredField("quantity");
		field.setAccessible(true);
		
		assertEquals(1, field.get(prescription));
	}
	
	@Test
	@Order(7)
	public void testGetPrescriptionCost(){
		prescription.setPrescriptionCost(1);
		
		assertEquals(1, prescription.getPrescriptionCost());
	}
	
	@Test
	@Order(8)
	public void testSetPrescriptionCost(){
		prescription.setPrescriptionCost(1);
		
		assertEquals(1, prescription.getPrescriptionCost());
	}
	
	@Test
	@Order(9)
	public void testIsPaid(){
		prescription.setPaid(true);
		
		assertEquals(true, prescription.isPaid());
	}
	
	@Test
	@Order(10)
	public void testSetPaid(){
		prescription.setPaid(true);
		
		assertEquals(true, prescription.isPaid());
	}
	
	@Test
	@Order(11)
	public void testIsBilled(){
		prescription.setBilled(true);
		
		assertEquals(true, prescription.isBilled());
	}
	
	@Test
	@Order(12)
	public void testSetBilled(){
		prescription.setBilled(true);
		
		assertEquals(true, prescription.isBilled());
	}
	
	@Test
	@Order(13)
	public void testToString(){
		String expectedString = "Prescription(prescriptionId=0, medicineId=0, quantity=0, prescriptionCost=1.00, paid=true, billed=true)";
		assertEquals(expectedString, prescription.toString());
	}
	
	@Test
	@Order(14)
	public void testAllArgsConstructor(){
		Prescription prescription = new Prescription(1, 1, 1, 100.00, true, true);
		
		String expectedString = "Prescription(prescriptionId=1, medicineId=1, quantity=1, prescriptionCost=100.00, paid=true, billed=true)";
		assertEquals(expectedString, prescription.toString());
	}
}
