
public class Main {

	public static void main(String[] args) {
		User student1 = new Student(1,"G�rkem","Yelken","gorkemyelken@gmail.com");
		User �nstructor1 = new Instructor(1,"Engin","Demiro�");
		String[] coursesOfStudent1 = {"C#"};
		student1.setCoursesUser(coursesOfStudent1);
		String[] coursesOfInstructor1 = {"C#","Java"};
		�nstructor1.setCoursesUser(coursesOfInstructor1);
		
		
		StudentManager studentManager = new StudentManager();
		InstructorManager �nstructorManager = new InstructorManager();
		studentManager.�nformationAboutUser(student1);
		�nstructorManager.�nformationAboutUser(�nstructor1);
		
		
	}

}
