package domain;
import java.util.List;


public class Groupe {

	public String moderator;
	public List<User> users;
	public int idGroupe;
	
	Groupe(int idGroupe, String moderator){
		this.idGroupe=idGroupe;
		this.moderator=moderator;
	}
	
	public String getModerator() {
		return moderator;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getIdGroupe() {
		return idGroupe;
	}
}
