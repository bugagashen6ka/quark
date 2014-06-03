package edu.quark.dao;

import java.math.BigInteger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.quark.model.Researcher;

/**
 * Here is going to be the code for persistence. This is the layer of
 * indirection between business code and database.
 */
@Stateless
@LocalBean
public class ResearcherDAO implements GenericDAO<Researcher, BigInteger> {

	@PersistenceContext(unitName = "amsEJB")
	EntityManager em;

	@Override
	public BigInteger create(Researcher newInstance) {
		em.persist(newInstance);
		return newInstance.getRid();
	}

	@Override
	public Researcher read(BigInteger id) {
		Researcher researcher = em.find(Researcher.class, id);
		return researcher;
	}

	@Override
	public void update(Researcher transientObject) {
		em.merge(transientObject);
	}

}
