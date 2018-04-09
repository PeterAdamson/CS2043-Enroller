//Author Peter Adamson

package exam.pja;

import java.util.ArrayList;

public class Student 
{
	private final int studentID;
	private ArrayList<Grade> grades = new ArrayList<Grade>();
	
	public Student(int studentID)
	{
		this.studentID = studentID;
	}
	
	public void addGrade(Grade g)
	{
		grades.add(g);
	}
	
	//checks to ensure that a student has the required prerequisites for a course
	public boolean hasPrereq(ArrayList<String> prereqs)
	{
		boolean hasPrereq = true;
		
		for(int j = 0; j < prereqs.size(); j++)
		{
			String nameOfCourse = prereqs.get(j);					//the name of the prerequisite course that is necessary for the course in question
			boolean found = false;									//used to ensure the student has taken the course
			
			for(int i = 0; i < grades.size(); i++)
			{
				Grade gradeToCheck = grades.get(i);					//the grade obtained for a course
				String nameToCheck = gradeToCheck.getCourseNum();	//the name of the course that is being checked against
				
				if(nameToCheck.compareTo(nameOfCourse) == 0)		//we have found the course (i.e. the student has a grade for that course)
				{
					found = true;									//course has been taken
					
					if(!gradeToCheck.isPrereq())					//check if the grade obtained by the student is not satisfactory.  If not, student does not have the prereq
					{
						hasPrereq = false;
						break;
					}
				}
			}
			
			if(!found)												//student has not taken the course, so grade is inherantly not satisfactory
			{
				hasPrereq = false;
			}
		}
		return hasPrereq;
	}
	
	public String toString()
	{
		String result = studentID + " -";
		
		for(int i = 0; i < grades.size(); i++) 
		{
			result += " " + grades.get(i).toString();
		}
		return result;
	}
	
	public int getStudentID()
	{
		return studentID;
	}
	
}
