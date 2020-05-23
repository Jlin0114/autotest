package zhiyiting2.util;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import zhiyiting2.test.CreatRoad;

public class ParameterData {
	@DataProvider(name = "login")
	public Object[][] loginData() {
	      
	       return new Object[][]{
	               {"账号密码正确","zhaoming","ce56f5f20926b122be6f2b3ceef643448b7cf93726b0b12217600c4a01d47b9a"},
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
