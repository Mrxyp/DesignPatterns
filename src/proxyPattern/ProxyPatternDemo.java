package proxyPattern;

interface AbstractPro {/* 抽象接口 */
	public void method();
}

class BeProxyeder implements AbstractPro {// 被代理的角色

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("被代理者执行的方法");
	}

}

class Proxyer implements AbstractPro {// 代理者
	private AbstractPro beenProxyeder;

	public Proxyer() {
		this.beenProxyeder = new BeProxyeder();
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		before();
		beenProxyeder.method();
		after();
	}

	public void before() {
		System.out.println("执行前的代理方法");
	}

	public void after() {
		System.out.println("执行后的代理方法");
	}
}

public class ProxyPatternDemo {
	public static void main(String agrs[]) {

		AbstractPro proxyer = new Proxyer();
		proxyer.method();
	}
}
