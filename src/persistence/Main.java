package persistence;

import java.util.List;
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
		if(!u.getMdp().equals(mdp)){
			System.out.println("u.getMdp() : "+u.getMdp());
			System.out.println("mdp : " + mdp);
			LOGGER.log(Level.SEVERE,"User and password don't match !");
		}
		return u;
	}

	public static void friendMenu(){
		System.out.println("gérer les amis");
		boolean exit = true;
		int choice = 0;
		List<String> friends;
		while(exit){
			System.out.println("Que désirez-vous faire :");
			System.out.println("1. Afficher vos amis");
			System.out.println("2. Ajouter un ami");
			System.out.println("3. Supprimer un ami");
			System.out.println("9. Revenir au menu principal");
			try{
				Scanner sc = new Scanner(System.in);
				choice = Integer.parseInt(sc.nextLine());
			}catch (Exception e){
				choice=0;
			}
			switch(choice){
				default:
					friendMenu();
					break;
				case 1:
					System.out.println("Afficher vos amis");
					break;
				case 2:
					System.out.println("Ajouter un ami");
					break;
				case 3:
					System.out.println("Supprimer un ami");
					break;
				case 9:
					exit = false;
					break;
			}
		}
	}
	
	static public void mainMenu(User u){
		boolean exit = true;
		int choice = 0;
		while(exit){
			System.out.println("Que désirez-vous faire :");
			System.out.println("1. Gérer vos amis");
			System.out.println("2. Gérer vos messages");
			System.out.println("3. Créer un groupe");
			System.out.println("9. Sortir de l'application");
			try{
				Scanner sc = new Scanner(System.in);
				choice = Integer.parseInt(sc.nextLine());
			}catch (Exception e){
				choice=0;
			}
			switch(choice){
				default:
					mainMenu(u);
					break;
				case 1:
					friendMenu();
					break;
				case 2:
					System.out.println("gérer les messages");
					break;
				case 3:
					System.out.println("créer un groupe");
					break;
				case 9:
					System.out.println("sortir de l'app");
					exit = false;
					break;
			}
		}
	}
	
	static public void main(String args[]) {
		MySqlConnection mySql = new MySqlConnection();

		User u = connectUser();
		mainMenu(u);
		
		
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
