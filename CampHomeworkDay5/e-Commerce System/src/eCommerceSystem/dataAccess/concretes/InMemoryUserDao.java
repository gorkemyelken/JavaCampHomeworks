package eCommerceSystem.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystem.dataAccess.abstracts.UserDao;
import eCommerceSystem.entities.concretes.User;

public class InMemoryUserDao implements UserDao{

	public List<User> users;
	
	
	public InMemoryUserDao() {
		this.users = new ArrayList<User>();
		users.add(new User(1,"Ali","Yýlmaz","aliyýlmaz@gmail.com","123456"));
		users.add(new User(2,"Mehmet","Kara","mehmetkara@gmail.com","123456"));
		users.add(new User(3,"Ayþe","Þahin","aysesahin@gmail.com","123456"));
	}

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("User added in memory: " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("User updated : " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("User deleted : " + user.getFirstName() + " " + user.getLastName());
		
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
