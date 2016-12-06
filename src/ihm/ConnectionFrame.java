package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.User;

import persistence.MySqlConnection;
import persistence.UserMapper;

public class ConnectionFrame extends JFrame{

	public static boolean joinDbBool = true;
	private static final Logger LOGGER = Logger.getLogger( ConnectionFrame.class.getName() );
	private static JTextField userAccount = new JTextField();
	private static JPasswordField userPassword = new JPasswordField();
	
	public MySqlConnection mySql;
	
	/**
	 * Création de la Frame d'identification
	 * */
	public ConnectionFrame(MySqlConnection mySql) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(400,300);
        
        this.mySql = mySql;

        GridLayout gl = new GridLayout(3, 1);
		this.setLayout(gl);
		JPanel userAccountPanel = UserAccountPanel();
		this.add(userAccountPanel);
		JPanel userPasswordPanel = UserPasswordPanel();
		this.add(userPasswordPanel);
		JPanel button = ButtonPanel();
		this.add(button);
        //User u = connectUser();
		//mainMenu(u);
        
        setLocationRelativeTo(null);
    }
	
	public JPanel UserAccountPanel(){
		JPanel result = new JPanel();
		GridLayout gl = new GridLayout(1, 2);
		result.setLayout(gl);
		result.add(new JLabel("User account : "));
		result.add(userAccount);
		return result;
	}
	
	public JPanel UserPasswordPanel(){
		JPanel result = new JPanel();
		GridLayout gl = new GridLayout(1, 2);
		result.setLayout(gl);
		result.add(new JLabel("password : "));
		result.add(userPassword);
		return result;
	}
	
	public JPanel ButtonPanel(){
		JPanel jpanel = new JPanel();
		JButton validate = new JButton("Ok");
		validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String account = userAccount.getText();
				final String pwd = userPassword.getText();
				System.out.println("Bouton appuyé");
				System.out.println("userAccount : " + userAccount.getText());
				System.out.println("userPassword : " + userPassword.getText());
				
				if(!userAccount.getText().equals("") && !userPassword.getText().equals("")){
					User u = UserMapper.getInstance().findByNameAccount(userAccount.getText());
					System.out.println(u.getMdp());
					
					if(!u.getMdp().equals(userPassword.getText())){
						System.out.println("u.getMdp() : "+u.getMdp());
						System.out.println("mdp : " + userPassword.getText());
						LOGGER.log(Level.SEVERE,"User and password don't match !");
					}else{
						UserFrame frame = new UserFrame(mySql,u);
				        frame.setVisible(true);
				        dispose();
					}
				}else if(!userAccount.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Fill your password");
				}else if(!userPassword.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Fill your user account");
				}
				/*
				try{
					int id = Integer.parseInt(userAccount.getText());
					if(id>0){
						try{
							PersonneDTO personne = tp.getPersonne(id);
							UserFrame frame = new UserFrame(tp,personne);
					        frame.setVisible(true);
					        dispose();
						}catch(Exception x){
							JOptionPane.showMessageDialog(null, "Identifiant inconnu.");
							userAccount.setText("");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Un identifiant est strictement positif et différent de zero.");
						userAccount.setText("");
					}
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Vous devez rentrer un nombre.");
					userAccount.setText("");
				}*/
			}
		});
		jpanel.add(validate);
		return jpanel;
	}
	
	/**
	 * Function which will get the username and the password of a user.
	 * 
	 * @return user User
	 */
	public static User connectUser() {
		User u = UserMapper.getInstance().findByNameAccount(userAccount.getText());
		if(!u.getMdp().equals(userPassword.getText())){
			System.out.println("u.getMdp() : "+u.getMdp());
			System.out.println("mdp : " + userPassword.getText());
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
	
	/**
	 * The main menu which will (orienter) the user in our application
	 * @param u User
	 * */
	static public void mainMenu(User u){
		boolean exit = true;
		int choice = 0;
		List<String> choices = new ArrayList<String>();
		choices.add("Que désirez-vous faire :");
		choices.add("1. Gérer vos amis");
		choices.add("2. Gérer vos messages");
		choices.add("3. Créer un groupe");
		choices.add("9. Sortir de l'application");
		
		
		while(exit){
			for(int c=0;c<choices.size();c++){
				System.out.println(choices.get(c));
			}
			
			// créer une frame en lui donnant la liste de choix
			// (à la place du scanner)
			// récupérer le résultat
			
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
					System.out.println(choices.get(2));
					break;
				case 3:
					System.out.println(choices.get(3));
					break;
				case 9:
					System.out.println(choices.get(4));
					exit = false;
					break;
			}
		}
	}
}
