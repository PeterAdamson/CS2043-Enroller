//Author Peter Adamson

package exam.pja;

public class Registrar 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Course course1 = new Course("CS2043", 3, 2);
		course1.addPrereq("CS1073");
		course1.addPrereq("CS1083");
		Student student1 = new Student(8510803);
		student1.addGrade(new Grade("CS1073","F"));
		course1.enroll(student1);
		int studentID = 8510804;
		
		for(int i = 0; i < 10; i++)
		{
			Student s = new Student(studentID);
			s.addGrade(new Grade("CS1073","B"));
			s.addGrade(new Grade("CS1083","A"));
			course1.enroll(s);
			studentID += 1;
		}
		Student student2 = new Student(8510814);
		student2.addGrade(new Grade("CS1073","B"));
		student2.addGrade(new Grade("CS1083","D"));
		course1.enroll(student2);
		System.out.println(course1.toString());
	}

}
