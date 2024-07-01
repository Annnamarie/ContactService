package appointmentService;

import java.util.Date;

public class Appointment {
	
	private final String appointmentId;
	private final Date appointmentDate;
	private final String appointmentDescription;

	public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
		//appointmentID cannot be null, can't be longer than 10 char
		if (appointmentId == null || appointmentId.length() > 10 ) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.appointmentId = appointmentId;
		
		//appointmentDate can't be null, can't be in the past
		if(appointmentDate == null || appointmentDate.before( new Date())) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		this.appointmentDate = appointmentDate;
		
		//description can't be null, can't be longer than 50 char
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.appointmentDescription = appointmentDescription;
	}
	
	//getters
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
}
