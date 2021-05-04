package Adapters;

import java.rmi.RemoteException;

import Abstract.GamerCheckService;
import Entities.Gamer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements GamerCheckService{

	@Override
	public boolean CheckIfRealPerson(Gamer gamer) {
		KPSPublicSoap mernisCheck = new KPSPublicSoapProxy();

		try {
			boolean result=mernisCheck.TCKimlikNoDogrula(Long.parseLong(gamer.getNationalityId()), 
							gamer.getFirstName().toUpperCase(), 
							gamer.getLastName().toUpperCase(), 
							gamer.getDateOfBirth());
			return result;
		} 
		catch (NumberFormatException exception) {
			exception.printStackTrace();
		} 
		catch (RemoteException exception) {
			exception.printStackTrace();
		}
		return false;
	}

}
