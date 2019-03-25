package proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 */
public class DynamicPoxyDemo {
	public static void main(String[] args) {
		MyPoxy myPoxy = new MyPoxy();
		ISubject subject = new Subject();
		subject = (ISubject) myPoxy.bind(subject);
		subject.doSomethings();
	}
}

class MyPoxy implements InvocationHandler {

	Object target;//被代理的目标类

	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);//返回代理对象
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before...");
		Object obj = method.invoke(target, args);
		System.out.println("after...");
		return obj;
	}
}

interface ISubject {
	public void doSomethings();
}

class Subject implements ISubject {

	@Override
	public void doSomethings() {
		System.out.println("I am Subject.");
	}

}