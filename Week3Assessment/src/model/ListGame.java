/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Sep 18, 2022
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="games")

public class ListGame {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="Title")
	private String title;
	@Column(name="Genre")
	private String genre;
	
	public ListGame() {
		super();
	}
	
	public ListGame(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}
	
	public String returnGameDetails() {
		return this.title + ": " + this.genre;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
