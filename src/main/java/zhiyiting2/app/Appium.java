package zhiyiting2.app;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium {
		public static void main(String[] args) throws Exception{
			DesiredCapabilities capabilities = new DesiredCapabilities();//
			capabilities.setCapability("deviceName", "HJS5T18930005454");//设备名称6SNR8LJR7SFY7D4S
			capabilities.setCapability("platformName", "Android");//平台名称
			capabilities.setCapability("platformVersion", "10");//平台版本
			capabilities.setCapability("appPackage", "com.szzhiyiting.park");//app包名
			capabilities.setCapability("appActivity", "com.szzhiyiting.park.activity.WelcomeActivity");//APPactivity名称
//			capabilities.setCapability("appWaitActivity", "com.szzhiyiting.park.activity.WelcomeActivity");
			capabilities.setCapability("sessionOverride", false);
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
			capabilities.setCapability("automationName", "Appium");
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.findElementById("tv_account").click();
			
//			Thread.sleep(5000);
//			driver.quit();
		}
}
