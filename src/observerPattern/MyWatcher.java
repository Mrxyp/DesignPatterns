package observerPattern;

import java.util.Observable;

public class MyWatcher implements java.util.Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("MyWatcher upadate:"+ arg);
	}
	
	
}
