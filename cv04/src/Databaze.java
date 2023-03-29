import java.util.*;
import java.util.ArrayList;
import java.util.Collections;



public class Databaze 
{
	public Databaze() 
	{
		database = new HashMap<>();
	}
	
	public void setStudent(String name, int year, float gpa) 
	{
		database.put(name, new Student(year, gpa));
	}
	
	public Boolean setGPA(String name, float gpa) throws prumerException 
	{
		if (database.containsKey(name)) {
			database.get(name).writeGPA(gpa);
			return true;
		} else {
			System.out.print("Student neexistuje");
			return false;
		}
	}

	public Boolean getStudent(String name) throws prumerException 
	{
		if (database.containsKey(name)) {
			System.out.println("Jmeno: " + name + " Rok narozeni: " + database.get(name).getYear() + " Prumer: " + database.get(name).getGPA());
			return true;
		} else {
			System.out.println("Student neexistuje");
			return false;
		}
	}
	
	public void printStudentsByGPA() {
	    List<String> studentNames = new ArrayList<>(database.keySet());
	    Collections.sort(studentNames, (s1, s2) -> {
			try {
				return Float.compare(database.get(s2).getGPA(), database.get(s1).getGPA());
			} catch (prumerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		});
	    for (String name : studentNames) {
	        System.out.println(name + ": " + database.get(name).gpa);
	    }
	}

	
	
	public void delStudent(String name) {
		database.remove(name);
	}
	
	
	private HashMap<String, Student> database;

}