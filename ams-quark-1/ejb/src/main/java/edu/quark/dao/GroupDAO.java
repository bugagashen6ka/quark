package edu.quark.dao;

import java.math.BigInteger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.quark.model.Group;

/**
 * Session Bean implementation class GroupDAO
 */
@Stateless
@LocalBean
public class GroupDAO implements GenericDAO<Group, BigInteger> {

	@PersistenceContext(unitName = "amsEJB")
	EntityManager em;

	@Override
	public BigInteger create(Group newInstance) {
		System.out.println("create dao group " + newInstance.getName() + " | " + newInstance.getPassword());
		em.persist(newInstance);
		return newInstance.getGid();
	}

	@Override
	public Group read(BigInteger id) {
		Group group = em.find(Group.class, id);
		return group;
	}

	@Override
	public void update(Group transientObject) {
		em.merge(transientObject);
	}

}
