package edu.quark.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import edu.quark.managedbeans.ScheduleView;
import edu.quark.model.Researcher;

@ManagedBean
@ViewScoped
public class ResearcherConverter implements Converter {

	@ManagedProperty(value = "#{scheduleView}")
	private ScheduleView scheduleView;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if ((value != null) && !value.equals("")
				&& !value.equalsIgnoreCase("Select One")) {
			Researcher researcher = new Researcher();
			String[] s = value.split(" ");
			researcher.setTitle(s[0]);
			researcher.setFirstName(s[1]);
			researcher.setLastName(s[2]);
			for (Researcher r : scheduleView.getResearcherDAO().findAll()) {
				if (r.getTitle().equalsIgnoreCase(researcher.getTitle())
						&& r.getFirstName().equalsIgnoreCase(
								researcher.getFirstName())
						&& r.getLastName().equalsIgnoreCase(
								researcher.getLastName())) {
					return r;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof Researcher) {
			return ((Researcher) value).getTitle() + " "
					+ ((Researcher) value).getFirstName() + " "
					+ ((Researcher) value).getLastName();
		}
		return null;
	}

	public ScheduleView getScheduleView() {
		return scheduleView;
	}

	public void setScheduleView(ScheduleView scheduleView) {
		this.scheduleView = scheduleView;
	}

}
