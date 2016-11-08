package persistence;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import domain.User;

public class Main {

	public static boolean joinDbBool = true;
	private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

	/**
	 * Function which will get the username and the password of a user.
	 * 
	 * @return user User
	 */
	public static User connectUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir votre 'userAccount' :");
		String username = sc.nextLine();

		System.out.println("Veuillez saisir votre 'password' :");
		String mdp = sc.nextLine();

		User u = UserMapper.getInstance().findByNameAccount(username);
		if(u.getMdp()!=mdp){
			LOGGER.log(Level.SEVERE,"User and password don't match !");
		}
		return u;
	}

	static public void main(String args[]) {
		MySqlConnection mySql = new MySqlConnection();

		User u = connectUser();

		System.out.println(u.getMail());
		// u.setNom("Paul");
		// u.setMail("paul.pat@paul.com");
		UnitOfWork.getInstance().commit();
		// Si on appelle commit alors qu'il n'y a pas de modifications, on ne
		// fait rien.
		UnitOfWork.getInstance().commit();
		UnitOfWork.getInstance().commit();
		UnitOfWork.getInstance().commit();

		// Le commit() peut etre appelé "quand on veut" (periodiquement, apres
		// un CU ou a la fin d'une session etc... /!\ attention à la concurrence
		// si d'autres applications utilisent la base de données /!\.

		mySql.closeConnection();
	}
}
