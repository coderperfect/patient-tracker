package com.tracker.patienttracker.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="billing")
public class Billing {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int billingId;

@NotNull(message="Please provide Patient Id")
@Min(value = 1, message = "The value must be positive")
private int patientId;

@NotNull(message="Please provide Prescription Id")
@Min(value = 1, message = "The value must be positive")
private int prescriptionId;

@Min(value = 0, message = "The value must not be negative")
private double amount;

@PastOrPresent
@NotNull(message="Please provide TimeStamp")
private LocalDateTime timestamp;

@PastOrPresent
@NotNull(message="Please provide Due Date")
private LocalDateTime dueDate;

//@NotNull(message="Paid Column can not be null")
private boolean paid;

@NotNull(message="UserId can not be null")
@Min(value = 1, message = "The value must be positive")
private int userId;
private Consultation consultation;
}
