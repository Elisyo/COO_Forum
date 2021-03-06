package forum.action;

import java.sql.SQLException;
import java.util.ArrayList;

import forum.bean.data.Hobby;
import forum.services.IHobbyServices;
import forum.utils.MyFactory;

public class HobbyAction {
	
final IHobbyServices hobbyServices = (IHobbyServices) MyFactory.getInstance(IHobbyServices.class);
	
	private static HobbyAction INSTANCE = null;

	private HobbyAction() {
	}

	public synchronized static HobbyAction getInstance() {
		if (INSTANCE == null)
			INSTANCE = new HobbyAction();
		return INSTANCE;
	}
	
	public void removeHobby(Hobby hobby) throws SQLException{
		if(hobby != null){
			hobbyServices.removeHobby(hobby);
		}
	}
	
	public void createHobby(String categorie, String nom) throws SQLException{
		if(categorie != null && nom != null){
			hobbyServices.createHobby(categorie, nom);
		}
	}
	
	public ArrayList<Hobby> getAllHobbies(){
		ArrayList<Hobby> listHobbies = new ArrayList<Hobby>();
		listHobbies = hobbyServices.getAllHobbies();
		return listHobbies;
	}

	public ArrayList<String> getAllCategorie() throws SQLException{
		ArrayList<String> listCategorie = new ArrayList<String>();
		listCategorie = hobbyServices.getAllCategorie();
		return listCategorie;
	}
	
	public ArrayList<String> getHobbyByCategorie(String categorie) throws SQLException{
		ArrayList<String> listHobby = new ArrayList<String>();
		listHobby = hobbyServices.getHobbyByCategorie(categorie);
		return listHobby;
	}
	
	public ArrayList<Hobby> getOtherHobbies(){
		ArrayList<Hobby> listHobbies = new ArrayList<Hobby>();
		listHobbies = hobbyServices.getOtherHobbies();
		return listHobbies;
	}

	public ArrayList<String> getOtherCategorie() throws SQLException{
		ArrayList<String> listCategorie = new ArrayList<String>();
		listCategorie = hobbyServices.getOtherCategorie();
		return listCategorie;
	}
	
	public ArrayList<String> getOtherHobbyByCategorie(String categorie) throws SQLException{
		ArrayList<String> listHobby = new ArrayList<String>();
		listHobby = hobbyServices.getOtherHobbyByCategorie(categorie);
		return listHobby;
	}
	
	
	public Hobby getHobbyByName(String name) throws SQLException{
		Hobby hobby = new Hobby();
		hobby = hobbyServices.getHobbyByName(name);
		return hobby;
	}
}
