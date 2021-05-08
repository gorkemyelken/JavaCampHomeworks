package eCommerceSystem.core;

import eCommerceSystem.entities.concretes.User;
import eCommerceSystem.googleAuth.GoogleAuth;

public class GoogleAuthManagerAdapter implements AuthService{

	@Override
	public void register(User user) {
		GoogleAuth googleAuth = new GoogleAuth();
		googleAuth.register(user);
	}

}
