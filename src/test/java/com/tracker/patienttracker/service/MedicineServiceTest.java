package com.tracker.patienttracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.tracker.patienttracker.exception.MedicineNotFoundException;
import com.tracker.patienttracker.model.Medicine;
import com.tracker.patienttracker.repository.MedicineRepository;

@SpringBootTest
public class MedicineServiceTest {
	
	@InjectMocks
	private MedicineService medicineService;
	
	@Mock
	private MedicineRepository medicineRepository;
	
	@Test
	public void getMedicineFromMedicineNameTest() throws Exception {
		Medicine medicine = new Medicine();
		medicine.setMedicineId(3);
		medicine.setMedicineName("Combiflame");
		medicine.setMedicineCost(84.2);
		when(medicineRepository.findByMedicineName("Combiflame")).thenReturn(medicine);
		assertEquals(medicineService.getMedicineFromMedicineName("Combiflame"), medicine);
	}
	
	@Test
	public void getMedicineFromMedicineNameNegativeTest() throws Exception {
		when(medicineRepository.findByMedicineName("Combiflam")).thenReturn(null);
		assertThrows(MedicineNotFoundException.class,() -> medicineService.getMedicineFromMedicineName("Combiflam"));
	}

}
