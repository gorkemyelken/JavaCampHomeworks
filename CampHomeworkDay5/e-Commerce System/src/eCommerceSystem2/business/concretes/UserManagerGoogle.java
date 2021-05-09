package eCommerceSystem2.business.concretes;

import eCommerceSystem2.business.abstracts.UserService;
import eCommerceSystem2.core.AuthService;
import eCommerceSystem2.entities.concretes.User;

public class UserManagerGoogle implements UserService {

	private AuthService authService;
	
	public UserManagerGoogle(AuthService authService) {
		super();
		this.authService = authService;
	}

	@Override
	public void register(User user) {
		authService.register(user);
	}

}
