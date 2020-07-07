package zhiyiting2.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import zhiyiting2.model.ResponseModel;

@Component
public class JDBCConnection {



	public String executeUpdate(String[] str) throws Exception{

		String id = "";
		try {


			//注册驱动，获取连接
			Connection connection = jdbcUtil.getConnection();

			if (!connection.isClosed()) {
				System.out.println("数据库连接成功");
			}
			//创建sql执行平台
			Statement statement = connection.createStatement();

			statement = connection.createStatement();
			String sql = "";
			int n = 0;
			for (int i = 0; i < str.length; i++) {
				sql = str[i];
				n += statement.executeUpdate(sql);
			}
			System.out.println("删除测试数据数量:" + n);
			//获取结果集
			ResultSet resultSet = null;
			if (resultSet != null) {
				resultSet.close();
			}
			connection.close();
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
		//注册驱动，获取连接
		Connection connection = jdbcUtil.getConnection();
		//创建sql预处理平台
		PreparedStatement preparedStatement = connection.prepareStatement(querySql);
		//执行查询
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

		jdbcUtil.close(result,preparedStatement,connection);

		return queryResult;
	}

}
