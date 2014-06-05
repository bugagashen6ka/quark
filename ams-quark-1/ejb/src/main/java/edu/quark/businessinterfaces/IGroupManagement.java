package edu.quark.businessinterfaces;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.GroupDetails;
import edu.quark.datatypes.GroupType;
import edu.quark.model.Researcher;

public interface IGroupManagement {
	/** @return group id's */
	List<BigInteger> getGroupIds(BigInteger researcherId);

	GroupDetails getGroupDetails(BigInteger groupId);

	List<GroupDetails> getGroupDetails(List<BigInteger> groupIds);

	void leaveGroup(BigInteger researcherId, BigInteger groupId);

	boolean joinGroup(BigInteger researcherId, BigInteger groupId,
			String password);

	BigInteger createGroup(Researcher creator, String name, GroupType type, String password);

	List<BigInteger> getMemberIds(BigInteger groupId);

	boolean checkPassword(BigInteger groupId, String password);
}
