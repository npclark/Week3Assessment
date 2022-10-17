/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Oct 15, 2022
 */

package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	@Id
	@GeneratedValue
	private int id;
	private String playerName;
	
	public Player() {
		super();
	}
	
	public Player(int id, String playerName) {
		this.id = id;
		this.playerName = playerName;
	}
	
	public Player(String playerName) {
		this.playerName = playerName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + "]";
	}
}
