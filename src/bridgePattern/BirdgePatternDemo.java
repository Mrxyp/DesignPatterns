package bridgePattern;

/*
 * 桥接模式
 * 解决问题： 将事物与具体实现分开 使他们各自独立
 * 应用实例：jdbc 桥接，像我们常用的JDBC桥DriverManager一样，JDBC进行连接数据库的时候，
 * 在各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不用动，
 * 原因就是JDBC提供统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了
 * */

/**
 * jdbc 统一接口
 */
interface JdbcInterface {
	public void connectJdbc();
}

class MySqlconnec implements JdbcInterface {
	@Override
	public void connectJdbc() {
		System.out.println("连接mysql");
	}

}

class Oracleconnec implements JdbcInterface {
	@Override
	public void connectJdbc() {
		System.out.println("连接oracle");
	}
}

/**
 * 抽象桥接角色
 */
abstract class DriverManagerBrigde {
	private JdbcInterface jdbc;

	public abstract void connectDataBase();//连接数据库抽象方法

	public JdbcInterface getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcInterface jdbc) {
		this.jdbc = jdbc;
	}
}

/**
 * 具体实现桥角色
 */
class Mybridge extends DriverManagerBrigde {
	public void connectDataBase() {// 连接数据库的方法
		getJdbc().connectJdbc();
	}
}

public class BirdgePatternDemo {
	public static void main(String agrs[]) {
		DriverManagerBrigde mybridge = new Mybridge();
		JdbcInterface mySqlconnec = new MySqlconnec();
		// 连接mysql
		mybridge.setJdbc(mySqlconnec);
		mybridge.connectDataBase();

		// 连接oracle
		JdbcInterface oracleconnec = new Oracleconnec();
		mybridge.setJdbc(oracleconnec);
		mybridge.connectDataBase();
	}
}