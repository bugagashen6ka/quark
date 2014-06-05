package edu.quark.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.ManyToMany;

import edu.quark.managedbeans.GroupView;
import edu.quark.model.Group;

@ManagedBean
@ViewScoped
public class GroupConverter implements Converter {

	@ManagedProperty(value = "#{groupView}")
	private GroupView groupView;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if ((value != null) && !value.equals("")
				&& !value.equalsIgnoreCase("Select One")) {
			Group group = new Group();
			group.setName(value);
			for (Group g : groupView.getGroups()) {
				if (g.getName().equalsIgnoreCase(group.getName())) {
					return g;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof Group) {
			return ((Group) value).getName();
		}
		return null;
	}

	public GroupView getGroupView() {
		return groupView;
	}

	public void setGroupView(GroupView groupView) {
		this.groupView = groupView;
	}

}
