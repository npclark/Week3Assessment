/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Oct 16, 2022
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import model.ListGame;
import model.Player;
import model.ListDetails;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/CreateNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListGameHelper lgh = new ListGameHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String playerName = request.getParameter("playerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedGames = request.getParameterValues("allGamesToAdd");
		List<ListGame> selectedGamesInList = new ArrayList<ListGame>();
		
		if (selectedGames != null && selectedGames.length > 0) {
			for(int i = 0; i < selectedGames.length; i++) {
				System.out.println(selectedGames[i]);
				ListGame c = lgh.searchForGameById(Integer.parseInt(selectedGames[i]));
				selectedGamesInList.add(c);
			}
		}
		
		Player player = new Player(playerName);
		ListDetails pld = new ListDetails(listName, ld, player);
		pld.setListOfGames(selectedGamesInList);
		ListDetailsHelper plh = new ListDetailsHelper();
		plh.insertNewListDetails(pld);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
