package proxyPattern;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author xuyp
 * CGLib动态代理
 */
public class ProxyByCGLibDemo {
	public static void main(String[] args) {
		//CGLib动态代理(可以同时给蛋糕、面包等加杏仁)
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BeenProxyeder.class);
        enhancer.setCallback(new MyPorxyInterceptor());
        BeenProxyeder beenProxyeder = (BeenProxyeder) enhancer.create();
        beenProxyeder.say("xyp");;
	}
}

class BeenProxyeder {
	public void say(String name){
		System.out.println("i am the beenProxyeder:"+name);
	}
}

class MyPorxyInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o , Method method,Object[] objects
			, MethodProxy methodProxy) throws Throwable {
		methodProxy.invokeSuper(o,objects);
		System.out.println("run the proxy function");
		return o;
	}
}