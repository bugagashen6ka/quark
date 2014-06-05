package edu.quark.businesslogic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

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

@ApplicationScoped
public class GroupManager implements IGroupManagement {
	@EJB
	GroupDAO groupDAO;
	@EJB
	ResearcherDAO researcherDAO;
	public GroupManager() {
	}

	@Override
	public List<BigInteger> getGroupIds(BigInteger researchId) {
		List<BigInteger> retval = new ArrayList<BigInteger>();
		List<Group> gs = groupDAO.findAll();
		for (Group g : gs) {
			for (Researcher r : g.getMembers()) {
				if(r.getRid()==researchId) {
					retval.add(g.getGid());					
				}
			}
		}
		return retval;
	}

	@Override
	public GroupDetails getGroupDetails(BigInteger groupId) {
		List<Group> gs = groupDAO.findAll();
		for (Group g : gs) {
			if(g.getGid()==groupId) {
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
			if(r.getRid()==researcherId)
				rs.remove(r);
			}
		groupDAO.update(g);
		} catch (Exception e){
			e.printStackTrace();
			return;
		}
	}

	@Override
	public boolean joinGroup(BigInteger researcherId, BigInteger groupId,
			String password) {
		try {
			Group g = groupDAO.read(groupId);
			if(g.getPassword() != password) {
				return false;
			}
			Researcher r=researcherDAO.read(researcherId);
			if(r==null) return false; 
			g.getMembers().add(r);
			groupDAO.update(g);
			return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public boolean createGroup(String name, GroupType type, String password) {
		Group g = null;
		try {
			if (type == GroupType.PROJECT_GROUP) {
				g = ProjectGroup.class.newInstance();
			} else {
				g = ResearchGroup.class.newInstance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (g == null)
			return false;
		
		g.setAppointments(new HashSet<Appointment>());
		g.setMembers(new HashSet<Researcher>());
		// TODO: Add creator via DAO and ManagedBean and passing some crazy stuff into session state
		g.setCreator(null);
		g.setName(name);
		g.setPassword(password);
		groupDAO.create(g);
		return true;
	}

	@Override
	public List<BigInteger> getMemberIds(BigInteger groupId) {
		GroupDetails gd = this.getGroupDetails(groupId);
		if(gd != null) {
			return new ArrayList<BigInteger>(gd.getMembers());
		}
		return null;
	}

	@Override
	public boolean checkPassword(BigInteger groupId, String password) {
		Group g = groupDAO.read(groupId);
		if (g != null) {
			return password==g.getPassword();
		}
		return false;
	}

}
