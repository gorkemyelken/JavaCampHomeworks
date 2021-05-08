package eCommerceSystem.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceSystem.business.abstracts.UserService;
import eCommerceSystem.core.AuthService;
import eCommerceSystem.dataAccess.abstracts.UserDao;
import eCommerceSystem.entities.concretes.User;

public class UserManager implements UserService{

	
	private UserDao userDao;
	private AuthService authService;
	
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public UserManager(UserDao userDao, AuthService authService) {
		super();
		this.userDao = userDao;
		this.authService = authService;
	}

	@Override
	public void register(User user) {
		if(isPasswordValid(user) && isEmailValid(user) 
				&& isEmailUsedBefore(user) && isFirstNameAndLastNameValid(user)) {
			userDao.add(user);
			System.out.println("User registered successfully.");
		}
	}
	
	@Override
	public void registerWithGoogle(User user) {
		if(isPasswordValid(user) && isEmailValid(user) 
				&& isEmailUsedBefore(user) && isFirstNameAndLastNameValid(user)) {
			userDao.add(user);
			authService.register(user);
		}
		
	}

	private boolean isFirstNameAndLastNameValid(User user) {
		if(user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			System.out.println("Name and surname must contain at least two characters.");
			return false;
		}
		else {
			return true;
		}
	}

	private boolean isEmailUsedBefore(User user) {
		for(User users : userDao.getAll()) {
			if(user.geteMail() == users.geteMail()) {
				System.out.println("The e-mail must not have been used before.");
				return false;
			}
		}
		return true;
	}

	private boolean isEmailValid(User user) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.geteMail());
	    if(matcher.matches()) {
	    	return true;
	    }
	    else {
	    	System.out.println("The e-mail field must be in e-mail format.");
	    	return false;
	    }
	}

	private boolean isPasswordValid(User user) {
		if(user.getPassword().length() < 6) {
			System.out.println("The password must be at least 6 characters.");
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void login(String eMail, String password) {
		for( User users : userDao.getAll()) {
			if(eMail == users.geteMail() && password == users.getPassword()) {
				System.out.println("User logged in the system.");
				return;
			}	
		}
			System.out.println("Username or password is incorrect.");
	}

	

}
