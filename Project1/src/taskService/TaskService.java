package taskService;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
	private final Map<String, Task> tasks;
	
	public TaskService() {
		this.tasks = new HashMap<>();
	}
	
	//Add a new task
	public void addTask(String taskID, String name, String description) {
		//if this task ID already exists
		if(tasks.containsKey(taskID)) {
			throw new IllegalArgumentException("Task ID already exists");
		}
		Task task = new Task(taskID, name, description);
		tasks.put(taskID, task);
	}
	
	//Delete a task by taskID
	public void deleteTask(String taskID) {
		if(!tasks.containsKey(taskID)) {
			throw new IllegalArgumentException("Task ID not found");
		}
		tasks.remove(taskID);
	}
	
	//Update task name by taskID
	public void updateTask(String taskID, String newName) {
		Task task = tasks.get(taskID);
		if (task == null) {
			throw new IllegalArgumentException("Task ID not found");
		}
		task.setName(newName);
	}
	
	//Update task description by task ID
	public void updateTaskDescription(String taskID, String newDescription) {
		Task task = tasks.get(taskID);
		if (task == null) {
			throw new IllegalArgumentException("Task ID not found");
		}
		task.setDescription(newDescription);
	}
	
	//Get task by taskID
	public Task getTask(String taskID) {
		return tasks.get(taskID);
	}
}
