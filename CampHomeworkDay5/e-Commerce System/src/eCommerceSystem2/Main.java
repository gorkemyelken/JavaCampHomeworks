package eCommerceSystem2;

import eCommerceSystem2.business.concretes.UserManager;
import eCommerceSystem2.business.concretes.UserManagerGoogle;
import eCommerceSystem2.core.GoogleAuthManagerAdapter;
import eCommerceSystem2.core.GoogleMailManagerAdapter;
import eCommerceSystem2.dataAccess.concretes.InMemoryUserDao;
import eCommerceSystem2.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user1 = new User(4,"Görkem","Yelken","gorkemyelken@gmail.com","123456");
		UserManager userManager = new UserManager(new InMemoryUserDao(), new GoogleMailManagerAdapter());
		userManager.register(user1);
		UserManagerGoogle userManagerGoogle = new UserManagerGoogle(new GoogleAuthManagerAdapter(new InMemoryUserDao(), new GoogleMailManagerAdapter()));
		userManagerGoogle.register(user1);
	}

}
