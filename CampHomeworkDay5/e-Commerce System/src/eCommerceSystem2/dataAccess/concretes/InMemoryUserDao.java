package eCommerceSystem2.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystem2.dataAccess.abstracts.UserDao;
import eCommerceSystem2.entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	
	public List<User> users;
	
	public InMemoryUserDao() {
		this.users = new ArrayList<User>();
		users.add(new User(1, "Ali", "Öksüz", "alioksuz@gmail.com", "123456"));
		users.add(new User(2, "Ahmet", "Yýlmaz", "ahmetyilmaz@gmail.com", "123456"));
		users.add(new User(3, "Ayþe", "Polat", "aysepolat@gmail.com", "123456"));
	}
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("User registered successfully.");
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String eMail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
