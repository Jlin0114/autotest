package zhiyiting2.app;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium {
		public static void main(String[] args) throws Exception{
			DesiredCapabilities capabilities = new DesiredCapabilities();//
			capabilities.setCapability("deviceName", "HJS5T18930005454");//设备名称6SNR8LJR7SFY7D4S
			capabilities.setCapability("platformName", "Android");//平台名称
			capabilities.setCapability("platformVersion", "10");//平台版本
//			capabilities.setCapability("appPackage", "com.szzhiyiting.park");//app包名
//			capabilities.setCapability("appActivity", "com.szzhiyiting.park.activity.WelcomeActivity");//APPactivity名称
//			capabilities.setCapability("appWaitActivity", "com.szzhiyiting.park.activity.WelcomeActivity");
			capabilities.setCapability("appPackage", "com.tencent.mm");//app包名
			capabilities.setCapability("appActivity", ".ui.LauncherUI");//APPactivity名称
			capabilities.setCapability("sessionOverride", false);
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
			capabilities.setCapability("automationName", "Appium");
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);		
			Thread.sleep(5000);
			
			//获取当前时间
			//等待5000毫秒
			//点击元素
			//获取当前时间
			//time2-time1-5000
			
			
			
			
//			for(int i=0;i<100;i++) {
//				Long ti = System.currentTimeMillis();
//				while(true) {
//					try {
//						driver.findElementById("tv_account").click();
//						
//						break;
//					} catch (Exception e) {
//						System.out.println("没有找到tv_account元素");
//					}
//				}
////			tv_to_charge
////				boolean a = false;
////				try {
////					iv_back
////				} catch (Exception e) {
////					// TODO: handle exception
////				}
//				while(true) {
//					try {
//						System.out.println(System.currentTimeMillis()-ti);
//						driver.findElementById("iv_back").click();
//						break;
//					} catch (Exception e) {
//						System.out.println("没有找到iv_back元素");
//					}
//				}
//				
//				
//			}
			

		}
}
