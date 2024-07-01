package appoitnmentServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import appointmentService.Appointment;

class AppointmentTest {

	@Test
	public void appointmentTest() {
		//future date for the appointment
		Date futureDate = new Date(System.currentTimeMillis() + 10000);
		//appointment w/ valid data
		Appointment appointment = new Appointment("0123456789", futureDate, "This is a description");
		
		//verifying appointment fields
		
		//verify appointmentId
		assertEquals("0123456789", appointment.getAppointmentId());
		//verify appointmentDate - cannot be in the past
		assertEquals(futureDate, appointment.getAppointmentDate());
		//verify description
		assertEquals("This is a description", appointment.getAppointmentDescription());
	}
	
	@Test
	public void invalidAppointmentIdNull() {
		//future date for the appointment
		Date futureDate = new Date(System.currentTimeMillis() + 10000);
		
		//validate that exception is thrown when appointmentId is longer than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0123456789999", futureDate, "This is a description");
		});
	}
	@Test
	public void invalidAppointmentIdTooLong() {
		//future date for the appointment
		Date futureDate = new Date(System.currentTimeMillis() + 10000);
		
		
		//validate that exception is thrown when appointmentId is null
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, futureDate, "This is a description");
		});
	}
	
	@Test
	public void invalidAppointmentDatePast() {
		//past date for the appointment
		Date pastDate = new Date(System.currentTimeMillis() - 10000);
		
		//validate that exception is thrown when appointment date is in the past
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0123456789", pastDate, "This is a description");
		});
	}
	@Test
	public void invalidAppointmentDateNull() {
		//past date for the appointment
		Date pastDate = new Date(System.currentTimeMillis() - 10000);
		
		//validate that exception is thrown when appointment date is null
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0123456789", null, "This is a description");
		});
	}
	
	@Test
	public void invalidAppointmentDescriptionTooLong() {
		//future date for the appointment
		Date futureDate = new Date(System.currentTimeMillis() + 10000);
		
		//validate that exception is thrown when appointment description is too long
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0123456789", futureDate, "This is a really really really really reallly long description");
		});
	}
	@Test
	public void invalidAppointmentDescriptionNull() {
		//future date for the appointment
		Date futureDate = new Date(System.currentTimeMillis() + 10000);
		
		//validate that exception is thrown when appointment description is null
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0123456789", futureDate, null);
		});
	}

}
