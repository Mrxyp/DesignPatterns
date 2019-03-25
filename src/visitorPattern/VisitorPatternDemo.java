package visitorPattern;

/**
 * 被访问者接口
 */
interface Subject {
	public void accept(Visitor visitor);

	public Subject getSubject();
}

class MySubject implements Subject {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Subject getSubject() {
		return this;
	}
}

/**
 * 访问者接口
 */
interface Visitor {
	public void visit(Subject subject);
}

class MyVisitor implements Visitor {

	@Override
	public void visit(Subject subject) {
		System.out.println(this + " 访问了--> " + subject.getSubject());
	}
}

class HisVisitor implements Visitor {
	@Override
	public void visit(Subject subject) {
		System.out.println(this + " 访问了--> " + subject.getSubject());
	}
}

/**
 * 访问者模式 访问者模式适用于数据接口不变，
 * 但是在其数据结构上的行为经常发生变化的情形 解决了数据结构与在其上操作的耦合问题
 */
public class VisitorPatternDemo {
	public static void main(String[] args) {
		Visitor myVisitor = new MyVisitor();
		Subject subject = new MySubject();
		subject.accept(myVisitor);

		Visitor hisVisitor = new HisVisitor();
		subject.accept(hisVisitor);

	}
}