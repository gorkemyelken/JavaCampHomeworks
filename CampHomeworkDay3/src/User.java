
public class User {
	int id;
	String firstName;
	String lastName;
	private String[] coursesUser;
	
	public User() {
		
	}
	
	public User(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String[] getCoursesUser() {
		return coursesUser;
	}

	public void setCoursesUser(String[] coursesUser) {
		this.coursesUser = coursesUser;
	}
}
