
public class Main {

	public static void main(String[] args) {
		User student1 = new Student(1,"Görkem","Yelken","gorkemyelken@gmail.com");
		User ýnstructor1 = new Instructor(1,"Engin","Demiroð");
		String[] coursesOfStudent1 = {"C#"};
		student1.setCoursesUser(coursesOfStudent1);
		String[] coursesOfInstructor1 = {"C#","Java"};
		ýnstructor1.setCoursesUser(coursesOfInstructor1);
		
		
		StudentManager studentManager = new StudentManager();
		InstructorManager ýnstructorManager = new InstructorManager();
		studentManager.ýnformationAboutUser(student1);
		ýnstructorManager.ýnformationAboutUser(ýnstructor1);
		
		
	}

}
