//package zhiyiting2.data;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.testng.annotations.DataProvider;
//
//import zhiyiting2.test.operatorManagement.OperatorList;
//import zhiyiting2.test.parkingManagement.ParkingRoad;
//
//public class MonthlyChargeStandardData {
//	@DataProvider(name = "addPeriodRuleItem")
//	public Object[][] addPeriodRuleItem() {
//		int[] parkingRoadIds = new int[1];
//		parkingRoadIds[0]=ParkingRoad.roadId;
//	       return new Object[][]{
//	               {"新增包月规则:",OperatorList.operatorId,Integer.valueOf(OperatorListData.cityId),parkingRoadIds,true,0.01,1,true,0,0},
//	               
//	       };
//	   }
//}
