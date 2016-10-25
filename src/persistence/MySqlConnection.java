package persistence;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MySqlConnection {
    public static Connection c;
	private static final Logger LOGGER = Logger.getLogger(MySqlConnection.class.getName());

    public static Connection getConnection(String username, String password){ 
        if (c == null) 
        	MySqlConnection.c = new MySqlConnection(username, password).c; 
        return MySqlConnection.c;
    }
    
    /**
     * Close the connection safely
     */
    public void closeConnection(){
    	try {
			c.close();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,"Connection doesn't exist.");
		}
    }
    
    /**
     * Class which join the database.
     *       
     * @param username String
     * @param password String
     */
    public MySqlConnection(String username,String password) {
        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
	        String url = "jdbc:mysql://webtp.fil.univ-lille1.fr/"+username;
	        c = DriverManager.getConnection(url ,username,password);
	        c.setAutoCommit(false);
	        System.out.println("Connexion réussie !!!");
	    }catch(Exception e){
	    	LOGGER.log(Level.SEVERE,"Can't join the database.");
        };
    }
}