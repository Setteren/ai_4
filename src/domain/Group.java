package domain;
import java.util.ArrayList;

public class Group {
	private String name;
	private ArrayList<Course> courses;

	public Group() {
		this.name = null;
		this.courses = null;
	}
	public Group(String name, ArrayList<Course> courses) {
		this.name = name;
		this.courses = courses;
	}
	public String getName() {	//return name
		return name;
	}
	public ArrayList<Course> getCourses() {		//return course array
		return courses;
	}
}
