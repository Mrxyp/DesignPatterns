package observerPattern;

import java.util.Observable;

/**
 * @author xuyp
 *
 */
public class MyObervereder extends java.util.Observable{

	public void change(){
		setChanged();
		System.out.println("MyObervereder has change");
		notifyObservers("MyObervereder has change");
	}
}
