package ListenerPattern;

public class TestApp {
    public static void main(String[] args) {
		EventSource source = new EventSource();
		IEvent eventA = new MyEventA();
		
		IListener listenerA = new ListeneA();
		source.addListeners(listenerA);
		
		source.notifyListener(eventA);
	}
}
