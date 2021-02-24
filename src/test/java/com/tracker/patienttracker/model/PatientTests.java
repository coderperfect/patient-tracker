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
public class PatientTests {

	@Test
	public void testSetPatientId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Patient patient = new Patient();
        patient.setPatientId("M.S.Krishna");
        final Field field = patient.getClass().getDeclaredField("patientId");
        field.setAccessible(true);
        assertEquals("Setter passed", field.get(patient), "M.S.Krishna");
        //assertEquals("Setter failed", field.get(patient), "MSKrishna");
	}
	
	@Test
	public void testGetPatientId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Patient patient = new Patient();
        final Field field = patient.getClass().getDeclaredField("patientId");
        field.setAccessible(true);
        field.set(patient, "M.S.Krishna");
        assertEquals("Getter passed",patient.getPatientId(), "M.S.Krishna");
        //assertEquals("Getter failed",patient.getPatientId(), "MSKrishna");
	}
	@Test
	public void testSetBloodGroup() throws NoSuchFieldException, IllegalAccessException  {
		
        final Patient patient = new Patient();
        patient.setBloodGroup("O+");
        final Field field = patient.getClass().getDeclaredField("bloodGroup");
        field.setAccessible(true);
        assertEquals("Setter passed", field.get(patient), "O+");
        //assertEquals("Setter failed", field.get(patient), "O-");
	}
	
	@Test
	public void testGetBloodGroup() throws NoSuchFieldException, IllegalAccessException  {
		
        final Patient patient = new Patient();
        final Field field = patient.getClass().getDeclaredField("bloodGroup");
        field.setAccessible(true);
        field.set(patient, "O+");
        assertEquals("Getter passed",patient.getBloodGroup(), "O+");
        //assertEquals("Getter failed",patient.getBloodGroup(), "O-");
	}
}
