package edu.quark.managedbeans;


import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import edu.quark.businesslogic.AppointmentManager;
import edu.quark.businesslogic.ResearcherManager;
import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.AppointmentType;
import edu.quark.datatypes.TimeInfo;
import edu.quark.systemlogic.CreateAppointment;
import edu.quark.systemlogic.DeleteAppointment;

import java.util.ArrayList;
import java.util.List;


@ManagedBean
@ViewScoped
public class ScheduleView {

	@EJB
	private CreateAppointment createAppointment;
	@EJB
	private DeleteAppointment deleteAppointment; 
	@EJB
	private ResearcherManager researcherManager;
	@EJB
	private AppointmentManager appointmentManager;
	
	@ManagedProperty(value="#{credentials}")
	private Credentials credentials;

	private ScheduleModel eventModel;
	private ScheduleModel lazyEventModel;
    private AppointmentDetails appointmentDetails;
    
	private AppointmentType type;
    private Date start;
    private Date end;
    private String location;
	private String description;
	private Set<String> participants;
	private List<String> availableParticipants;

	private ScheduleEvent event = new DefaultScheduleEvent();

	@PostConstruct
	public void init() {
		
		lazyEventModel = new LazyScheduleModel() {
			private static final long serialVersionUID = -1508233823680543048L;

			@Override
			public void loadEvents(Date start, Date end) {
				
			}
		};
		eventModel = new DefaultScheduleModel();
		eventModel.clear();
		availableParticipants = new ArrayList<String>();
		availableParticipants.add("Tom");
		availableParticipants.add("John");
		availableParticipants.add("Sam");
        availableParticipants.add("sdfgdfg");
        if(credentials.getResearcher()!=null) {
        	Date t1=new Date();
            Date t2=new Date();
            Date t3=new Date();
            Date t4=new Date();
            t1.setHours(18);
            t2.setHours(19);
            t3.setHours(11);
            t4.setHours(23);
            appointmentManager.createAppointment(
            		credentials.getResearcher().getRid(),
            		AppointmentType.CONFERENCE_APPOINTMENT, 
            		null, "3076", "JJJ", new TimeInfo(t1,t2));
            appointmentManager.createAppointment(
            		credentials.getResearcher().getRid(),
            		AppointmentType.GENERIC_APPOINTMENT, 
            		null, "3076", "XXX", new TimeInfo(t3,t4));
            this.AppointmentDetailsToView();
        }
        
	}
    

	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY,
				calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar.getTime();
	}

	private void AppointmentDetailsToView() {
		eventModel.clear();
		List<AppointmentDetails> as = researcherManager.getAppointmentDetails(
				credentials.getResearcher().getRid(), 
				new TimeInfo(new Date(1,0,0), new Date(9999,12,12)));
		System.out.println("Length "+as.size());
		for (AppointmentDetails a : as) {
			AppointmentType t = a.getType();
			TimeInfo ti = a.getTimeInterval();
			eventModel.addEvent(new DefaultScheduleEvent(a.getDescription()+" at "+a.getLocation(),
					ti.getStart(),ti.getEnd(), "evtype"+t.ordinal()));
		}
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


	public Set<String> getParticipants() {
		return participants;
	}


	public void setParticipants(Set<String> participants) {
		this.participants = participants;
	}

	
	public ScheduleModel getEventModel() {
		return eventModel;
	}
	
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public CreateAppointment getCreateAppointment() {
		return createAppointment;
	}

	public void setCreateAppointment(CreateAppointment createAppointment) {
		this.createAppointment = createAppointment;
	}

	public DeleteAppointment getDeleteAppointment() {
		return deleteAppointment;
	}

	public void setDeleteAppointment(DeleteAppointment deleteAppointment) {
		this.deleteAppointment = deleteAppointment;
	}


	public void setLazyEventModel(ScheduleModel lazyEventModel) {
		this.lazyEventModel = lazyEventModel;
	}

	public List<String> getAvailableParticipants() {
		return availableParticipants;
	}

	public void setAvailableParticipants(List<String> availableParticipants) {
		this.availableParticipants = availableParticipants;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}


	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}