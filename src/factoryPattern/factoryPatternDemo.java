package factoryPattern;

/*工厂模式*/
public class factoryPatternDemo {
	public static void main(String agrs[]) {
		FactoryShape factoryShape = new FactoryShape();
		Object shape;
		try {
			shape = factoryShape.CreateObject("factoryPattern.Squre");
			((Shape1) shape).Draw();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

interface Shape1 {
	public void Draw();
}

class FactoryShape {
	public Object CreateObject(String name) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class classType = Class.forName(name);
		return classType.newInstance();
	}
}

class SanJX implements Shape1 {

	@Override
	public void Draw() {
		System.out.println("draw sanjx!");
	}

}

class Squre implements Shape1 {

	@Override
	public void Draw() {
		System.out.println("draw squre!");
	}

}