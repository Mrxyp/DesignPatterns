package builderPattern;


import java.util.ArrayList;
import java.util.List;

/*建造者模式
 意图：将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
主要解决：主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定。
何时使用：一些基本部件不会变，而其组合经常变化的时候。
如何解决：将变与不变分离开。
关键代码：建造者：创建和提供实例，导演：管理建造出来的实例的依赖关系。
应用实例： 1、去肯德基，汉堡、可乐、薯条、炸鸡翅等是不变的，而其组合是经常变化的，生成出所谓的"套餐"。 2、JAVA 中的 StringBuilder。
优点： 1、建造者独立，易扩展。 2、便于控制细节风险。
缺点： 1、产品必须有共同点，范围有限制。 2、如内部变化复杂，会有很多的建造类。
使用场景： 1、需要生成的对象具有复杂的内部结构。 2、需要生成的对象内部属性本身相互依赖。
注意事项：与工厂模式的区别是：建造者模式更加关注与零件装配的顺序。
 * */
public class BuilderPatternDemo {
	public static void main(String agrs[]){
		MealBuilder mBuilder=new MealBuilder();
		Meal meal=mBuilder.prepareVegMeal();
		Item cz=new ChengZhi();
		Item ckburger=new ChickenBurger();
		meal.addItem(cz);//加瓶橙汁
		meal.addItem(ckburger);//加个鸡肉汉堡
		meal.show();
	}

}
interface Item{//菜单
	public String name();
	public Packing packing();
	public float price();
}
interface Packing{//包装
	public String pack();
}

class Wrapper implements Packing{//纸盒

	@Override
	public String pack() {
		// TODO Auto-generated method stub
		return "Wrapper";		
	}
}

class Bottle implements Packing{

	@Override
	public String pack() {//瓶子
		// TODO Auto-generated method stub
		return "Bottle";
	}	
}

abstract class Burger implements Item{
	
	public Packing packing(){//汉堡用纸盒
		return new Wrapper();
	}
	
	public abstract float price();
}
abstract class ColdDrink implements Item{
	public Packing packing(){//冷饮用瓶子
		return new Bottle();
	}
	
	public abstract float price();
}

class VegBurger extends Burger{

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "VegBurger";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 5.0f;
	}//蔬菜汉堡
	
}

class ChickenBurger extends Burger{//鸡肉汉堡

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "ChickenBurger";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 8.0f;
	}
	
}

class Coke extends ColdDrink{//可乐

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Coke";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 1.0f;
	}
	
}
class ChengZhi extends ColdDrink{

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "ChengZhi";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 2.0f;
	}
}

class Meal{//套餐
	private List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item){
		this.items.add(item);
	}
	public float cost(){
		float c=0.0f;
		for(Item item:items){
			c+=item.price();
		}
		return c;
	}
	public void show(){
		for (Item item : items) {
	         System.out.print("Item : "+item.name());
	         System.out.print(", Packing : "+item.packing().pack());
	         System.out.println(", Price : "+item.price());
	      }		
	}
}

class MealBuilder{
	public Meal prepareVegMeal (){
	      Meal meal = new Meal();
	      meal.addItem(new VegBurger());
	      meal.addItem(new Coke());
	      return meal;
	   }   

	   public Meal prepareNonVegMeal (){
	      Meal meal = new Meal();
	      meal.addItem(new ChickenBurger());
	      meal.addItem(new ChengZhi());
	      return meal;
	   }
}
