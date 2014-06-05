package edu.quark.systeminterfaces;

import java.util.List;

import edu.quark.datatypes.GroupDetails;
import edu.quark.model.Researcher;

public interface ISearchGroup {
	/**
	 * @return group id's */
	List<GroupDetails> getGroupDetails(Researcher researcher);
}
