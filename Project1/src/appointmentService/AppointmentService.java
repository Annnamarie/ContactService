package appointmentService;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	 private final Map<String, Appointment> appointments = new HashMap<>();
	 
	 public boolean addAppointment(Appointment appointment) {
		 //check is the appointmentId already exists
		 if (appointments.containsKey(appointment.getAppointmentId())) {
			 return false;
		 }
		 //add appointment to the Map
		 appointments.put(appointment.getAppointmentId(), appointment);
		 return true;
	 }
	 public boolean deleteAppointment(String appointmentId) {
		 //check if appointmentId exists in the Map
		 if (appointments.containsKey(appointmentId)) {
			 appointments.remove(appointmentId);
			 return true;
		 }
		 return false;
	 }
	 
	 public Appointment getAppointment(String appointmentId) {
		 return appointments.get(appointmentId);
	 }
}
