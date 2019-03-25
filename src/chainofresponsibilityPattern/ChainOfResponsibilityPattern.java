package chainofresponsibilityPattern;

/* 责任链模式
 * 对于一个请求，系统不确定要在哪一个责任对象对该请求进行处理或进行多次处理，则可以通过责任链模式来实现
 * */

/**
 * 抽象责任处理角色
 */
abstract class Handler {
	protected Handler nextHandler;// 后继责任处理者

	public Handler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public abstract void opreator();
}

/**
 * 具体责任角色
 */
class MyHandlers extends Handler {
	String name;

	public MyHandlers(String name) {
		this.name = name;
	}

	@Override
	public void opreator() {
		System.out.println(this.name + "处理请求");
		if (getNextHandler() != null) {
			getNextHandler().opreator();
		}
	}
}

public class ChainOfResponsibilityPattern {

	public static void main(String agrs[]) {
		// 实例化后生成一系列相互持有的对象，构成一条责任链。
		Handler handlerA = new MyHandlers("A对象");
		Handler handlerB = new MyHandlers("B对象");
		Handler handlerC = new MyHandlers("C对象");

		handlerA.setNextHandler(handlerB);
		handlerB.setNextHandler(handlerC);
		handlerA.opreator();
	}
}