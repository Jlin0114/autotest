//package zhiyiting2.data;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.testng.annotations.DataProvider;
//
//import zhiyiting2.test.chargeStandardManagement.MaintainChargeStandard;
//import zhiyiting2.test.parkingManagement.ParkingRoad;
//import zhiyiting2.test.workerManagement.WorkerList;
//
//public class ParkingRoadData {
//	public static String roadName="自动化测试1";
//	@DataProvider(name = "updateParkRoad")
//	public Object[][] updateParkRoad() {
//	      
//	       return new Object[][]{
//	               {"添加路段成功",},
//	              
//	       };
//	   }
//	@DataProvider(name = "batchChangeParkingRoadStatus")
//	public Object[][] batchChangeParkingRoadStatus() {
//		int roadIds[] = new int[1];
//		roadIds[0]=ParkingRoad.roadId;
//	       return new Object[][]{
//	               {"路段上线:",roadIds,"0"},
//	               {"路段下线:",roadIds,"1"},
//	       };
//	   }
//	@DataProvider(name = "batchUpdateParkRoadOperationStatus")
//		public Object[][] batchUpdateParkRoadOperationStatus() {
//			
//		       return new Object[][]{
//		               {"路段修改为正式运营:",ParkingRoad.roadId,"FORMAL"},
//		       };
//		   }
//	
//	
//	@DataProvider(name = "auditParkPlaceOut")
//	public Object[][] auditParkPlaceOut() {
//		int[] ids = new int[1];
//		ids[0]=ParkingRoad.placeId;
//	       return new Object[][]{
//	               {"车位关闭出库审核:",ids,"VETO"},
//	               {"车位开启出库审核:",ids,"PASS"},
//	       };
//	   }
//	@DataProvider(name = "batchOutAuditByParkingRoadCodes")
//	public Object[][] batchOutAuditByParkingRoadCodes() {
//		int[] roadCodes = new int[1];
//		roadCodes[0]=ParkingRoad.roadId;
//	       return new Object[][]{
//	               {"车位关闭出库审核:",roadCodes,"VETO"},
//	               {"车位开启出库审核:",roadCodes,"PASS"},
//	       };
//	   }
//	
//	//没写完
//	@DataProvider(name = "deviceConfig")
//	public Object[][] deviceConfig() {
//	       return new Object[][]{
//	               {"设备配置:",""},
//	       };
//	   }
//	
//	
//	@DataProvider(name = "batchAuditParkPlace")
//	public Object[][] batchAuditParkPlace() {
//		int ids[] = new int[1];
//		ids[0]=ParkingRoad.placeId;
//	       return new Object[][]{
//	    	   		{"车位下线:",ids,"VETO"},
//	               {"车位上线:",ids,"PASS"},
//	       };
//	   }
//	@DataProvider(name = "creatRoad")
//	public Object[][] creatRoad() {
//	      
//	       return new Object[][]{
//	               {"添加路段成功","113.92140212087071","22.52105806825077",this.roadName,"450103001",String.valueOf(MaintainChargeStandard.chargeStandardId),"Y","Y"},
//	              
//	       };
//	   }
//	@DataProvider(name = "addParkPlaces")
//	public Object[][] addParkPlaces() {
//	       return new Object[][]{
//	               {"添加车位(成功):",ParkingRoad.roadId,"113.9297159383628","22.520949566160184","1","1"},
//	               
//	       };
//	   }
//	
//	@DataProvider(name = "batchBindParkingRoadAndWorker")
//	public Object[][] batchBindParkingRoadAndWorker() {
//		int parkingRoadIds[] = new int[1];
//		parkingRoadIds[0] = ParkingRoad.roadId;
//		Object[] workerInfos = new Object[1];
//		Map map1 = new HashMap();
//		Map map = new HashMap();
//		map1.put("workerId",WorkerList.loadWorkerId);
//		workerInfos[0] = map1;
//	       return new Object[][]{
//	               {"路段绑定施工人员:",workerInfos,parkingRoadIds},
//	               
//	       };
//	   }
//	
//}
