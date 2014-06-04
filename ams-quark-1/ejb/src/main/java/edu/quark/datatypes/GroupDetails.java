package edu.quark.datatypes;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import edu.quark.model.Group;
import edu.quark.model.Researcher;

public final class GroupDetails {
	
	public GroupDetails(BigInteger gId, String name, GroupType type,
			Set<BigInteger> members) {
		super();
		this.gId = gId;
		this.name = name;
		this.type = type;
		this.members = members;
	}
	public GroupDetails(Group g) {
		super();
		this.gId = g.getGid();
		this.name = g.getName();
		//TODO: Add group type handling once we have Group subclasses
		//this.type = g.;
		this.members=new HashSet<BigInteger>();
		for (Researcher r: g.getMembers()) {
			this.members.add(r.getRid());
		}
	}
	
	public BigInteger getgId() {
		return gId;
	}
	public String getName() {
		return name;
	}
	public GroupType getType() {
		return type;
	}
	public Set<BigInteger> getMembers() {
		return members;
	}
	private BigInteger gId;
	private String name;
	private GroupType type;
	private Set<BigInteger> members;
}
