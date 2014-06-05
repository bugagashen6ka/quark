package edu.quark.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	public List<Appointment> findAll() {
        TypedQuery<Appointment> query = em.createNamedQuery(
                "Appointment.findAll", Appointment.class);
        List<Appointment> results = query.getResultList();
        return results;
    }

	@Override
	public void update(Appointment transientObject) {
		em.merge(transientObject);
	}

	@Override
	public void delete(Appointment persistentObj) {
		em.remove(persistentObj);
	}

}
