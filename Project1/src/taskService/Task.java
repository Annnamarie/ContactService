package taskService;

public class Task {

	private final String taskID;
	private String name;
	private String description;
	
	public Task(String taskID, String name, String description) {
	//task ID - cant be null, cant be longer than 10, cant be updatable
		if (taskID == null || taskID.length() > 10 ) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.taskID = taskID;
		
	//name - cant be null, cant be longer than 20
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
	
	//description can be longer than 50, cant be null
		if (description == null || description.length()> 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.description = description;
	}
	
	//Getter methods
	public String getTaskID() {
		return taskID;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	//Setter methods
	public void setName(String name) {
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
	}
	public void setDescription(String description) {
		if (description == null || description.length()> 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.description = description;
	}
}
