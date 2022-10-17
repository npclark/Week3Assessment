/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Oct 15, 2022
 */

package model;

import java.util.List;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Player player;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListGame> listOfGames;
	
	public ListDetails(int id, String listName, LocalDate tripDate, Player player, List<ListGame> listOfGames) {
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.player = player;
		this.listOfGames = listOfGames;
	}
	
	public ListDetails(String listName, LocalDate tripDate, Player player, List<ListGame> listOfGames) {
		this.listName = listName;
		this.tripDate = tripDate;
		this.player = player;
		this.listOfGames = listOfGames;
	}
	
	public ListDetails(String listName, LocalDate tripDate, Player player) {
		this.listName = listName;
		this.tripDate = tripDate;
		this.player = player;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<ListGame> getListOfGames() {
		return listOfGames;
	}

	public void setListOfGames(List<ListGame> listOfGames) {
		this.listOfGames = listOfGames;
	}
}
