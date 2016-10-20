package persistence;

import java.util.HashSet;
import java.util.Set;

import designPattern.IDomainObject;
import designPattern.Observateur;
import designPattern.Visiteur;

class UnitOfWork implements Observateur {
	Set<IDomainObject> dirty; 
	static UnitOfWork inst = null;
	public UnitOfWork() {
		dirty = new HashSet<IDomainObject>();
	}
	public static UnitOfWork getInstance() {
		if (inst == null)
			inst = new UnitOfWork();
		return inst;
	}
	public void action(IDomainObject o) {
		// enregister l'objet dans la liste des objets modifies
		dirty.add(o);
	}
	void commit() {
		Visiteur v = new Committer();
		for (IDomainObject o : dirty) {
			v.visiter(o);
		}
		dirty.clear();
	}
}