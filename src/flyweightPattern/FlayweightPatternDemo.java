package flyweightPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/*享元模式
 * 享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用。
 * 当一个客户端请求时，工厂需要检查当前对象池中是否有符合条件的对象，如果有，就返回已经存在的对象，如果没有，则创建一个新对象
 * 下面以数据库连接池举例*/

/**
 * 数据库连接池
 */
class ConnectPool {
	private Vector<Connection> pool;// 连接池 vector 是线程安全的
	// 公有属性
	private String url = "127.0.0.1:3306/jdbc";
	private String userName = "root";
	private String password = "root";
	private String driveClassName = "com.mysql.jdbc.Driver";

	private int poolsize = 100;// 连接池大小
	private ConnectPool instance = null;
	private Connection connection = null;

	public ConnectPool() {// 构造方法 初始化
		pool = new Vector<Connection>(poolsize);
		for (int i = 0; i < poolsize; i++) {
			try {
				Class.forName(driveClassName);
				connection = DriverManager.getConnection(url, userName,
						password);
				pool.add(connection);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/* 返回连接到连接池 */
	public synchronized void release(Connection conn) {
		pool.add(conn);
	}

	/* 返回连接池中的一个连接 */
	public synchronized Connection getConnection() {
		if (pool.size() > 0) {
			Connection c = pool.get(0);
			pool.remove(c);
			return c;
		} else {
			return null;
		}
	}
}

public class FlayweightPatternDemo {
	
	public static void main(String agrs[]) {
		
		ConnectPool cpPool = new ConnectPool();
		Connection c = cpPool.getConnection();// 拿到一个连接
		/*
		 * 数据库操作......
		 */
		cpPool.release(c);// 用完之后放回连接池
	}
}