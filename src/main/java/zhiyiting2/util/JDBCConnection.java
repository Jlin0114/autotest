package zhiyiting2.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import zhiyiting2.model.ResponseModel;

@Component
public class JDBCConnection {

	public String executeUpdate(String[] str) {
		Connection con;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://122.112.153.102:3306/parking?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
		String user = "root";
		String password = "Sof6CGFGDqAnUsm0755";
		String id = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			ResultSet resultSet = null;
			if (!con.isClosed()) {
				System.out.println("数据库连接成功");
			}

			Statement statement = con.createStatement();
			String sql = "";
			int n = 0;
			for (int i = 0; i < str.length; i++) {
				sql = str[i];
				n += statement.executeUpdate(sql);
			}
			System.out.println("删除测试数据数量:" + n);
			if (resultSet != null) {
				resultSet.close();
			}
			con.close();
			System.out.println("数据库已关闭连接");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动没有安装");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public static List<Object> query(String querySql, Class objClass) throws Exception {
		// 查询结果集
		List<Object> queryResult = new ArrayList<Object>();
		// 数据库连接,这段代码应该写出去，这里为了演示，写里面了
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://122.112.153.102:3306/parking?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
		String user = "root";
		String password = "Sof6CGFGDqAnUsm0755";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		// 执行查询
		PreparedStatement preparedStatement = conn.prepareStatement(querySql);
		ResultSet result = preparedStatement.executeQuery();
		// 获取实体对象的方法和私有属性
		Map<String, Method> objMap = new HashMap<String, Method>();
		Field[] fields = objClass.getDeclaredFields();
		Method[] methods = objClass.getDeclaredMethods();
		Field.setAccessible(fields, true);
		for (Method m : methods) {
			for (Field f : fields) {
				String str1 = m.getName().toLowerCase();// set方法名
				String str2 = f.getName().toLowerCase();// 字段名
				if (str1.equals("set" + str2)) {
					objMap.put(f.getName(), m);
				}
			}
		}
		// 获取结果
		while (result.next()) {
			// 利用反射执行SET方法
			Object obj = objClass.newInstance();
			for (String fieldValue : objMap.keySet()) {
				Method setMethod = objMap.get(fieldValue);
				String paramenterType = setMethod.getParameterTypes()[0].getSimpleName();
				if (paramenterType.equals("String")) {
					try {
						setMethod.invoke(obj, result.getString(fieldValue));
					} catch (Exception e) {
//						System.out.println("数据库不存在该字段，不做处理");
					}

				} else if (paramenterType.equals("Integer")) {
					setMethod.invoke(obj, result.getInt(fieldValue));
				} else if (paramenterType.equals("Double")) {
					try {
						setMethod.invoke(obj, result.getDouble(fieldValue));
					} catch (Exception e) {
//						e.printStackTrace();
					}

				} else if (paramenterType.equals("char")) {
					setMethod.invoke(obj, result.getString(fieldValue).toCharArray()[0]);
				}
				// 。。。。。。。。这里可以把剩余的基本数据类型补充完整
			}
			queryResult.add(obj);
		}

		preparedStatement.close();
		conn.close();

		return queryResult;
	}

}
