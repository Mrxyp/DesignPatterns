package iteratorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuyp 迭代器模式 顾名思义就是顺序访问聚集中的对象，比如集合类中用到的iterator就是用此模式实现的
 */

/**
 * @author xuyp 抽象集合接口
 */
interface ICollection {

	/**
	 * 取得集合元素
	 * 
	 * @param index
	 * @return Object
	 */
	public Object getElement(int index);

	/**
	 * 取得集合大小
	 * 
	 * @return int
	 */
	public int size();

	/**
	 * 取得迭代对象
	 * 
	 * @return IIterator
	 */
	public IIterator getIIterator();
}

interface IIterator {
	/**
	 * 前移操作
	 * 
	 * @return Object
	 */
	public Object previous();

	/**
	 * 后移操作
	 * 
	 * @return Object
	 */
	public Object next();

	/**
	 * 是否还有下一个元素
	 * 
	 * @return boolean
	 */
	public boolean hasnext();

	/**
	 * 是否还有前一个元素
	 * 
	 * @return boolean
	 */
	public boolean hasprevious();

	/**
	 * 取得第一个元素
	 * 
	 * @return Object
	 */
	public Object first();
}

/**
 * 我的集合
 * 
 */
class MyCollection implements ICollection {
	public String str[] = { "A", "B", "C", "D", "E" };

	@Override
	public Object getElement(int index) {
		return str[index];
	}

	@Override
	public int size() {
		return str.length;
	}

	@Override
	public IIterator getIIterator() {
		return new MyIterator(this);
	}

}

/**
 * 他的集合
 * 
 */
class HisCollection implements ICollection {
	public List<String> list = new ArrayList<String>();

	public HisCollection() {
		this.list.add("E");
		this.list.add("F");
		this.list.add("G");
	}

	@Override
	public Object getElement(int index) {
		return list.get(index);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public IIterator getIIterator() {
		return new MyIterator(this);
	}

}

/**
 * 具体的迭代器
 * 
 */
class MyIterator implements IIterator {
	private ICollection collection;
	private int pos = -1;

	public MyIterator(ICollection collection) {
		this.collection = collection;
	}

	@Override
	public Object previous() {
		if (pos > 0) {
			pos--;
		}

		return collection.getElement(pos);
	}

	@Override
	public Object next() {
		if (pos < collection.size() - 1) {
			pos++;
		}
		return collection.getElement(pos);
	}

	@Override
	public boolean hasnext() {
		if (pos < collection.size() - 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object first() {

		return collection.getElement(0);
	}

	@Override
	public boolean hasprevious() {
		// TODO Auto-generated method stub
		if (pos > 0) {
			return true;
		} else {
			return false;
		}
	}
}

public class IteratorPatternDemo {
	public static void main(String agrs[]) {
		// 不同的集合，统一的遍历方式
		ICollection collection = new MyCollection();
		IIterator iterator = collection.getIIterator();
		while (iterator.hasnext()) {
			System.out.println(iterator.next());
		}

		ICollection hcollection = new HisCollection();
		IIterator hiterator = hcollection.getIIterator();
		while (hiterator.hasnext()) {
			System.out.println(hiterator.next());
		}
	}
}