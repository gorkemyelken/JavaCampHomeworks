
public class InstructorManager extends UserManager{
	
	@Override
	public void �nformationAboutUser(User user) {
		super.�nformationAboutUser(user);
		System.out.println("Courses of �nstructor:");
		for(String course : user.getCoursesUser()) {
			System.out.println(course);
		}
	}
}
