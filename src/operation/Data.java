package operation;

import domain.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
	private ArrayList<Auditorium> Auditoriums;	//list of Auditoriums available
	private ArrayList<Teacher> teachers;	//list of instructors
	private ArrayList<Course> courses;	//list of courses
	private ArrayList<Group> groups;	//list of groups
	private ArrayList<LessonTime> lessonTimes;	//list of meeting times
	private int numberOfClasses = 10;	//total number of classes from all groups for which the time should be scheduled

	public Data() {
		initialize();
	}

	private Data initialize() {
		Auditorium Auditorium1 = new Auditorium("Auditorium 210", 40);
		Auditorium Auditorium2 = new Auditorium("Auditorium 302", 30);
		Auditorium Auditorium3 = new Auditorium("Auditorium 14", 50);
		Auditoriums = new ArrayList<Auditorium>(Arrays.asList(Auditorium1, Auditorium2, Auditorium3));

		LessonTime lectionTime1 = new LessonTime("LT1", "MON 08:30 - 9:50");
		LessonTime lectionTime2 = new LessonTime("LT2", "MON 10:00 - 11:20");
		LessonTime lectionTime3 = new LessonTime("LT3", "MON 11:40 - 13:00");

		LessonTime lectionTime4 = new LessonTime("LT5", "TUE 08:30 - 9:50");
		LessonTime lectionTime5 = new LessonTime("LT6", "TUE 10:00 - 11:20");
		LessonTime lectionTime6 = new LessonTime("LT7", "TUE 11:40 - 13:00");

		LessonTime lectionTime7 = new LessonTime("LT8", "WED 08:30 - 9:50");
		LessonTime lectionTime8 = new LessonTime("LT9", "WED 10:00 - 11:20");
		LessonTime lectionTime9 = new LessonTime("LT10", "WED 11:40 - 13:00");

		LessonTime lectionTime10 = new LessonTime("LT11", "THU 08:30 - 9:50");
		LessonTime lectionTime11 = new LessonTime("LT12", "THU 10:00 - 11:20");
		LessonTime lectionTime12 = new LessonTime("LT13", "THU 11:40 - 13:00");

		LessonTime lectionTime13 = new LessonTime("LT14", "FRI 08:30 - 9:50");
		LessonTime lectionTime14 = new LessonTime("LT15", "FRI 10:00 - 11:20");
		LessonTime lectionTime15 = new LessonTime("LT16", "FRI 11:40 - 13:00");

		LessonTime practiceTime1 = new LessonTime("PR11", "THU 08:30 - 9:50");
		LessonTime practiceTime2 = new LessonTime("PR12", "THU 10:00 - 11:20");
		LessonTime practiceTime3 = new LessonTime("PR13", "THU 11:40 - 13:00");

		LessonTime practiceTime4 = new LessonTime("PR14", "FRI 13:30 - 14:50");
		LessonTime practiceTime5 = new LessonTime("PR15", "FRI 15:00 - 16:20");
		LessonTime practiceTime6 = new LessonTime("PR16", "FRI 16:30 - 17:50");


		lessonTimes = new ArrayList<LessonTime>(Arrays.asList(lectionTime1, lectionTime2, lectionTime4,
				lectionTime5, lectionTime6, lectionTime7, lectionTime9, lectionTime10, lectionTime11,
				lectionTime13, lectionTime14, lectionTime15, lectionTime12, lectionTime8, lectionTime3,practiceTime1,
				practiceTime2,practiceTime3,practiceTime4,practiceTime5,practiceTime6));
		Teacher teacher1 = new Teacher("Т1", "Дяченко");
		Teacher teacher2 = new Teacher("Т2", "Ющенко");
		Teacher teacher3 = new Teacher("Т3", "Проценко");
		Teacher teacher4 = new Teacher("Т4", "Пилявська");
		Teacher teacher5 = new Teacher("Т5", "Гулаєва");
		Teacher teacher6 = new Teacher("Т6", "Бублик");
		Teacher teacher7 = new Teacher("Т7", "Тригуб");
		Teacher teacher8 = new Teacher("Т8", "Франчук");
		Teacher teacher9 = new Teacher("Т9", "Олецький");

		teachers = new ArrayList<Teacher>(Arrays.asList(teacher1, teacher2, teacher3, teacher4,teacher5, teacher6, teacher7, teacher8,teacher9));

		Course course1 = new Course("C1 (L)", "Математична логіка", new ArrayList<Teacher>(Arrays.asList(teacher1, teacher4)), 25);
		Course course2 = new Course("C2 (L)", "Функц. програмування", new ArrayList<Teacher>(Arrays.asList(teacher2, teacher3)), 35);
		Course course3 = new Course("C3 (L)", "Бази даних", new ArrayList<Teacher>(Arrays.asList(teacher2, teacher5)), 25);
		Course course4 = new Course("C4 (L)", "Математичний аналіз", new ArrayList<Teacher>(Arrays.asList(teacher1, teacher4)), 30);
		Course course5 = new Course("C5 (L)", "Проц. програмування", new ArrayList<Teacher>(Arrays.asList(teacher6)), 35);
		Course course6 = new Course("C6 (L)", "АОС", new ArrayList<Teacher>(Arrays.asList(teacher7, teacher8)), 45);
		Course course7 = new Course("C7 (L)", "Алгоритми", new ArrayList<Teacher>(Arrays.asList(teacher6, teacher7)), 45);
		Course course8 = new Course("C8 (L)", "Front-back end", new ArrayList<Teacher>(Arrays.asList(teacher6, teacher7)), 45);

		Course course1P = new Course("C1 (P)", "Математична логіка", new ArrayList<Teacher>(Arrays.asList(teacher1, teacher4)), 15);
		Course course2P = new Course("C2 (P)", "Функц. програмування", new ArrayList<Teacher>(Arrays.asList(teacher2, teacher3)), 10);
		Course course3P = new Course("C3 (P)", "Бази даних", new ArrayList<Teacher>(Arrays.asList(teacher2, teacher5)), 10);
		Course course4P = new Course("C4 (P)", "Математичний аналіз", new ArrayList<Teacher>(Arrays.asList(teacher1, teacher4)), 12);
		Course course5P = new Course("C5 (P)", "Проц. програмування", new ArrayList<Teacher>(Arrays.asList(teacher6)), 20);
		Course course6P = new Course("C6 (P)", "АОС", new ArrayList<Teacher>(Arrays.asList(teacher7, teacher8)), 10);
		Course course7P = new Course("C7 (P)", "Алгоритми", new ArrayList<Teacher>(Arrays.asList(teacher6, teacher7)), 12);
		Course course8P = new Course("C8 (P)", "Front-back end", new ArrayList<Teacher>(Arrays.asList(teacher6, teacher7)), 10);

		courses = new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5, course6, course7,course8,
				course1P, course2P, course3P, course4P, course5P, course6P, course7P,course8P));

		Group group1 = new Group("КН-3", new ArrayList<Course>(Arrays.asList(course8, course2,course4,course8P, course2P,course4P)));
		Group group2 = new Group("ПМ-4", new ArrayList<Course>(Arrays.asList(course1, course7, course6,course1P, course7P, course6P)));
		Group group3 = new Group("ІПЗ-2", new ArrayList<Course>(Arrays.asList(course6, course7,course2,course6P, course7P,course2P)));
		Group group4 = new Group("КН-2", new ArrayList<Course>(Arrays.asList(course1, course3,course5,course1P, course3P,course5P)));

		groups = new ArrayList<Group>(Arrays.asList(group1, group2, group3, group4));

		groups.forEach(x -> numberOfClasses += x.getCourses().size());	//store number of total number of classes from all depts
		return this;
	}
	public ArrayList<Auditorium> getAuditoriums() {	//return Auditorium data
		return Auditoriums;
	}
	public ArrayList<Teacher> getTeachers() {	//return faculty data
		return teachers;
	}
	public ArrayList<Course> getCourses() {	//return course data
		return courses;
	}
	public ArrayList<Group> getGroups() {	//return groups data
		return groups;
	}
	public ArrayList<LessonTime> getLessonTimes() {	//return meeting times
		return lessonTimes;
	}
	public int getNumberOfClasses() {
		return numberOfClasses;     
	}

}
