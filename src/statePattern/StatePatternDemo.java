package statePattern;

/**
 * @author xuyp
 * 状态模式
 * 就好像qq一样不通的状态（在线，离线，巴拉巴拉）可对应不同的操作
 */

/**
 * QQ状态抽象类
 */
abstract class QQState {

	public abstract void sendMessage();

	public abstract void acceptMessage();
}

/**
 * 环境角色 状态切换类
 */
class Context {
	private QQState qqState;

	public void sendMessage() {
		this.qqState.sendMessage();
	}

	public void acceptMessage() {
		this.qqState.acceptMessage();
	}

	public QQState getQqState() {
		return qqState;
	}

	public void setQqState(QQState qqState) {
		this.qqState = qqState;
	}
}

/**
 * 在线状态
 * 
 */
class OnlineSate extends QQState {

	@Override
	public void sendMessage() {
		System.out.println("OnlineSate:能发送消息！");
	}

	@Override
	public void acceptMessage() {
		System.out.println("OnlineSate:能接收消息！");
	}
}

/**
 * 离线状态
 * 
 */
class OfflineState extends QQState {

	@Override
	public void sendMessage() {
		System.out.println("OfflineState:不能发送消息");
	}

	@Override
	public void acceptMessage() {
		System.out.println("OfflineState:不能接收消息");
	}
}

/**
 * 离开状态
 * 
 */
class LeaveState extends QQState {

	@Override
	public void sendMessage() {
		System.out.println("LeaveState:不能发送消息");
	}

	@Override
	public void acceptMessage() {
		System.out.println("LeaveState:能接收消息！");
	}

}

public class StatePatternDemo {
	public static void main(String[] args) {
		Context context = new Context();
		context.setQqState(new OnlineSate());
		context.sendMessage();
		context.acceptMessage();

		context.setQqState(new OfflineState());
		context.sendMessage();
		context.acceptMessage();

		context.setQqState(new LeaveState());
		context.sendMessage();
		context.acceptMessage();
	}
}