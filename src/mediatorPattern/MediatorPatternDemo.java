package mediatorPattern;

/**
 * @author xuyp 中介者模式 的，因为如果类类之间有依赖关系的话，不利于功能的拓展和维护，因为只要修改一个对象，
 *         其它关联的对象都得进行修改。如果使用中介者模式，只需关心和Mediator类的关系，
 *         具体类类之间的关系及调度交给Mediator就行，这有点像spring容器的作用。
 */

/**
 * 中介者接口
 */
interface Mediator {
	public void createMediator();

	public void forward();
}

/**
 * 具体中介者 相当于路由器
 */
class MyMediator implements Mediator {
	private IComputer computerA;
	private IComputer computerB;
    private IComputer computerC;
	@Override
	public void createMediator() {
		computerA = new ComputerA();
		computerB = new ComputerB();
		computerC = new ComputerC();
	}

	@Override
	public void forward() {
		computerA.sendMessageTo(computerB);
		computerB.sendMessageTo(computerC);
	}
}

/**
 * 计算机抽象类
 */
interface IComputer {
	public void sendMessageTo(IComputer computer);

	public void acceptMessageFrom(IComputer computer);
}

/**
 * 具体计算机A 中介者管理的具体角色
 */
class ComputerA implements IComputer {

	@Override
	public void sendMessageTo(IComputer computer) {
		System.out.println(this + ":sendMessage to:" + computer);
		computer.acceptMessageFrom(this);

	}

	@Override
	public void acceptMessageFrom(IComputer computer) {
		System.out.println(this + ":acceptMessage from:" + computer);
	}

}

/**
 * 具体计算机B 中介者管理的具体角色
 */
class ComputerB implements IComputer {

	@Override
	public void sendMessageTo(IComputer computer) {
		System.out.println(this + ":sendMessage to:" + computer);
		computer.acceptMessageFrom(this);
	}

	@Override
	public void acceptMessageFrom(IComputer computer) {
		System.out.println(this + ":acceptMessage from:" + computer);
	}

}
/**
 * 具体计算机B 中介者管理的具体角色
 */
class ComputerC implements IComputer {

	@Override
	public void sendMessageTo(IComputer computer) {
		System.out.println(this + ":sendMessage to:" + computer);
		computer.acceptMessageFrom(this);
	}

	@Override
	public void acceptMessageFrom(IComputer computer) {
		System.out.println(this + ":acceptMessage from:" + computer);
	}

}

public class MediatorPatternDemo {
	public static void main(String[] args) {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.forward();
	}
}