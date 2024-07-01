package taskServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import taskService.Task;
import taskService.TaskService;

class TaskServiceTest {
	
	private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        taskService.addTask("001", "Task 1", "Description 1");
        Task task = taskService.getTask("001");
        assertTrue(task != null);
        assertTrue(task.getTaskID().equals("001"));
        assertTrue(task.getName().equals("Task 1"));
        assertTrue(task.getDescription().equals("Description 1"));

        // Test adding a task with a duplicate ID
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask("001", "Task 2", "Description 2");
        });
    }

    @Test
    void testDeleteTask() {
        taskService.addTask("001", "Task 1", "Description 1");
        taskService.deleteTask("001");
        assertTrue(taskService.getTask("001") == null);

        // Test deleting a non-existing task
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("999");
        });
    }

    @Test
    void testUpdateTaskName() {
        taskService.addTask("001", "Task 1", "Description 1");
        taskService.updateTask("001", "Updated Task 1");
        Task task = taskService.getTask("001");
        assertTrue(task.getName().equals("Updated Task 1"));

        // Test updating a non-existing task
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask("999", "Non-existing Task");
        });
    }

    @Test
    void testUpdateTaskDescription() {
        taskService.addTask("001", "Task 1", "Description 1");
        taskService.updateTaskDescription("001", "Updated Description 1");
        Task task = taskService.getTask("001");
        assertTrue(task.getDescription().equals("Updated Description 1"));

        // Test updating a non-existing task
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("999", "Non-existing Description");
        });
    }

    @Test
    void testUpdateName() {
        Task task = new Task("0123456789", "Clean Room", "organize clothes and make bed");
        task.setName("Clean Kitchen");
        assertTrue(task.getName().equals("Clean Kitchen"));

        // Invalid name update
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is way too long to be valid");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    void testUpdateDescription() {
        Task task = new Task("0123456789", "Clean Room", "organize clothes and make bed");
        task.setDescription("clean dishes and wipe surfaces");
        assertTrue(task.getDescription().equals("clean dishes and wipe surfaces"));

        // Invalid description update
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is way too long to be considered valid - mow lawn, clean dishes, read book, do homework");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
}
