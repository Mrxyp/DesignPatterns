package factoryPattern;

import java.awt.Color;

/*抽象工厂模式*/
public class AbstractFactoryPatternDemo {
	public static void main(String agrs[]) {
		FactoryProduct product = new FactoryProduct();// 工厂的工厂
		AbstractFactory shapefFactory = new ShapeFactory();// 具体工厂
		AbstractFactory cAbstractFactory = new ColorFactory();
		Shape squreShape = shapefFactory.getShape("squre");// 工厂生产具体对象
		ColorA redA = cAbstractFactory.getColor("red");

		squreShape.Drow();
		redA.fill();
	}
}

class FactoryProduct {

	public AbstractFactory getFactory(String name) {
		if ("ShapeFactory".equals(name)) {
			return new ShapeFactory();
		}
		if ("ColorFactory".equals(name)) {
			return new ShapeFactory();
		}
		return null;
	}
}

interface AbstractFactory {// 抽象工厂类
	public Shape getShape(String name);

	public ColorA getColor(String name);
}

class ShapeFactory implements AbstractFactory {

	@Override
	public Shape getShape(String name) {
		// TODO Auto-generated method stub
		if ("squre".equals(name)) {
			return new Squre1();
		}
		return null;
	}

	@Override
	public ColorA getColor(String name) {
		// TODO Auto-generated method stub

		return null;
	}

}

class ColorFactory implements AbstractFactory {

	@Override
	public Shape getShape(String name) {
		return null;
	}

	@Override
	public ColorA getColor(String name) {
		if ("red".equals(name)) {
			return new Red();
		}
		return null;
	}

}

interface Shape {
	public void Drow();
}

interface ColorA {
	public void fill();
}

class Squre1 implements Shape {

	@Override
	public void Drow() {
		System.out.println("draw squre!");
	}

}

class Red implements ColorA {

	@Override
	public void fill() {
		// TODO Auto-generated method stub
		System.out.println("fill red!");
	}

}