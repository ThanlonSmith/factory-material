package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sun.print.PSPrinterJob.PluginPrinter;

public class BaseDao {
	/**
	 * 创建数据库连接对象
	 * @return conn
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			本地数据库
			String url = "jdbc:mysql://localhost:3306/factory_materials?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
//			远程主机上的数据库
			String url2 = "jdbc:mysql://47.102.145.225:3306/factory_materials?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
//			数据库用户名
			String username = "lipeipei";
//			数据库密码
			String password = "Lipeipei123456!";
			conn = DriverManager.getConnection(url2, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 测试数据库是否连接成功
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = BaseDao.getConnection();
		if (conn != null) {
			System.out.println("数据库连接成功！");
		}
	}
}
