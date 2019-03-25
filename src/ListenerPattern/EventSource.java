package ListenerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuyp
 * 事件源
 * 被监听者
 */
public class EventSource {
     List<IListener> listenerList = new ArrayList();
     
     public void addListeners(IListener listener){
    	 this.listenerList.add(listener);
     }
     
     public void notifyListener(IEvent event){
    	 event.setSource(this);
    	 for(IListener listener : listenerList){
    		 listener.handle(event);
    	 }
     }
     
     
}

