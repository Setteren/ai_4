package domain;

public class Auditorium {
	private String number;
	private int seatingCapacity;
	
	public Auditorium() {
		this.number = null;
		this.seatingCapacity = -1;
	}
	
	public Auditorium(String number, int seatingCapacity)  {
		this.number = number;
		this.seatingCapacity = seatingCapacity;
	}
	public String getNumber() {		//utility function to return room number
		return number;
	}
	public int getSeatingCapacity() {    //utility function to return room capacity
		return seatingCapacity;
	}
}
