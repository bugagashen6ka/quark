package edu.quark.dao;

import java.math.BigInteger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.quark.model.Appointment;

/**
 * Session Bean implementation class AppointmentDAO
 */
@Stateless
@LocalBean
public class AppointmentDAO implements GenericDAO<Appointment, BigInteger> {

	@PersistenceContext(unitName = "amsEJB")
	EntityManager em;

	@Override
	public BigInteger create(Appointment newInstance) {
		em.persist(newInstance);
		return newInstance.getAid();
	}

	@Override
	public Appointment read(BigInteger id) {
		Appointment appointment = em.find(Appointment.class, id);
		return appointment;
	}

	@Override
	public void update(Appointment transientObject) {
		em.merge(transientObject);
	}

}
