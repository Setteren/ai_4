package operation;

import domain.Class;

import java.util.ArrayList;

public class Driver {
	public static final int TOURNAMENT_SELECTION_SIZE = 6;
	public static final int NUMB_OF_ELITE_SCHEDULES = 2;
	public static final int POPULATION_SIZE = 10;
	public static final double MUTATION_RATE = 0.3;
	public static final double CROSSOVER_RATE = 0.8;
	private int scheduleNumb = 0;
	private int classNumb = 1;
	private Data data;
	
	private void printScheduleAsTable(Schedule schedule, int generation) {
		ArrayList<Class> classes = schedule.getClasses();
		System.out.print("\n                     ");
		System.out.println("    №      | Спец      | Курс (id, макс к-ть студентів)         | Аудиторія (макс студ)    |  Вчитель (Id)           | Час (Id)");
		System.out.print("                       ");
		System.out.print("-----------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------");
		classes.forEach(x -> {
			int majorIndex = data.getGroups().indexOf(x.getDept());
			int courseIndex = data.getCourses().indexOf(x.getCourse());
			int roomsIndex = data.getAuditoriums().indexOf(x.getRoom());
			int teacherIndex = data.getTeachers().indexOf(x.getTeacher());
			int lessonTimeIndex = data.getLessonTimes().indexOf(x.getLessonTime());
			System.out.print("                        ");
			System.out.print(String.format("  %1$02d  ", classNumb) + " | ");
			System.out.print(String.format("%1$10s", data.getGroups().get(majorIndex).getName()) + " | " );
			System.out.print(String.format("%1$30s", data.getCourses().get(courseIndex).getName() + " ("+data.getCourses().get(courseIndex).getNumber()+", "+x.getCourse().getMaxNumbOfStudents()) + ")          | ");
			System.out.print(String.format("%1$15s",  data.getAuditoriums().get(roomsIndex).getNumber() +" ("+x.getRoom().getSeatingCapacity()) + ")      |  ");
			System.out.print(String.format("%1$20s", data.getTeachers().get(teacherIndex).getName()+ " ("+data.getTeachers().get(teacherIndex).getId()+")")+ "  | ");
			System.out.println(data.getLessonTimes().get(lessonTimeIndex).getTime()+" ("+data.getLessonTimes().get(lessonTimeIndex).getId()+")");
			classNumb++;
		});
		if(schedule.getFitness() == 1)
			System.out.println("> Відповідь знайдена за "+ (generation + 1) +" генерацій");
		System.out.print("------------------------------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------");
	}
	private void printAvailableData() {
		System.out.println("Всі групи ==>");
		data.getGroups().forEach(x -> System.out.println("назва: "+x.getName()+", курси: "+x.getCourses()));
		System.out.println("Всі курси==>");
		data.getCourses().forEach(x -> System.out.println("номер: "+x.getNumber()+", ім'я та прізвище: "+x.getName()+", макс к-сть студентів: " + x.getMaxNumbOfStudents()+ ", вчителі: " + x.getTeachers()));
		System.out.println("Всі аудиторії ==>");
		data.getAuditoriums().forEach(x -> System.out.println("номер: "+x.getNumber()+", вмістимість: "+x.getSeatingCapacity()));
		System.out.println("Всі вчителі ==>");
		data.getTeachers().forEach(x -> System.out.println("id: "+x.getId()+", ім'я та прізвище: "+x.getName()));
		System.out.println("Всі часові проміжки ==>");
		data.getLessonTimes().forEach(x -> System.out.println("id: "+x.getId()+", час: "+x.getTime()));
		System.out.print("--------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	}
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.data = new Data();
		int generationNumber = 0;
		driver.printAvailableData();
		System.out.println("> Генерацій: "+generationNumber);
		printFrame();
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
		Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitness();
		population.getSchedules().forEach(schedule -> System.out.println("       "+driver.scheduleNumb++ +"      | "+ String.format("%1$235s",  schedule )+ "  |  " +String.format("%.5f", schedule.getFitness()) + "  |  " +schedule.getNumbOfConflicts()));
		driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
		driver.classNumb = 1;
		while(population.getSchedules().get(0).getFitness() != 1.0) {
			System.out.println("> Генерацій: "+ ++generationNumber);
			printFrame();
			population = geneticAlgorithm.evolve(population).sortByFitness();
			driver.scheduleNumb = 0;
			population.getSchedules().forEach(schedule -> System.out.println("       "+driver.scheduleNumb++ +"      | "+ String.format("%1$235s",  schedule ) + "  |  " +String.format("%.5f", schedule.getFitness()) + "  |  " +schedule.getNumbOfConflicts()));
			driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
			driver.classNumb = 1;
		}
	}

	public static void printFrame(){
		System.out.print("  Розклад #  |                                            ");
		System.out.print("Клас [спеціальність,курс,аудитоія,вчитель,час]                                                      ");
		System.out.println( "                                                                                               | Fitness   | Conflicts");
		System.out.print("-----------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

	}
}
