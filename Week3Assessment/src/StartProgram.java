/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Sep 18, 2022
 */

import java.util.List;
import java.util.Scanner;

import controller.ListGameHelper;
import model.ListGame;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListGameHelper lgh = new ListGameHelper();

		private static void addAGame() {
			// TODO Auto-generated method stub
			System.out.print("Enter a game: ");
			String title = in.nextLine();
			System.out.print("Enter its genre: ");
			String genre = in.nextLine();
			ListGame toAdd = new ListGame(title, genre);
			lgh.insertGame(toAdd);

		}

		private static void deleteAGame() {
			// TODO Auto-generated method stub
			System.out.print("Enter the game to delete: ");
			String title = in.nextLine();
			System.out.print("Enter the genre to delete: ");
			String genre = in.nextLine();
			ListGame toDelete = new ListGame(title, genre);
			lgh.insertGame(toDelete);

		}

		private static void editAGame() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Game");
			System.out.println("2 : Search by Genre");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListGame> foundGames;
			if (searchBy == 1) {
				System.out.print("Enter the game's title: ");
				String gameTitle = in.nextLine();
				foundGames = lgh.searchForGameByTitle(gameTitle);
			} else {
				System.out.print("Enter the genre: ");
				String gameGenre = in.nextLine();
				foundGames = lgh.searchForGameByGenre(gameGenre);
			}

			if (!foundGames.isEmpty()) {
				System.out.println("Found Results.");
				for (ListGame l : foundGames) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListGame toEdit = lgh.searchForGameById(idToEdit);
				System.out.println("Retrieved " + toEdit.getTitle() + ", a " + toEdit.getGenre());
				System.out.println("1 : Update Title");
				System.out.println("2 : Update Genre");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				} else if (update == 2) {
					System.out.print("New Genre: ");
					String newGenre = in.nextLine();
					toEdit.setGenre(newGenre);
				}

				lgh.updateGame(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a game");
				System.out.println("*  2 -- Edit a game");
				System.out.println("*  3 -- Delete a game");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAGame();
				} else if (selection == 2) {
					editAGame();
				} else if (selection == 3) {
					deleteAGame();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lgh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListGame> allGames = lgh.showAllGames();
			for(ListGame singleGame : allGames) {
				System.out.println(singleGame.returnGameDetails());
			}
		}

	}