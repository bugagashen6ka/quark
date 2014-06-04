package edu.quark.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	public List<Group> findAll() {
        TypedQuery<Group> query = em.createNamedQuery(
                "Group.findAll", Group.class);
        List<Group> results = query.getResultList();
        return results;
    }

}
