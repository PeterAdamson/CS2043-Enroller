//Author Peter Adamson

package exam.pja;

public class Grade 
{
	
	private String courseNum;
	private String grade;
	
	public Grade(String courseNum, String grade)
	{
		this.courseNum = courseNum;
		this.grade = grade;
	}
	
	public boolean isPrereq() 
	{
		
		if(grade.compareTo("D") == 0 || grade.compareTo("F") == 0)
		{
			return false;
		}
		
		else
		{
			return true;
		}
	}

	public String toString()
	{
		String result = courseNum + ": " + grade;
		return result;
	}
	
	public String getCourseNum()
	{
		return courseNum;
	}
	
}
