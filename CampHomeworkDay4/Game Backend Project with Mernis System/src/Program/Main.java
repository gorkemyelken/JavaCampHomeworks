package Program;

import Adapters.MernisServiceAdapter;
import Concrete.CampaignManager;
import Concrete.GameManager;
import Concrete.GamerManager;
import Concrete.SaleManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class Main {

	public static void main(String[] args) {
		
		Gamer gamer1 = new Gamer(1,"Görkem","Yelken","gorkemyelken@gmail.com",1998,"12345");
		GamerManager gamerManager = new GamerManager(new MernisServiceAdapter());
		gamerManager.add(gamer1);
		
		Game game1 = new Game(1,"CS GO",100);
		GameManager gameManager = new GameManager();
		gameManager.add(game1);
		
		Campaign campaign1 = new Campaign(1,"Spring Campaign",30);
		CampaignManager campaignManager = new CampaignManager();
		campaignManager.add(campaign1);
		
		SaleManager saleManager = new SaleManager();
		saleManager.sell(game1, gamer1);
		saleManager.sell(game1, gamer1, campaign1);

	}

}
