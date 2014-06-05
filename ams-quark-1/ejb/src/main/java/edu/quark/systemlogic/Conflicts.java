package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.TimeInfo;
import edu.quark.systeminterfaces.IConflicts;

public class Conflicts implements IConflicts {

	@Override
	public List<BigInteger> getAppointmentsWithConflicts(
			BigInteger researcherId, TimeInfo time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BigInteger> getResearchersWithConflicts(
			BigInteger appointmentId, TimeInfo time) {
		// TODO Auto-generated method stub
		return null;
	}

}
