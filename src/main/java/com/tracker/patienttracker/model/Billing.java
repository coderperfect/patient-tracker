package com.tracker.patienttracker.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
private int patientId;
private int prescriptionId;
private double amount;
private LocalDateTime timestamp;
private LocalDateTime dueDate;
private boolean paid;
private int userId;
}
