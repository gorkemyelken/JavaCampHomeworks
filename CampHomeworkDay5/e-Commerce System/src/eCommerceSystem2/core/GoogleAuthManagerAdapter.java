package eCommerceSystem2.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceSystem2.dataAccess.abstracts.UserDao;
import eCommerceSystem2.entities.concretes.User;
import eCommerceSystem2.googleAuth.GoogleAuth;

public class GoogleAuthManagerAdapter implements AuthService{

	private UserDao userDao;
	private EmailService emailService;
	
	public GoogleAuthManagerAdapter(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@Override
	public void register(User user) {
		GoogleAuth googleAuth = new GoogleAuth();
		if(checkPassword(user) && checkEmailFormat(user)
				&& checkEmailUsedBefore(user)) {
			emailService.send(user.geteMail());
			googleAuth.register(user);
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

}
