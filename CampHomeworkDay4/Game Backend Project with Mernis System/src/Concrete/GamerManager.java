package Concrete;

import Abstract.GamerCheckService;
import Abstract.GamerService;
import Entities.Gamer;

public class GamerManager implements GamerService{

	private GamerCheckService gamerCheckService;
	
	public GamerManager(GamerCheckService gamerCheckService) {
		this.gamerCheckService = gamerCheckService;
	}

	@Override
	public void add(Gamer gamer) {
		if(gamerCheckService.CheckIfRealPerson(gamer)) {
			System.out.println("Valid person");	
			System.out.println(gamer.getFirstName() + " registered.");
		}else {
			System.out.println("Invalid person");
			System.out.println(gamer.getFirstName() + " did not register.");
		}	
	}

	@Override
	public void update(Gamer gamer) {
		System.out.println(gamer.getFirstName() + " updated.");
		
	}

	@Override
	public void delete(Gamer gamer) {
		System.out.println(gamer.getFirstName() + " deleted.");
		
	}

}
