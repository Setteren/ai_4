package domain;

public class Teacher {
	private String id;
	private String name;
	
	public Teacher() {
		this.id = null;
		this.name = null;
	}
	
	public Teacher(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {		//return id
		return id;
	}
	public String getName() {	//return name
		return name;
	}
	public String toString() {	//return name as string to print
		return name;
	}
}
