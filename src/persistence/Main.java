package persistence;

import domain.User;

public class Main {
	static public void main(String args[]) {
		// args[2] : user | args[2] : mdp
		MySqlConnection mySql = new MySqlConnection(args[1],args[2]);

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
