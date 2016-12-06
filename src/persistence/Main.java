package persistence;

import javax.swing.JFrame;

import ihm.ConnectionFrame;

public class Main {

	public static boolean joinDbBool = true;
	
	static public void main(String args[]) {
		MySqlConnection mySql = new MySqlConnection();
		JFrame connectionFrame = new ConnectionFrame(mySql);
		connectionFrame.setVisible(true);
/*
		System.out.println("u.getMail() : "+u.getMail());
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
*/
		mySql.closeConnection();
	}
}
