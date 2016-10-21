package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import domain.User;

public class UserMapper {

	private static final Logger LOGGER = Logger.getLogger( UserMapper.class.getName() );
	static UserMapper inst;
	private static Connection c;
	int ID;

	public static UserMapper getInstance(){
		c = MySqlConnection.c;
		if (inst == null)
			inst = new UserMapper();
		return inst;
	}
	
	User findById(int idUser) {
		// methode bidon pour tester (en vrai: on recupere depuis la B.D.D.)
		String req = "SELECT nom FROM user WHERE idUser=?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(req);
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();
			rs.next();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,"User doesn't exist!");
			//e.printStackTrace();
		}
		User u = new User(1,"pseudo", "password", "admin");
		u.add(UnitOfWork.getInstance());
		return u;
	}
	public void update(User u) {
		System.out.println("On met a jour l'utilisateur dans la base de donnees.");
	}
}
