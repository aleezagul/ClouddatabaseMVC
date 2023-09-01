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


@WebServlet("/Addfilms")
public class Addfilms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Addfilms() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("Addfilms.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String director=request.getParameter("director");
		String review=request.getParameter("review");
		String stars=request.getParameter("stars");
		int year=Integer.parseInt(request.getParameter("year"));
		Film films=new Film(07,title,year,director,stars,review);
		FilmDAO f=new FilmDAO();
		PrintWriter out =response.getWriter();
		
		try {
            f.insertF(films);
            out.write("Successfully inserted film");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        out.close();
    }

		
	

}
