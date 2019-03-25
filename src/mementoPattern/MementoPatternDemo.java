package mementoPattern;

/**
 * @author xuyp 备忘录模式 主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象
 *         通俗的讲：假设有原始类A，A中有各种属性，A可以决定需要备份的属性，备忘录类B是用来存储A的一些内部状态，
 *         类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作
 */


/**
 * 原始对象类（备忘录发起角色）
 */
class Original {
	private String name;

	public Original(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Memento createMemento() {// 创建备忘录方法
		return new Memento(name);
	}

	public void restore(Memento memento) {// 恢复方法
		this.name = memento.getValue();
	}
}

/**
 * 备份类（备忘录角色）
 */
class Memento {
	private String value;

	public Memento(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

/**
 *存储类（备忘录管理角色）
 */
class Storage {
	private Memento memento;

	public Storage(Memento memento) {
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
public class MementoPatternDemo {
	
	public static void main(String[] args) {
		Original original = new Original("hello");// 创建原始对象
		Storage storage = new Storage(original.createMemento());// 创建备忘录
		System.out.println("初始化状态为：" + original.getName());
		// 修改原始类对象的属性
		original.setName("Hi");
		System.out.println("修改后状态为：" + original.getName());

		// 恢复原始状态
		original.restore(storage.getMemento());
		System.out.println("恢复后状态为：" + original.getName());
	}
}