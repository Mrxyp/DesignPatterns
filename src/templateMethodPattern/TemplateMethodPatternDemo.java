package templateMethodPattern;

/*模板方法模式
 * 所谓模板方法模式也就是说有一个公共的模板方法（抽象父类的方法）供给大家（子类）使用
 * 比如每个子类都会用到的一些公用的算法*/

/**
 * ICaculator 抽象类
 * 
 */
abstract class ICaculator {
	/**
	 * 公用的模板方法
	 */
	public final void publicCaculate() {
		System.out.print("公用的模板方法");
	}

	/**
	 * 可被子类重写的方法
	 */
	public abstract void caculate();
}

/**
 *子类CaculatorA
 */
class CaculatorA extends ICaculator {

	@Override
	public void caculate() {
		// TODO Auto-generated method stub
		publicCaculate();
		System.out.println("-->CaculatorA的计算方法");
	}
}

/**
 * 子类CaculatorB
 */
class CaculatorB extends ICaculator {

	@Override
	public void caculate() {
		// TODO Auto-generated method stub
		publicCaculate();
		System.out.println("-->CaculatorB的计算方法");
	}

}

public class TemplateMethodPatternDemo {
	public static void main(String agrs[]) {
		ICaculator caculatorA = new CaculatorA();
		caculatorA.caculate();

		ICaculator caculatorB = new CaculatorB();
		caculatorB.caculate();
	}
}