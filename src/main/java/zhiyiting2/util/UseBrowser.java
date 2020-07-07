package zhiyiting2.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public static void main(String[] args) throws Exception{
		UseBrowser ub = new UseBrowser();
		ub.startFirefox("https://ptest.wisdomep.com/admin-v2/login");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		ub.startFirefox("https://ptest.wisdomep.com/admin-v2/login");
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
        WebElement element = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div/input"))));
        element.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div/input")).sendKeys("zhaoming");
        element = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input"))));
        element.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input")).sendKeys("zhaoming!");
        element = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input"))));
        element.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[3]/div/button")).click();
        element = (wait.until(ExpectedConditions.presenceOfElementLocated(
        		By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/section/div[2]/div[1]/div"))));
        element.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/section/div[2]/div[1]/div")).click();
      
        
        
        WebElement element2 = (wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div/input"))));
        element2.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div/input")).sendKeys("admin");
        element2 = (wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input"))));
        element2.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input")).sendKeys("szzytXX789789456");
        element2 = (wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input"))));
        element2.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[3]/div/button")).click();
      
	}
}
