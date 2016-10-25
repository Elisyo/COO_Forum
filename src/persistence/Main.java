package persistence;

import java.util.Scanner;
import domain.User;

public class Main {
	
	public static boolean joinDbBool = true;
	
	/**
	 * Function which will get the username and the password of a user.
	 * 
	 * @return mySql MySqlConnection
	 */
	public static MySqlConnection joinDB(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir votre username :");
		String username = sc.nextLine();
		
		System.out.println("Veuillez saisir votre mot de passe :");
		String mdp = sc.nextLine();
		
		return new MySqlConnection(username,mdp);
	}
	
	static public void main(String args[]) {
		MySqlConnection mySql = joinDB();
		
		User u = UserMapper.getInstance().findById(0);

		u.setNom("Paul");
		u.setMail("paul.pat@paul.com"); 
		UnitOfWork.getInstance().commit();
        // Si on appelle commit alors qu'il n'y a pas de modifications, on ne fait rien.
		UnitOfWork.getInstance().commit();
		UnitOfWork.getInstance().commit();
		UnitOfWork.getInstance().commit();

        // Le commit() peut etre appelé "quand on veut" (periodiquement, apres un CU ou a la fin d'une session etc... /!\ attention à la concurrence si d'autres applications utilisent la base de données /!\. 

		mySql.closeConnection();
	}
}
