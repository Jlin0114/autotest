package zhiyiting2.util;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import zhiyiting2.test.CreatRoad;

public class ParameterData {
	@DataProvider(name = "login")
	public Object[][] loginData() {
	      
	       return new Object[][]{
	               {"账号密码正确","zhaoming","8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"},
	       };
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@DataProvider(name = "queryWorkOrder")
//	public Object[][] queryWorkOrder() {
//	       return new Object[][]{
//	               {"查看工单列表:","自动化测试1",CreatRoad.placeId},
//	               
//	       };
//	   }
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
