package domain;

public class LessonTime {
	private String id;
	private String time;
	
	public LessonTime() {
		this.id = null;
		this.time = null;
	}
	
	public LessonTime(String id, String time) {
		this.id = id;
		this.time = time;
	}
	public String getId() {	//function to return id
		return id;
	}
	public String getTime() {	//function to return time
		return time;
	}
}
