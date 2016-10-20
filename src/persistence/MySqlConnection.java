package persistence;
import java.sql.*;
public class MySqlConnection {
    public static Connection c; 
    public static Connection getConnection(String username, String password){ 
        if (c == null) 
        	MySqlConnection.c = new MySqlConnection(username, password).c; 
        return MySqlConnection.c;
    }
    public static void closeConnection(){
    	try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    /**
     * Classe permettant de joindre la base de données.
     * 
     * @param username String
     * @param password String
     */
    public MySqlConnection(String username,String password) {
        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
	        String url = "jdbc:mysql://webtp.fil.univ-lille1.fr/"+username;
	        c = DriverManager.getConnection(url ,username,password);
	        c.setAutoCommit(true);
	    }catch(Exception e){
            System.out.println(e);
            closeConnection();
        };
    }
}