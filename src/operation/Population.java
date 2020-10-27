package operation;
import java.util.ArrayList;
import java.util.Collection;
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
	public CSP<Integer> createCSP() {
		CSP<Integer> csp = new CSP<Integer>();



		Collection<Integer> domain = new ArrayList<Integer>(10);
		for(int i = 0; i < 4; ++i) {
			domain.add(i);
		}



		return csp;
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
