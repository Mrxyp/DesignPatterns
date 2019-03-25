package FacadePattern;

/*外观模式
 * 解决类与类之间的依赖关系
 * 以一个计算机程序启动的过程为例*/


/**
 * CPU 子系统
 *
 */
class CPU {
	public void startUp() {
		System.out.println("cpu startUp");
	}

	public void shutDown() {
		System.out.println("cpu shoutDown");
	}
}

/**
 *内存子系统
 *
 */
class Memory {
	public void startUp() {
		System.out.println("memory startUp");
	}

	public void shutDown() {
		System.out.println("memory shoutDown");
	}
}

/**
 * 计算机
 * 提供给客户端调用的‘高层接口’
 */
class Computer {
	private CPU cpu;
	private Memory memory;

	public Computer() {
		cpu = new CPU();
		memory = new Memory();
	}

	public void startUp() {
		System.out.println("start the computer");
		cpu.startUp();
		memory.startUp();
		System.out.println("start computer finished\n");
	}

	public void shoutDown() {
		System.out.println("shoutdown the computer");
		cpu.shutDown();
		memory.shutDown();
		System.out.println("shoutdown computer finished");
	}
}

public class FacadePatternDemo {
	public static void main(String agrs[]) {
		Computer computer = new Computer();
		computer.startUp();
		computer.shoutDown();
	}
}