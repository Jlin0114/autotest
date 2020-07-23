package zhiyiting2.util;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UseBrowser {
	public static WebDriver driver1;
	public static WebDriver driver2;
	public WebDriver startFirefox(String url){
		
		try {

			// 默认支持火狐浏览器，能够正常打开，若不能打开火狐，则把下面的火狐的驱动放开

			System.setProperty("webdriver.gecko.driver","D:\\work\\软件安装地址\\geckodriver.exe");
 
			WebDriver driver = new FirefoxDriver();

			driver.get(url);

			System.out.println("成功打开火狐浏览器！");
			
			
			return driver;
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//			Thread.sleep(2000);

		} catch (Exception e) {

			System.out.println("打开火狐浏览器时出错了" + e);

		}

		return null;

	}
	public static void main(String[] args) {
		try {
			UseBrowser ub = new UseBrowser();
			WebDriver driver1 = ub.startFirefox("https://ptest.wisdomep.com/admin-v2/login");
			WebDriverWait wait = new WebDriverWait(driver1, 10);
			WebElement element = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div/input"))));
			element.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div/input")).sendKeys("admin");
			element = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input"))));
			element.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input")).sendKeys("szzytXX789789456");
			element = (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input"))));
			element.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[3]/div/button")).click();
			
			WebDriver driver2 = ub.startFirefox("https://ptest.wisdomep.com/admin-v2/login");
			WebDriverWait wait2 = new WebDriverWait(driver2, 10);
			WebElement element2 = (wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div/input"))));
			element2.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div/input")).sendKeys("zhaoming");
			element2 = (wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input"))));
			element2.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input")).sendKeys("zhaoming!");
			element2 = (wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input"))));
			element2.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[3]/div/button")).click();
			Thread.sleep(5000);
			//点击车位管理平台
//			element = (wait.until(ExpectedConditions.presenceOfElementLocated(
//					By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/section/div[2]/div[1]/div"))));
//			waitElementAppear(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/section/div[2]/div[1]/div"),
//					driver,null);
//        Actions action = new Actions(driver);
//        action.moveToElement(element.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/section/div[2]/div[1]/div"))).perform();
//			element.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/section/div[2]/div[1]/div")).click();
			driver1.get("https://ptest.wisdomep.com/admin-v2/systemManagement/roleManagement");
			
			//点击修改
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//        		By.xpath("//*[@id=\\\"app\\\"]/div/div/div/div[3]/div/div[2]/div[4]/div[2]/table/tbody/tr[9]/td[6]/div/button")));
			Thread.sleep(5000);
			waitElementAppear(By.xpath("//*[@id=\"app\"]/div/div/div/div[3]/div/div[2]/div[4]/div[2]/table/tbody/tr[9]/td[6]/div/button"),
					driver1,null);
			
			
//			while(true) {
//				try {
//					element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[3]/div/div[2]/div[4]/div[2]/table/tbody/tr[9]/td[6]/div/button"));
//					LeftMenu = wait.until(ExpectedConditions.elementToBeClickable(LeftMenu));
//					LeftMenu.sendKeys(Keys.ENTER);
//					break;
//				} catch (Exception e) {
//					System.out.println("没有找到元素");
//				}
//				
//			}
			Thread.sleep(5000);
			//运营商  编辑
			waitElementAppear(
					By.cssSelector(".el-tree > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > label:nth-child(2) > span:nth-child(1) > span:nth-child(1)"),
					driver1,null);
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[3]/div/div[2]/div[4]/div[2]/table/tbody/tr[9]/td[6]/div/button"));
			
			Thread.sleep(5000);
			waitElementAppear(
					By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[3]/div/div[2]/div/button"),
					driver1,null);
//			driver1.quit();
			
			
			
			driver2.get("https://ptest.wisdomep.com/admin-v2/operatorManagement/operatorList");
			waitElementAppear(
					By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[10]/div/button[1]/span"),
					driver2,null);
			
			waitElementAppear(
					By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[2]/div/div[2]/form/div[5]/button/span"),
					driver2,null);
			
			Thread.sleep(5000);
			driver1.quit();
			driver2.quit();
		} catch (Exception e) {
			e.printStackTrace();
			driver1.quit();
		}
        
        
	}
	//
	public static void waitElementAppear(By by,WebDriver driver,String value) throws Exception{
		long t1 = System.currentTimeMillis();
		while(true) {
			//如果找到元素就执行  否则就等待
			if(existsElement(by,driver)) {
				if(value==null||"".equals(value)) {
					WebDriverWait wait = new WebDriverWait(driver,10);
					WebElement LeftMenu = driver.findElement(by);
					LeftMenu = wait.until(ExpectedConditions.elementToBeClickable(LeftMenu));
					try {
						LeftMenu.click();
					} catch (ElementNotInteractableException e) {
						LeftMenu.sendKeys(Keys.ENTER);
					}
					
					break;
				}else {
					driver.findElement(by).sendKeys(value);
					break;
				}
			}else {
				Thread.sleep(100);
			}
			if(System.currentTimeMillis()-t1>10000) {
				throw new Exception("没有找到元素");
			}
		}
	}
//	
	public static boolean existsElement(By by,WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("没有找到元素");
			return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
