package edu.quark.businesslogic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.businessinterfaces.IGroupManagement;
import edu.quark.dao.GroupDAO;
import edu.quark.dao.ResearcherDAO;
import edu.quark.datatypes.GroupDetails;
import edu.quark.datatypes.GroupType;
import edu.quark.model.Appointment;
import edu.quark.model.Group;
import edu.quark.model.ProjectGroup;
import edu.quark.model.ResearchGroup;
import edu.quark.model.Researcher;

@Stateless
@LocalBean
public class GroupManager implements IGroupManagement {
	@EJB
	GroupDAO groupDAO;
	@EJB
	ResearcherDAO researcherDAO;

	public GroupManager() {
	}

	@Override
	public List<GroupDetails> getGroupDetails(Researcher researcher) {
		List<GroupDetails> retval = new ArrayList<GroupDetails>();
		List<Group> gs = groupDAO.findAll();
		for (Group g : gs) {
			for (Researcher r : g.getMembers()) {
				if(r.getRid()==researcher.getRid()) {
					retval.add(new GroupDetails(g));
				}
			}
		}
		return retval;
	}

	@Override
	public GroupDetails getGroupDetails(BigInteger groupId) {
		List<Group> gs = groupDAO.findAll();
		for (Group g : gs) {
			if (g.getGid().equals(groupId)) {
				return new GroupDetails(g);
			}
		}
		return null;
	}

	@Override
	public List<GroupDetails> getGroupDetails(List<BigInteger> groupIds) {
		List<GroupDetails> retval = new ArrayList<GroupDetails>();
		for (BigInteger gid : groupIds) {
			GroupDetails gd = this.getGroupDetails(gid);
			if (gd != null) {
				retval.add(gd);
			}
		}
		return retval;
	}

	@Override
	public void leaveGroup(BigInteger researcherId, BigInteger groupId) {
		try {
			Group g = groupDAO.read(groupId);
			Set<Researcher> rs = g.getMembers();
			for (Researcher r : rs) {
				if (r.getRid().equals(researcherId))
					rs.remove(r);
			}
			groupDAO.update(g);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public boolean joinGroup(Researcher researcher, BigInteger groupId,
			String password) {
		try {
			if (researcher == null)
				return false;
			Group g = groupDAO.read(groupId);

			if (g.getClass() == ResearchGroup.class) {
				List<GroupDetails> gds = this.getGroupDetails(researcher);
				for (GroupDetails gd : gds) {
					if (gd.getType() == GroupType.RESEARCH_GROUP) {
						return false; // already member of research group
					}
				}
			}

			if (!g.getPassword().equals(password)) {
				return false;
			}

			g.getMembers().add(researcher);
			groupDAO.update(g);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public BigInteger createGroup(Researcher creator, String name,
			GroupType type, String password) {
		if (password.length() < 6) {
			return null;
		}
		if (!this.isNameUnique(name))
			return null;
		if(type==GroupType.RESEARCH_GROUP) {
			List<GroupDetails> gds = this.getGroupDetails(creator);
			for (GroupDetails gd : gds) {
				if (gd.getType() == GroupType.RESEARCH_GROUP) {
					return null; // already member of research group
				}
			}
		}

		Group g = null;
		try {
			if (type == GroupType.PROJECT_GROUP) {
				g = new ProjectGroup();
			} else {
				g = new ResearchGroup();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (g == null)
			return null;

		g.setAppointments(new HashSet<Appointment>());
		g.setMembers(new HashSet<Researcher>());
		g.setCreator(creator);
		Set<Researcher> members = new HashSet<Researcher>();
		members.add(creator);

		g.setAppointments(new HashSet<Appointment>());
		g.setMembers(members);

		g.setName(name);
		g.setPassword(password);
		groupDAO.create(g);
		return g.getGid();
	}

	@Override
	public List<BigInteger> getMemberIds(BigInteger groupId) {
		GroupDetails gd = this.getGroupDetails(groupId);
		if (gd != null) {
			return new ArrayList<BigInteger>(gd.getMembers());
		}
		return null;
	}

	@Override
	public boolean checkPassword(BigInteger groupId, String password) {
		Group g = groupDAO.read(groupId);
		if (g != null) {
			return password.equals(g.getPassword());
		}
		return false;
	}

	public boolean isNameUnique(String name) {
		List<Group> gs = groupDAO.findAll();
		for (Group g : gs) {
			if (g.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

}
