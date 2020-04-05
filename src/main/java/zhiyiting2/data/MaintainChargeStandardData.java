//package zhiyiting2.data;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.testng.annotations.DataProvider;
//
//
//public class MaintainChargeStandardData {
//	public static String chargeStandardName="自动化测试收费规则";
//	@DataProvider(name = "addChargeStandardMultipleInfo")
//	public Object[][] addChargeStandardMultipleInfo() {
//		
//		Object[] dayChargeStandardList = new Object[3];
//		Map m0 = new HashMap();
//		m0.put("freeMinutesMode", 0);
//		m0.put("smallCarFreeMinutes", 1);
//		m0.put("chargeCapMode", 0);	
//		m0.put("smallCarChargeCap", 35);	
//		dayChargeStandardList[0]=m0;
//		
//		Map m1 = new HashMap();
//		m1.put("startTime", "08:00");
//		m1.put("endTime", "20:00");
//		m1.put("chargeType", 3);	
//		m1.put("chargeCycleMinutes", 30);
//		m1.put("smallCarRate", "1");
//		dayChargeStandardList[1]=m1;
//		Map m2 = new HashMap();
//		m2.put("startTime","20:00");	
//		m2.put("endTime", "08:00");
//		m2.put("chargeType",0);
//		dayChargeStandardList[2]=m2;
//	       return new Object[][]{
//	               {"新增收费规则:",Integer.valueOf(OperatorListData.provinceId),Integer.valueOf(OperatorListData.cityId),
//	            	   this.chargeStandardName,"ONE_LEVEL",20,1,false,false,dayChargeStandardList},
//	               
//	       };
//	   }
//}
