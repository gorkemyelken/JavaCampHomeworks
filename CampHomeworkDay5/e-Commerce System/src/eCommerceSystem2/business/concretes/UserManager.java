package eCommerceSystem2.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceSystem2.business.abstracts.UserService;
import eCommerceSystem2.core.EmailService;
import eCommerceSystem2.dataAccess.abstracts.UserDao;
import eCommerceSystem2.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private EmailService emailService;
	
	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@Override
	public void register(User user) {
		if(checkPassword(user) && checkEmailFormat(user)
				&& checkEmailUsedBefore(user) && checkFirstNameAndLastName(user)) {
			emailService.send(user.geteMail());
			userDao.add(user);
		}
		
	}

	private boolean checkPassword(User user) {
		if(user.getPassword().length() > 5) {
			return true;
		}
		else {
			System.out.println("The password must be at least 6 characters.");
			return false;
		}
		
	}
	
	private boolean checkEmailFormat(User user) {
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
	
	private boolean checkEmailUsedBefore(User user) {
		for(User user1 : userDao.getAll()) {
			if(user.geteMail() == user1.geteMail()) {
				System.out.println("The e-mail must not have been used before.");
				return false;
			}
		}
		return true;
	}
	
	private boolean checkFirstNameAndLastName(User user) {
		if(user.getFirstName().length() > 1 && user.getLastName().length() > 1) {
			return true;
		}
		else {
			System.out.println("Name and surname must contain at least two characters.");
			return false;
		}
	}
	

}
