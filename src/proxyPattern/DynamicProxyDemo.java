package proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xuyp
 * 动态代理
 * 适用于有接口的类代理
 */
public class DynamicProxyDemo {
  public static void main(String[] args) {
	BeenProxyerA bProxyerA = new BeenProxyerA();
	MyProxyer mProxyer = new MyProxyer(bProxyerA);
	mProxyer.doSomething("xyp");
  }
}

/**
 * @author xuyp
 * 被代理类的公共接口
 */

interface IBeenProxyer {
	public void doSomething(String name);
}

class BeenProxyerA implements IBeenProxyer{
	@Override
	public void doSomething(String name) {
		System.out.println("---BeenProxyerA--:"+name);
	}	
}

/**
 * @author xuyp
 * 代理类
 */
class MyProxyer implements InvocationHandler{
	Object obj;//被代理的对象
    public MyProxyer(Object obj){
    	this.obj=obj;
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = method.invoke(obj, args);
		System.out.println("执行代理方法");
		return result;
	}
		
	public void doSomething(String name) {
		IBeenProxyer beenProxyer = (IBeenProxyer)Proxy.newProxyInstance(obj.getClass()
				.getClassLoader(), obj.getClass().getInterfaces(), this);
		beenProxyer.doSomething(name);
	}
}