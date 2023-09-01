
package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.FilmDAO;
import Film.Film;


@WebServlet("/Controller")
/*this class extends httpservlet which handles requests and responses*/
/*the class includes 2 methods, doget and dopost-they handle HTTP GET and Post request*/
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

   /*when somoene makes a request the doGet method is called. it creates filmDAO*/
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO Films= new FilmDAO();
		ArrayList<Film> FilmsAll = Films.getAllFilms();
		
		request.setAttribute("films", FilmsAll);
		request.getRequestDispatcher("JSPs/JSP.jsp").include(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO Films=new FilmDAO();
		String Search = request.getParameter("id");
		int id=Integer.parseInt(Search);
		ArrayList<Film> Srch = Films.getFilmByID(id);
		
		request.setAttribute("films", Srch);
		request.getRequestDispatcher("JSPs/JSP.jsp").include(request, response);
	}


}
