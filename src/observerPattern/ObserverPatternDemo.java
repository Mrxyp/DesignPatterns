package observerPattern;

import java.util.Enumeration;
import java.util.Vector;

/**
 *  被观察者抽象接口
 */
interface Subject {
	/**
	 * 添加观察者
	 */
	public void addObserver(Observer observer);

	/**
	 * 删除观察者
	 */
	public void removeObserver(Observer observer);

	/**
	 * 通知所有观察者
	 */
	public void notifyObservers();

	/**
	 * 自我改变方法
	 */
	public void operation();
}

/**
 * @author xuyp 被观察者抽象类
 */
abstract class AbstractSubject implements Subject {
	private Vector<Observer> observers = new Vector<Observer>();

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		Enumeration<Observer> enumeration = observers.elements();
		while (enumeration.hasMoreElements()) {
			enumeration.nextElement().update();
		}
	}
}


/**
 *被观察者具体实现类
 */
class MySubject extends AbstractSubject {

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("我是被观察者MySubject我的状态改变了");
		notifyObservers();
	}

}

/**
 * 观察者抽象接口
 */
interface Observer {
	public void update();
}

class ObserverA implements Observer {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("观察者ObserverA方法update执行！");
	}
}

class ObserverB implements Observer {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("观察者ObserverB方法update执行！");
	}

}
/**
 *观察者模式： 观察者模式所描述的是当一个对象发生变化时，通知依赖它的对象，并产生相应的改变。
 */
public class ObserverPatternDemo {
	public static void main(String agrs[]) {
		Subject sb = new MySubject();
		Observer obA = new ObserverA();
		Observer obB = new ObserverB();
		sb.addObserver(obA);
		sb.addObserver(obB);
		sb.removeObserver(obB);
		sb.operation();
	}
}





