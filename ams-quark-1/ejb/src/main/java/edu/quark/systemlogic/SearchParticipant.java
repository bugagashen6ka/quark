package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ISearchParticipant;

@Local
@ApplicationScoped
public class SearchParticipant implements ISearchParticipant {

	@Override
	public List<BigInteger> getParticipantIds(BigInteger appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
