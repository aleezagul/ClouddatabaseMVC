package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.FilmDAO;
import Film.Film;

@WebServlet("/UpdateFilms")
public class UpdateFilms extends HttpServlet {
	public static int id;
	
	
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title=request.getParameter("title");
		String director=request.getParameter("director");
		String review=request.getParameter("review");
		String stars=request.getParameter("stars");
		
		int year=Integer.parseInt(request.getParameter("year"));
		Film films=new Film(id,title,year,director,stars,review);
		films.setId(id);
		FilmDAO database=new FilmDAO();
		PrintWriter pw= response.getWriter();
		
		
		
		try {
            database.updateF(films);
            pw.write("Successfully updated films");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        pw.close();
       
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  id=Integer.parseInt(request.getParameter("updatesfilm"));
		
		
		
		
	request.getRequestDispatcher("Update.jsp").include(request,response);
	
	}
	
	
	
	
	

	

}
