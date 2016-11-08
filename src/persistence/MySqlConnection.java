package persistence;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MySqlConnection {
    public static Connection c;
	private static final Logger LOGGER = Logger.getLogger(MySqlConnection.class.getName());

    public static Connection getConnection(String username, String password){ 
        if (c == null) 
        	MySqlConnection.c = new MySqlConnection().c; 
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
     */
    public MySqlConnection() {
        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
	        String url = "jdbc:mysql://webtp.fil.univ-lille1.fr/deleplanque";
	        c = DriverManager.getConnection(url ,"deleplanque","vermelles0312");
	        c.setAutoCommit(false);
	    }catch(Exception e){
	    	LOGGER.log(Level.SEVERE,"Can't join the database.");
	    	System.exit(0);
        };
    }
}