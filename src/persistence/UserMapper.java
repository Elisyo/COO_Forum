package persistence;

import domain.User;

public class UserMapper {

	static UserMapper inst;
	public static UserMapper getInstance(){
		if (inst == null)
			inst = new UserMapper();
		return inst;
	}
	User findById(int id) {
		// methode bidon pour tester (en vrai: on recupere depuis la B.D.D.)
		User p = new User(1,"pseudo", "motDePasse", "admin");
		p.add(UnitOfWork.getInstance());
		return p;
	}
	public void update(User u) {
		System.out.println("On met a jour l'utilisateur dans la base de donnees.");
	}
}
