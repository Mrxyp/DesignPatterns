package prototypePattern;

import java.util.HashMap;

/*原型模式
 * */
public class PrototypePatternDemo {
	public static void main(String agrs[]) {
		ShapeCache.loadCache();
		Shape shape = ShapeCache.getShape(1);
		shape.draw();
	}
}

abstract class Shape implements Cloneable {
	private int id;
	public String typeString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	public abstract void draw();

	public Object clone() {
		Object cloneObject = null;
		try {
			cloneObject = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloneObject;
	}
}

class Squre extends Shape {
	public Squre() {
		this.typeString = "squre";
		System.out.println("Squre");
	}

	public void draw() {
		System.out.println("draw Squre");
	}
}

class ShapeCache {
	private static HashMap<Integer, Shape> caHashMap = new HashMap<Integer, Shape>();

	public static Shape getShape(int id) {
		return (Shape) caHashMap.get(id).clone();
	}

	public static void loadCache() {
		Squre squre = new Squre();
		squre.setId(1);
		caHashMap.put(squre.getId(), squre);
	}

}