package eCommerceSystem2.core;

import eCommerceSystem2.googleMail.GoogleMail;

public class GoogleMailManagerAdapter implements EmailService {

	@Override
	public void send(String eMail) {
		GoogleMail googleMail = new GoogleMail();
		googleMail.send(eMail);	
	}

}
