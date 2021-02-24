package com.tracker.patienttracker.model;

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
private String testResult;
private int doctorId;
private boolean requested;
private boolean paid;
}
