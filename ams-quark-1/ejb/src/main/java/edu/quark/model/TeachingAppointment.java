package edu.quark.model;

import edu.quark.model.Appointment;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TeachingAppointment
 *
 */
@Entity
public class TeachingAppointment extends Appointment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public TeachingAppointment() {
		super();
	}
   
}
