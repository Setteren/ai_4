package operation;

import domain.Class;
import domain.Group;

import java.util.ArrayList;

public class Schedule {
	private ArrayList<Class> classes;	
	private boolean isFitnessChanged = true;
	private double fitness = -1;
	private int classNumb = 0;
	private int numbOfConflicts = 0;
	private Data data;
	
	public Data getData() {
		return data;
	}
	public Schedule(Data data) {
		this.data = data;
		classes = new ArrayList<Class>(data.getNumberOfClasses());
	}
	
	public Schedule initialize() {
		new ArrayList<Group>(data.getGroups()).forEach(dept -> {
			dept.getCourses().forEach(course -> {
				Class newClass = new Class(classNumb++, dept, course);
				newClass.setLessonTime(data.getLessonTimes().get((int) (data.getLessonTimes().size() * Math.random())));
				newClass.setRoom(data.getAuditoriums().get((int) (data.getAuditoriums().size() * Math.random())));
				newClass.setTeacher(data.getTeachers().get((int) (data.getTeachers().size() * Math.random())));
				classes.add(newClass);
			});
		});
		return this;
	}
	
	public int getNumbOfConflicts() {
		return numbOfConflicts;
	}
	
	public ArrayList<Class> getClasses() {
		isFitnessChanged = true;
		return classes;
	}
	
	public double getFitness() {
		if( isFitnessChanged == true) {
			fitness = calculateFitness();
			isFitnessChanged = false;
		}
		return fitness;
	}
	private double calculateFitness() {
		numbOfConflicts = 0;
		classes.forEach(x -> {
			if(x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumbOfStudents()) 
				numbOfConflicts++;
			classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
				if(x.getLessonTime() == y.getLessonTime() && x.getId() != y.getId()) {
					if(x.getRoom() == y.getRoom())
						numbOfConflicts++;
					if(x.getTeacher() == y.getTeacher())
						numbOfConflicts++;
				}
			});
		});
		return 1/(double)(numbOfConflicts+1);
	}
	public String toString() {	//return the classes in a schedule
		String returnValue = new String();
		for(int x=0; x < classes.size()-1; x++)
			returnValue += classes.get(x) + ",";
		returnValue += classes.get(classes.size()-1);
		return returnValue;
	}
}
