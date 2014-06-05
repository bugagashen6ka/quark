package edu.quark.systeminterfaces;

import java.math.BigInteger;
import java.util.List;

public interface ISearchParticipant {
	/** @return researcher id's */
	List<BigInteger> getParticipantIds(BigInteger appointmentId);
}
