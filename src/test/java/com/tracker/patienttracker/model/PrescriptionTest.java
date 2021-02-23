package com.tracker.patienttracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	public void testGetPrescriptionId(){
		prescription.setPrescriptionId(1);
		
		assertEquals(1, prescription.getPrescriptionId());
	}
	
	@Test
	@Order(2)
	public void testSetPrescriptionId(){
		prescription.setPrescriptionId(1);
		
		assertEquals(1, prescription.getPrescriptionId());
	}
	
	@Test
	@Order(3)
	public void testGetMedicinenId(){
		prescription.setMedicineId(1);
		
		assertEquals(1, prescription.getMedicineId());
	}
	
	@Test
	@Order(4)
	public void testSetMedicineId(){
		prescription.setMedicineId(1);
		
		assertEquals(1, prescription.getMedicineId());
	}
	
	@Test
	@Order(5)
	public void testGetQuantity(){
		prescription.setQuantity(1);
		
		assertEquals(1, prescription.getQuantity());
	}
	
	@Test
	@Order(6)
	public void testSetQuantity(){
		prescription.setQuantity(1);
		
		assertEquals(1, prescription.getQuantity());
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
		String expectedString = "Prescription(prescriptionId=1, medicineId=1, quantity=1, prescriptionCost=1.0, paid=true, billed=true)";
		assertEquals(expectedString, prescription.toString());
	}
}
