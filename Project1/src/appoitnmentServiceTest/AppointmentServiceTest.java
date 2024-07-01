package appoitnmentServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;
import appointmentService.AppointmentService;


class AppointmentServiceTest {
    private AppointmentService appointmentService;
    
    @BeforeEach
    public void setUp() {
    	appointmentService = new AppointmentService();
    }
	@Test
	public void addAppointmentTest() {
		//future date
		Date futureDate = new Date(System.currentTimeMillis() + 10000);
		//appointment with valid info
		Appointment appointment = new Appointment("0123456789", futureDate,"This is a description");
		//check is the appointment is added correctly
		assertTrue(appointmentService.addAppointment(appointment));
		//check that the appointment can be retrieved by appointment id
		assertNotNull(appointmentService.getAppointment("0123456789"));
	}
	
	
	@Test
	public void duplicateAddDuplicateTest() {
		 // future date for the appointment
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        // two appointments with the same ID
        Appointment appointment1 = new Appointment("1234567890", futureDate, "This is a description");
        Appointment appointment2 = new Appointment("1234567890", futureDate, "This is another Description");
        // Verify that the first appointment is added successfully
        assertTrue(appointmentService.addAppointment(appointment1));
        // Verify that adding the second appointment with the same ID fails
        assertFalse(appointmentService.addAppointment(appointment2));
    }
	@Test
    public void deleteAppointmentTest() {
        //future date for the appointment
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        //appointment with valid data
        Appointment appointment = new Appointment("1234567890", futureDate, "Description");
        // Add the appointment to the service
        appointmentService.addAppointment(appointment);
        // Verify that the appointment is deleted successfully
        assertTrue(appointmentService.deleteAppointment("1234567890"));
        // Verify that the appointment cannot be retrieved after deletion
        assertNull(appointmentService.getAppointment("1234567890"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        // Verify that attempting to delete a non-existent appointment returns false
        assertFalse(appointmentService.deleteAppointment("nonexistent"));
    }


}
