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

@WebServlet("/deletefilms")
public class deletefilms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("getsid"));
	Film films=new Film();
	films.setId(id);
	FilmDAO database=new FilmDAO();
	PrintWriter pw= response.getWriter();
	
	
	
	try {
        database.deleteF(films);
        pw.write("Successfully deleted film");
    }catch (SQLException e) {
        e.printStackTrace();
    }
    pw.close();
   
	
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("deletefilms.jsp").include(request,response);

}

}
