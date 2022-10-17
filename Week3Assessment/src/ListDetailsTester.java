/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Oct 16, 2022
 */

import model.Player;
import model.ListGame;
import model.ListDetails;
import controller.PlayerHelper;
import controller.ListGameHelper;
import controller.ListDetailsHelper;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class ListDetailsTester {
	public static void main(String[] args) {
		Player malachi = new Player("Malachi");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListGame feAwakening = new ListGame("Fire Emblem Awakening", "SRPG");
		ListGame doom = new ListGame("Doom", "FPS");
		
		List<ListGame> malachisGames = new ArrayList<ListGame>();
		malachisGames.add(feAwakening);
		malachisGames.add(doom);
		
		ListDetails malachiList = new ListDetails("Malachi's List", LocalDate.now(), malachi);
		malachiList.setListOfGames(malachisGames);
		
		ldh.insertNewListDetails(malachiList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
