package commandPattern;

/**
 * 命令模式 和军官命令士兵的场景一样，军官发号司令，士兵去执行具体的任务。军官不会关心士兵具体执行的细节。
 */
/**
 * 命令接口
 */
interface Command {
	public void exe();
}

/**
 * 传递命令角色 减轻命令者与被命令者的耦合关系
 */
class Invoker {
	private Command command;

	public Invoker(Command command) {
		this.command = command;
	}

	public void action() {
		command.exe();
	}
}

/**
 * 具体的命令
 * 
 */
class MyCommand implements Command {
	private Receiver receiver;

	public MyCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void exe() {
		receiver.action();
	}

}

/**
 * 具体的执行命令类（命令接收者）
 */
class Receiver {
	public void action() {
		System.out.println("执行命令！");
	}
}

public class CommandPatternDemo {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new MyCommand(receiver);

		Invoker invoker = new Invoker(command);
		invoker.action();
	}
}