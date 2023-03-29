public class Student
{
	public Student(int year, float gpa)
	{
		this.year=year;
		this.gpa=gpa;
	}
	public void writeGPA(float gpa) throws prumerException
	{
		if (gpa >= 1 && gpa <= 5)
			this.gpa=gpa;
		else
			throw new prumerException(gpa);
	}

	public int getYear() 
	{
		return this.year;
	}
	
	
	
	public float getGPA() throws prumerException 
	{
		if (this.gpa == 0)
			throw new prumerException();
		else
			return this.gpa;
	}

	private int year; 
	public float gpa;
}