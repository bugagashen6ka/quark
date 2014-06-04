package edu.quark.model;

import edu.quark.model.Appointment;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConferenceAppointment
 * 
 */
@Entity
public class ConferenceAppointment extends Appointment implements Serializable {

	private static final long serialVersionUID = 1L;

	public ConferenceAppointment() {
		super();
	}

}
