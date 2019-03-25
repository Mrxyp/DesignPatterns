package compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象角色，为组合对象提供一个统一接口
 */
abstract class Component {
	private String name;

	public Component(String name) {
		this.name = name;
	}

	public abstract void add(Component c);

	public abstract void remove(Component c);

	public abstract void display();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

/**
 * 目录(支节点)
 * 
 */
class Catalog extends Component {
	/**
	 * 用来存放子目录或者文件
	 */
	private List<Component> compList = new ArrayList<Component>();

	public Catalog(String name) {
		super(name);
	}

	@Override
	public void add(Component c) {
		this.compList.add(c);
	}

	@Override
	public void remove(Component c) {
		this.compList.remove(c);
	}

	@Override
	public void display() {
		System.out.print(this.getName() + ":");
		for (int i = 0; i < compList.size(); i++) {
			if (i < compList.size() - 1) {
				System.out.print(compList.get(i).getName() + "-");
			} else {
				System.out.println(compList.get(i).getName());
			}
		}
	}
}

/**
 * 文件(叶子节点)
 * 
 */
class ComonFile extends Component {

	public ComonFile(String name) {
		super(name);
	}

	@Override
	public void add(Component c) {
		System.out.println("文件中不能添加目录或者文件");
	}

	@Override
	public void remove(Component c) {
		System.out.println("文件中不能删除目录或者文件");
	}

	@Override
	public void display() {
		System.out.println(this.getName());
	}
}

public class CompositePatternCli {
	public static void main(String[] args) {
		Component rootCataLog = new Catalog("根目录");
		rootCataLog.add(new ComonFile("文件1"));
		Catalog c1 = new Catalog("目录1");
		c1.add(new ComonFile("文件2"));
		rootCataLog.add(new Catalog("目录1"));
		rootCataLog.add(new Catalog("目录2"));
		rootCataLog.display();
	}
}