package Concrete;

import Abstract.SaleService;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class SaleManager implements SaleService {

	@Override
	public void sell(Game game, Gamer gamer) {
		System.out.println(game.getName() + " sold to " + gamer.getFirstName() 
		+ " for " + game.getPrice() + " tl.");
		
	}

	@Override
	public void sell(Game game, Gamer gamer, Campaign campaign) {
		System.out.println(game.getName() + " sold to " + gamer.getFirstName() 
		+ " for " + (game.getPrice() - ((game.getPrice()/100)*campaign.getDiscountRate())) + " tl.");
	}


}
