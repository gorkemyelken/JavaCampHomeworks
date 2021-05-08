package eCommerceSystem.business.abstracts;

import eCommerceSystem.entities.concretes.User;

public interface UserService {
	void register(User user);
	void registerWithGoogle(User user);
	void login(String eMail, String password);
}
