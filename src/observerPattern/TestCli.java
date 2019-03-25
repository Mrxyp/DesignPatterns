package observerPattern;

import java.util.Observer;

public class TestCli {
    public static void main(String[] args) {
		MyObervereder obervereder = new MyObervereder();
		Observer watcher = new MyWatcher();
		
		obervereder.addObserver( watcher);
		obervereder.change();
	}
}
