package designPattern;

public interface Observable {
	void add(Observateur o);
	void notifier();
}
