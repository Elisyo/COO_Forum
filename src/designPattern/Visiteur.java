package designPattern;
import domain.User;

public abstract class Visiteur {
	public void visiter(IDomainObject o) {
		o.accepter(this);
	}
	abstract public void visiter(User u);
    // abstract public void visiter(Groupe g);
    // etc...
}
