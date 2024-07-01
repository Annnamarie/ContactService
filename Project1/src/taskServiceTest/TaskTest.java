package taskServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("0123456789", "Clean Room", "organize clothes and make bed");
		assertTrue(task.getTaskID().equals("0123456789"));
		assertTrue(task.getName().equals("Clean Room"));
		assertTrue(task.getDescription().equals("organize clothes and make bed"));
	}
	
	@Test
	void testTaskIDNull() {
		//null taskID
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task(null, "Clean Room", "organize clothes and make bed");
		});
	}
	@Test
	void testTaskIDTooLong() {
		
		//too longTaskID
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("01234567890", "Clean Room", "organize clothes and make bed");
		});
	}
	@Test
	void testNameNull() {
		
		//null name
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("0123456789", null, "organize clothes and make bed");
		});
	}
	@Test
	void testNameTooLong() {
		
		//too long name
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("0123456789", "This name is way toooooo long", "organize clothes and make bed");
		});
	}
	@Test
	void testDescriptionNull() {
		
		//null description
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("0123456789", "Clean Room", null);
		});
	}
	@Test
	void testDescriptionTooLong() {
		
		//too long description
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("0123456789", "Clean Room", "Too long description - make the bed, organize clothes, organize school supplies");
		});
	}
	

}
