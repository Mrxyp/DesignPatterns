package ListenerPattern;

public class ListeneA implements IListener{

	@Override
	public void handle(IEvent event) {
		System.out.println("ListeneA has listened");
		event.doSomething();//事件回调
	}

}
