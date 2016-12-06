package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String req = "SELECT name FROM user WHERE idUser=?";
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
	public User findByNameAccount(String nameAccount) {
		// methode bidon pour tester (en vrai: on recupere depuis la B.D.D.)
		String req = "SELECT nameAccount, mail, password, lastname, firstname, role FROM user WHERE nameAccount=?";
		PreparedStatement ps;
		ResultSet rs;
		User u = null;
		try {
			ps = c.prepareStatement(req);
			ps.setString(1, nameAccount);
			rs = ps.executeQuery();
			rs.next();
			u = new User(1,rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,"User doesn't exit !");
			//e.printStackTrace();
		}
		u.add(UnitOfWork.getInstance());
		return u;
	}
	public void update(User u) {
		System.out.println("On met a jour l'utilisateur dans la base de donnees.");
	}
}
