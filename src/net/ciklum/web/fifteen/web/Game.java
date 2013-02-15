package net.ciklum.web.fifteen.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ciklum.web.fifteen.model.PuzzleBoard;
import net.ciklum.web.fifteen.model.PuzzleGame;

/**
 * Servlet implementation class Fifteen
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		if (name != null) {
			session.invalidate();
			session = request.getSession();
			session.setAttribute("name", name);
		} else if (session.getAttribute("name") == null) {
			RequestDispatcher view = request.getRequestDispatcher("/Hello");
			view.forward(request, response);
			return;
		}
		PuzzleBoard board;
		PuzzleGame game = null;
		if (session.getAttribute("board") == null || request.getParameter("new") != null) {
			board = new PuzzleBoard();
			game = new PuzzleGame(board);
			game.start();
			session.setAttribute("board", board);
		} else {
			board = (PuzzleBoard) session.getAttribute("board");
			game = new PuzzleGame(board);
		}
		if (request.getParameter("move") != null) {
			String move = request.getParameter("move");
			int imove = Integer.valueOf(move);
			if (game.movetile(imove)) {
				request.setAttribute("moved", true);
			}
		}
		RequestDispatcher view = request.getRequestDispatcher("/Game.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
