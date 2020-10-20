package operation;
import java.util.ArrayList;
import java.util.stream.IntStream;

// population для створення розкладів (вирішення різних часткових рішень проблеми)
public class Population {
	private ArrayList<Schedule> schedules;	// один розклад має список занять
	
	public Population(int size, Data data) {
		schedules = new ArrayList<Schedule>(size);
		IntStream.range(0, size).forEach(x -> schedules.add(new Schedule(data).initialize()));
	}
	
	public ArrayList<Schedule> getSchedules() {
		return this.schedules;
	}
	  
	public Population sortByFitness() { //decreasing order
		schedules.sort((schedule1, schedule2) -> {
			int returnValue = 0;
			if(schedule1.getFitness() > schedule2.getFitness())
				returnValue = -1;
			else if(schedule1.getFitness() < schedule2.getFitness())
				returnValue = 1;
			return returnValue;
		}); 
		return this;
	}
	
}
