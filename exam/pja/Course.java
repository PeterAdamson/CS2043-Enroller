//Author Peter Adamson

package exam.pja;

import java.util.ArrayList;

public class Course 
{
	
	private final String courseNum;
	private final int sectionCapacity;
	private final int studentsPerSection;
	private int numOfSections;
	private ArrayList<Student> waitListed = new ArrayList<Student>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<String> prereqs = new ArrayList<String>();
	private ArrayList<Integer> sections = new ArrayList<Integer>();

	public Course(String courseNum, int sectionCapacity, int studentsPerSection)
	{
		this.courseNum = courseNum;
		this.sectionCapacity = sectionCapacity;
		this.studentsPerSection = studentsPerSection;
		numOfSections = 1;
	}
	
	public void enroll(Student s)
	{
		if(!s.hasPrereq(prereqs))
		{
			/*Do Nothing
			 * Note that it may be preferable here to output an error to the user, but this is not specified as a desired output*/
		}
		
		else if(studentsInSection(numOfSections) < studentsPerSection)
		{
			students.add(s);
			sections.add(numOfSections);
		}
		
		else if(numOfSections < sectionCapacity)
		{
			numOfSections += 1;
			students.add(s);
			sections.add(numOfSections);
		}
		
		else
		{
			waitListed.add(s);
		}
	}
	
	public void addPrereq(String s)
	{
		prereqs.add(s);
	}
	
	public String getCourseName()
	{
		return courseNum;
	}	
	
	public int numWaitListed()
	{
		return waitListed.size();
	}
	
	public int studentsInSection(int sectionNum)
	{
		int count = 0;
		
		for(int i = 0; i < sections.size(); i++)
		{
			if(sections.get(i) == sectionNum)
			{
				count += 1;
			}
		}
		return count;
	}
	
	public String toString()
	{
		String result = courseNum + ": capacity " + sectionCapacity + " Sections, " + studentsPerSection 
				+ " students/section" + "\n" + "Current Number of Sections: " + numOfSections + ", Current Number of Students: "
				+ students.size() + ", waitlisted: " + waitListed.size() + "\n" + "\n";
		
		for(int i = 0; i < numOfSections; i++)
		{
			int section = i + 1;
			int count = studentsInSection(section);
			result += "Section " + section + " (" + count + " students):";
			
			for(int j = 0; j < sections.size(); j++)
			{
				
				if(sections.get(j) == section)
				{
					result += " " + students.get(j).getStudentID();
				}
			}
			result += "\n";
		}
		result += "Waitlist (" + numWaitListed() + " students):";
		
		for(int i = 0; i < numWaitListed(); i++)
		{
			result += " " + waitListed.get(i).getStudentID();
		}
		return result;
	}
	
}
