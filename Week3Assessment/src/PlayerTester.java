/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Oct 15, 2022
 */

import model.Player;
import controller.PlayerHelper;

import java.util.List;

public class PlayerTester {

	public static void main(String[] args) {
		Player noah = new Player("Noah");
		
		PlayerHelper ph = new PlayerHelper();
		
		ph.insertPlayer(noah);
		
		List<Player> allPlayers = ph.showAllPlayers();
		
		for(Player a: allPlayers) {
			System.out.println(a.toString());
		}

	}

}
