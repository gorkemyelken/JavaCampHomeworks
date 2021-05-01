
public class InstructorManager extends UserManager{
	
	@Override
	public void ýnformationAboutUser(User user) {
		super.ýnformationAboutUser(user);
		System.out.println("Courses of ýnstructor:");
		for(String course : user.getCoursesUser()) {
			System.out.println(course);
		}
	}
}
