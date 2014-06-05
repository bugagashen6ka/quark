package edu.quark.managedbeans;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.ScheduleModel;

import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.AppointmentType;
import edu.quark.systemlogic.CreateAppointment;
import edu.quark.systemlogic.DeleteAppointment;


@ManagedBean
@ViewScoped
public class ScheduleView {
	
	@EJB
	private CreateAppointment createAppointment;
	@EJB
	private DeleteAppointment deleteAppointment; 
	
	private ScheduleModel eventModel;
 
    private AppointmentDetails appointmentDetails;
    
	private AppointmentType type;
    private Date start;
    private Date end;
    private String location;
	private String description;
	private Set<BigInteger> participants;
    
    @PostConstruct
    public void init() {

	}
    

	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY,
				calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar.getTime();
	}


	private Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}

	public AppointmentDetails getAppointmentDetails() {
		return appointmentDetails;
	}

	public void setAppointmentDetails(AppointmentDetails appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
	}

	public void addEvent(ActionEvent actionEvent) {
		/*if (appointmentDetails.getId() == null)
			eventModel.addEvent(appointmentDetails);
		else
			eventModel.updateEvent(appointmentDetails);

		appointmentDetails = new DefaultScheduleEvent();*/
	}

	public void onEventSelect(SelectEvent selectEvent) {
		/*appointmentDetails = (ScheduleEvent) selectEvent.getObject()*/;
	}

	public void onDateSelect(SelectEvent selectEvent) {
		/*appointmentDetails = new AppointmentDetails("", (Date) selectEvent.getObject(),
				(Date) selectEvent.getObject());*/
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		/*FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event moved", "Day delta:" + event.getDayDelta()
						+ ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);*/
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		/*FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event resized", "Day delta:" + event.getDayDelta()
						+ ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);*/
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void createAppointment(){
		//createAppointment.createAppointment(rid, type, groupId, location, description);
	}
	
	public void deleteAppiontment(){
		//deleteAppointment.deleteAppointment(researcherId, appointmentId);
	}


	public AppointmentType getType() {
		return type;
	}


	public void setType(AppointmentType type) {
		this.type = type;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}


	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<BigInteger> getParticipants() {
		return participants;
	}


	public void setParticipants(Set<BigInteger> participants) {
		this.participants = participants;
	}
	
	public ScheduleModel getEventModel() {
		return eventModel;
	}
	
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}
	
}