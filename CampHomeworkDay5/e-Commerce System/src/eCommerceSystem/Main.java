package eCommerceSystem;

import eCommerceSystem.business.concretes.UserManager;
import eCommerceSystem.core.GoogleAuthManagerAdapter;
import eCommerceSystem.dataAccess.concretes.InMemoryUserDao;
import eCommerceSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(4,"Görkem","Yelken","gorkemyelken@gmail.com","123456");
		User user2 = new User(5,"Erdem","Yelken","erdemyelken@gmail.com","123456");
		UserManager userManager = new UserManager(new InMemoryUserDao(), new GoogleAuthManagerAdapter());
		
		// Register without Google account
		System.out.println("-----------------------");
		userManager.register(user1);
		
		// Register with Google account
		System.out.println("-----------------------");
		userManager.registerWithGoogle(user2);
		
		// Correct login
		System.out.println("-----------------------");
		userManager.login("gorkemyelken@gmail.com","123456");
		
		// Incorrect login
		System.out.println("-----------------------");
		userManager.login("gorkemyelken@gmail.com","1234567");
		
	}

}
