package builderPattern;

/**
 * 创建computer各个部件的指定接口 抽象建造者
 */
interface ComputerBuilder {
	public void buildCpu();

	public void buildMemory();

	public void buildGraphics();

	public Computer getComputer();
}

/**
 * 组装电脑的过程（使用建造者的对象） 
 * 构建过程
 */
class ComputerDirector {
	public void assembleComputer(ComputerBuilder builder) {
		builder.buildCpu();
		builder.buildMemory();
		builder.buildGraphics();
	}
}

/**
 * 具体的装机人员（具体建造者）
 * 
 */
class ComputerConcreteBuilder implements ComputerBuilder {
	private Computer computer = new Computer();

	@Override
	public void buildCpu() {
		System.out.println("组装酷睿i7 cpu");
		computer.setCpuName("酷睿i7");
	}

	@Override
	public void buildMemory() {
		System.out.println("组装DDR4 16G内存");
		computer.setMemoryName("DDR4 16G");
	}

	@Override
	public void buildGraphics() {
		System.out.println("组装1080p 显卡");
		computer.setGraphicsName("1080p 显卡");
	}

	@Override
	public Computer getComputer() {
		return computer;
	}
}

/**
 * 产品 电脑 表示被构造的复杂对象
 */
class Computer {

	private String cpuName;
	private String memoryName;
	private String graphicsName;

	public String getCpuName() {
		return cpuName;
	}

	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}

	public String getMemoryName() {
		return memoryName;
	}

	public void setMemoryName(String memoryName) {
		this.memoryName = memoryName;
	}

	public String getGraphicsName() {
		return graphicsName;
	}

	public void setGraphicsName(String graphicsName) {
		this.graphicsName = graphicsName;
	}

	public void show() {
		System.out.println("computer:" + "cpu:" + this.cpuName 
				+ " memory:" + this.memoryName + " graphics:"
				+ this.graphicsName);
	}
}

public class BuilderPatternCli {
	public static void main(String[] args) {
		ComputerDirector cmpDirector = new ComputerDirector();//组装过程
		ComputerConcreteBuilder cmpconbd = new ComputerConcreteBuilder();//具体建造者
		cmpDirector.assembleComputer(cmpconbd);//组装
		cmpconbd.getComputer().show();//得到电脑
	}
}