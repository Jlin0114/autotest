package zhiyiting2.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UseBrowser {
	public static WebDriver driver;

	public WebDriver startFirefox(String url){

		try {

			// 默认支持火狐浏览器，能够正常打开，若不能打开火狐，则把下面的火狐的驱动放开

			System.setProperty("webdriver.gecko.driver","D:\\work\\软件安装地址\\geckodriver.exe");

			driver = new FirefoxDriver();

			driver.get(url);

			System.out.println("成功打开火狐浏览器！");

			

//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//			Thread.sleep(2000);

		} catch (Exception e) {

			System.out.println("打开火狐浏览器时出错了" + e);

		}

		return driver;

	}
	public static void main(String[] args) {
		UseBrowser ub = new UseBrowser();
		ub.startFirefox("http://www.baidu.com");
	}
}
