package domain;
import java.util.ArrayList;

public class Course {
	private String number = null;
	private String name = null;
	private int maxNumbOfStudents;

	private ArrayList<Teacher> teachers;
	
	public Course() {
		this.number = null;	
		this.name = null;
		this.teachers = null;
		this.maxNumbOfStudents = -1;
	}
	
	public Course(String number, String name, ArrayList<Teacher> teachers, int maxNumbOfStudents) {
		this.number = number;	
		this.name = name;
		this.teachers = teachers;
		this.maxNumbOfStudents = maxNumbOfStudents;
	}
	

	public String getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}
	public int getMaxNumbOfStudents() {
		return maxNumbOfStudents;
	}
	public String toString() {
		return name;
	}
}
