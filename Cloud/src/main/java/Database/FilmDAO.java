package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Film.Film;

import java.sql.*;


public class FilmDAO {
	
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;
	String user = "root";
    String password = "test";
    // Note none default port used, 6306 not 3306
    String url = "jdbc:mysql:google/Cloud?cloudSqlInstance=films2023&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=test";
    		
	public FilmDAO() {}

	
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	
   public ArrayList<Film> getAllFilms(){
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement 
		try{
		    String selectSQL = "select * from films";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }

   public ArrayList<Film> getFilmByID(int id){
	   
		openConnection();
		ArrayList<Film> Search= new ArrayList<Film>();
		oneFilm=null;
	    // Create select statement 
		try{
		    String selectSQL = "select * from films where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	Search.add(oneFilm);
		    	
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return Search;
   }
   
   public boolean insertF (Film films) throws SQLException {

       openConnection();
        boolean b = false;
        try {
            String sql = "INSERT INTO films (title, year, director, stars, review) values ('"+ films.getTitle() + "','" + films.getYear() + "','" + films.getDirector() + "','" + films.getStars() +"','" + films.getReview() + "');";
            System.out.println(sql);
            b = stmt.execute(sql);
            closeConnection();
            b = true;
        } catch (SQLException e) {
            throw new SQLException("Film Not Added");
        }
        return b;
    }
   
   public boolean updateF (Film films) throws SQLException {

       openConnection();
        boolean b = false;
        try {
            String sql = "UPDATE films SET title='" + films.getTitle() + "', year='" + films.getYear() + "', director='" + films.getDirector() + "', stars='" + films.getStars() +"', review='" + films.getReview() + "'WHERE id='" +films.getId()+"';";
            System.out.println(sql);
            b = stmt.execute(sql);
            closeConnection();
            b = true;
        } catch (SQLException e) {
            throw new SQLException("Film Not Added");
        }
        return b;
   
   }
   public boolean deleteF (Film films) throws SQLException {

       openConnection();
        boolean b = false;
        try {
            String sql = "DELETE FROM films WHERE (id='" +films.getId()+"');";
            System.out.println(sql);
            b = stmt.execute(sql);
            closeConnection();
            b = true;
        } catch (SQLException e) {
            throw new SQLException("Film Not Added");
        }
        return b;
   
   }
   }

