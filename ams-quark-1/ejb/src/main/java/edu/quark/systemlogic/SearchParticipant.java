package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ISearchParticipant;

@Stateless
@LocalBean
public class SearchParticipant implements ISearchParticipant {

	@Override
	public List<BigInteger> getParticipantIds(BigInteger appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
