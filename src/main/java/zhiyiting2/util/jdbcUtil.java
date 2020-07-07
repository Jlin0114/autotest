package zhiyiting2.util;

import netscape.security.PrivilegeTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.PortUnreachableException;
import java.security.Permission;
import java.sql.*;
import java.util.Properties;



// 解决硬编码问题  ---把配置信息放到配置文件里，从配置文件中读取，给代码使用

public class jdbcUtil {
    private static String url;
    private static String username;
    private static String password;

// 驱动注册的代码，只要执行一次 ---放静态代码块里
    static {
    InputStream is=null;
      try {
//          读取配置文件，得到数据库连接信息
          Properties properties = new Properties();
          //类名.class.getClassLoader()得到ClassLoader对象。
          //目的是：通过ClassLoader对象提供的一个方法：getResourceAsStream()，可以直接从类加载路径下读取文件，得到输入流对象
          //方法的参数：从src下开始加载文件的路径
          is = jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.propertise");
          properties.load(is);
 //     预生产
//		String url = "jdbc:mysql://119.3.55.236:3306/parking?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
//		String user = "zyt";
//		String password = "Sof6CGFGDqAnUsm62k6u@";
          String driver = properties.getProperty("driver");
          url=properties.getProperty("url");
          username=properties.getProperty("username");
          password=properties.getProperty("password");

          //1.注册驱动
          Class.forName(driver);
      }catch (Exception e){
                e.printStackTrace();
      }finally {
          if (is != null) {
              try {
                  is.close();
              } catch (IOException e) {
                  e.printStackTrace();
                }

          }
      }
    }


    public static Connection getConnection() throws Exception {
        //2.获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
        //3.关闭连接
    public static  void  close(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet != null) {
             try {
                       resultSet.close();
                   }catch (Exception e){
                       e.printStackTrace();
                   }
        }
        if (statement != null) {
             try {
                       statement.close();
                   }catch (Exception e){
                       e.printStackTrace();
                   }
        }
        if (connection != null) {
             try {
                       connection.close();
                   }catch (Exception e){
                       e.printStackTrace();
                   }

        }
    }


}
