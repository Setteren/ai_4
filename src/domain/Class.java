package domain;

public class Class {	// це певний клас, де викладачі викладають певний курс у певний час
	private int id;
	private Group dept;
	private Course course;
	private Teacher teacher;
	private LessonTime lessonTime;
	private Auditorium auditorium;
	
	public Class() {
		this.id = -1;
		this.dept = null;
		this.course = null;
	}
	
	public Class(int id, Group dept, Course course) {
		this.id = id;
		this.dept = dept;
		this.course = course;
	}
	

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void setLessonTime(LessonTime lessonTime) {
		this.lessonTime = lessonTime;
	}
	public void setRoom(Auditorium auditorium) {
		this.auditorium = auditorium;
	}
	public int getId() {
		return id;
	}
	public Group getDept() {
		return dept;
	}
	public Course getCourse() {
		return course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public LessonTime getLessonTime() {
		return lessonTime;
	}
	public Auditorium getRoom() {
		return auditorium;
	}
	public String toString() {
		return "["+dept.getName()+","+course.getNumber()+","+ auditorium.getNumber()+","+ teacher.getId()+","+ lessonTime.getId() +"]";
	}
}
