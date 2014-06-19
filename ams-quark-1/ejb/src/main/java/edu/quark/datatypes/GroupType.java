package edu.quark.datatypes;

public enum GroupType {
	PROJECT_GROUP,
	RESEARCH_GROUP;
	public String toString() {
		if (this==PROJECT_GROUP) return "Project group";
		else if (this==RESEARCH_GROUP) return "Research group";
		else return "";
	};
}
