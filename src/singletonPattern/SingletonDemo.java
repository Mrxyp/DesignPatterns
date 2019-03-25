package singletonPattern;

public class SingletonDemo {

}

/*
 * 懒汉模式 非线程安全 缺点线程不安全
 */
class SingleLZ {
	private static SingleLZ singleLZ;

	private SingleLZ() {
	}

	public static SingleLZ getIntenceLz() {
		if (singleLZ == null) {
			return new SingleLZ();
		} else {
			return singleLZ;
		}
	}
}

/*
 * 懒汉模式 线程安全 缺点性能差
 */
class SingleLZY {
	private static SingleLZY singleLZY;

	private SingleLZY() {
	}

	public static synchronized SingleLZY getIntenceLz() {
		if (singleLZY == null) {
			return new SingleLZY();
		} else {
			return singleLZY;
		}
	}
}

/*
 * 饿汉模式 线程安全 缺点浪费内存
 */
class SingleHanger {
	private static SingleHanger singleHanger = new SingleHanger();

	private SingleHanger() {
	}

	public static SingleHanger getIntenceHanger() {
		return singleHanger;
	}
}
