package ListenerPattern;

public abstract class IEvent {
	
	 public EventSource source;
	 
     public abstract void doSomething();
     
     public void setSource(EventSource source){
    	 this.source=source;
     }
}
