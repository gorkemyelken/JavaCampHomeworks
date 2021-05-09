package eCommerceSystem2.dataAccess.abstracts;

import java.util.List;

import eCommerceSystem2.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	User get(String eMail);
	List<User> getAll();
}
