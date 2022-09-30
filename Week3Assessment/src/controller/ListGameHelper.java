/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Sep 18, 2022
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListGame;

public class ListGameHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
	
	public void insertGame(ListGame lg) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lg);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListGame> showAllGames() {
		EntityManager em = emfactory.createEntityManager();
		List<ListGame> allGames = em.createQuery("SELECT i FROM ListGame i").getResultList();
		return allGames;
	}
	
	public void deleteGame(ListGame toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select lg from ListGame lg where lg.title = : selectedTitle and lg.genre = :selectedGenre", ListGame.class);
		
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedGenre", toDelete.getGenre());
		
		typedQuery.setMaxResults(1);
		
		ListGame result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListGame> searchForGameByTitle(String title){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select lg from ListGame lg where lg.title = : selectedTitle", ListGame.class);
		
		typedQuery.setParameter("selectedTitle", title);
		
		List<ListGame> foundGames = typedQuery.getResultList();
		em.close();
		
		return foundGames;
	}
	
	public List<ListGame> searchForGameByGenre(String genre){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select lg from ListGame lg where lg.genre = : selectedGenre", ListGame.class);
		
		typedQuery.setParameter("selectedTItle", genre);
		
		List<ListGame> foundGames = typedQuery.getResultList();
		em.close();
		
		return foundGames;
	}
	
	public ListGame searchForGameById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListGame found = em.find(ListGame.class, id);
		em.close();
		return found;
	}
	
	public void updateGame (ListGame toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
