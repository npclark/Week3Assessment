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
import model.ListDetails;
import model.Player;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import model.ListGame;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDetailsHelper dao = new ListDetailsHelper();
		ListGameHelper lgh = new ListGameHelper();
		PlayerHelper ph = new PlayerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String playerName = request.getParameter("playerName");
		Player newPlayer = ph.findPlayer(playerName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedGames = request.getParameterValues("allGamesToAdd");
			List<ListGame> selectedGamesInList = new ArrayList<ListGame>();
			
			for (int i = 0; i < selectedGames.length; i++) {
				System.out.println(selectedGames[i]);
				ListGame c = lgh.searchForGameById(Integer.parseInt(selectedGames[i]));
				selectedGamesInList.add(c);
			}
			
			listToUpdate.setListOfGames(selectedGamesInList);
		} catch (NumberFormatException e) {
			List<ListGame> selectedGamesInList = new ArrayList<ListGame>();
			listToUpdate.setListOfGames(selectedGamesInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setTripDate(ld);
		listToUpdate.setPlayer(newPlayer);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
