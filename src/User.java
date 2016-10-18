import java.util.ArrayList;

public class User {

	public String nomCompte;
	public String mdp;
	public String mail;
	public String nom;
	public String prenom;
	public String role;
	public ArrayList<Hobby> hobbies;
	public ArrayList<User> friends;

	User(String nomCompte, String mdp, String role){
		this.nomCompte=nomCompte;
		this.mdp=mdp;
		this.role=role;
	}
	
	public String getNomCompte() {
		return nomCompte;
	}
	
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<Hobby> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	public void addHooby(Hobby hobby){
		this.hobbies.add(hobby);
	}
	public void remove(Hobby hobby){
		this.hobbies.remove(hobby);
	}
	
	public ArrayList<User> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}
	public void addFriend(User user){
		this.friends.add(user);
	}
	public void removeFriend(User user){
		this.friends.remove(user);
	}
}
