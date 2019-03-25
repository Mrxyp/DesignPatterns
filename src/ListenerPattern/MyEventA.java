package ListenerPattern;

public class MyEventA extends IEvent{
   
	@Override
	public void doSomething() {
       System.out.println("在事件源："+this.source.getClass().getName()+"触发事件MyEventA所做的反应");
	}

}
