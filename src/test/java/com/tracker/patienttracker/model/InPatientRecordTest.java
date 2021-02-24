package com.tracker.patienttracker.model;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InPatientRecordTest {
	
	@Test
	public void setInPatientRecordTest() throws NoSuchFieldException, IllegalAccessException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		inPatientRecord.setInPatientRecordId(1);
		final Field field = inPatientRecord.getClass().getDeclaredField("inPatientRecordId");
		field.setAccessible(true);
		assertEquals("Setter Pass Test", field.get(inPatientRecord), 1);
	}
	
	@Test
	public void getInPatientRecordTest() throws NoSuchFieldException, IllegalAccessException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		final Field field = inPatientRecord.getClass().getDeclaredField("inPatientRecordId");
        field.setAccessible(true);
        field.set(inPatientRecord, 1);
        assertEquals("Getter Pass Test",inPatientRecord.getInPatientRecordId(), 1);
	}
	
	@Test
	public void setPatientIdTest() throws NoSuchFieldException, IllegalAccessException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		inPatientRecord.setPatientId(1);
		final Field field = inPatientRecord.getClass().getDeclaredField("patientId");
		field.setAccessible(true);
		assertEquals("Setter Pass Test", field.get(inPatientRecord), 1);
	}
	
	@Test
	public void getPatientIdTest() throws NoSuchFieldException, IllegalAccessException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		final Field field = inPatientRecord.getClass().getDeclaredField("patientId");
        field.setAccessible(true);
        field.set(inPatientRecord, 1);
        assertEquals("Getter Pass Test",inPatientRecord.getPatientId(), 1);
	}
	
	@Test
	public void setRoomChargesTest() throws NoSuchFieldException, IllegalAccessException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		inPatientRecord.setRoomCharges(100);
		final Field field = inPatientRecord.getClass().getDeclaredField("roomCharges");
		field.setAccessible(true);
		assertEquals("Setter Pass Test", field.get(inPatientRecord), 100.0);
	}
	
	@Test
	public void getRoomChargesTest() throws NoSuchFieldException, IllegalAccessException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		final Field field = inPatientRecord.getClass().getDeclaredField("roomCharges");
        field.setAccessible(true);
        field.set(inPatientRecord, 100);
        assertEquals("Getter Pass Test",inPatientRecord.getRoomCharges(), 100.0, 0.001);
	}
	
	@Test
	public void setAdmissionDateTest() throws NoSuchFieldException, IllegalAccessException, ParseException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2000");
		inPatientRecord.setAdmissionDate(date1);
		final Field field = inPatientRecord.getClass().getDeclaredField("admissionDate");
		field.setAccessible(true);
		assertEquals("Setter Pass Test", field.get(inPatientRecord), date1);
	}
	
	@Test
	public void getAdmissionDateTest() throws NoSuchFieldException, IllegalAccessException, ParseException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2000");
		final Field field = inPatientRecord.getClass().getDeclaredField("admissionDate");
		field.setAccessible(true);
		field.set(inPatientRecord, date1);
		assertEquals("Getter Pass Test", inPatientRecord.getAdmissionDate(), date1);
	}
	
	@Test
	public void setDischargeDateTest() throws NoSuchFieldException, IllegalAccessException, ParseException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2000");
		inPatientRecord.setDischargeDate(date1);
		final Field field = inPatientRecord.getClass().getDeclaredField("dischargeDate");
		field.setAccessible(true);
		assertEquals("Setter Pass Test", field.get(inPatientRecord), date1);
	}
	
	@Test
	public void getDischargeDateTest() throws NoSuchFieldException, IllegalAccessException, ParseException {
		final InPatientRecord inPatientRecord = new InPatientRecord();
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2000");
		final Field field = inPatientRecord.getClass().getDeclaredField("dischargeDate");
		field.setAccessible(true);
		field.set(inPatientRecord, date1);
		assertEquals("Getter Pass Test", inPatientRecord.getDischargeDate(), date1);
	}

}
