package decoratorPattern;

/*装饰者模式*/
public class DecoratorPatternDemo {

	public static void main(String agrs[]) {
		AbstractClass sourse = new Sourse();
		AbstractClass decoretor = new Decorator(sourse);
		decoretor.method1();

		AbstractClass decoretor1 = new Decorator(decoretor);
		decoretor1.method1();
	}
}

interface AbstractClass {// 抽象接口
	public void method1();
}

class Sourse implements AbstractClass {// 被装饰者
	public Sourse() {
		System.out.println("我是被装饰者");
	}

	public void method1() {
		System.out.println("---method1---");
	}
}

class Decorator implements AbstractClass {// 装饰者
	private AbstractClass sourse;

	public Decorator(AbstractClass sourse) {
		this.sourse = sourse;
		System.out.println("我是装饰者（也可被装饰）");
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("装饰执行前");
		sourse.method1();
		System.out.println("装饰执行后");
	}

}