//package zhiyiting2.data;
//
//import org.testng.annotations.DataProvider;
//
//import zhiyiting2.app.AppData;
//import zhiyiting2.app.AppTest;
//import zhiyiting2.test.parkingManagement.ParkingList;
//import zhiyiting2.test.parkingManagement.ParkingRoad;
//
//public class ParkingListData {
//	public static String inDate="2020-03-21 10:00:00";//入库时间
//	public static String outDate="2020-03-21 12:00:00";//出库时间
//	@DataProvider(name = "reviseBillMoney")
//	public Object[][] reviseBillMoney() {
//	      
//	       return new Object[][]{
//	               {"调账:",ParkingList.billId,122.5,"23456","自动化测试调账"},
//	              
//	       };
//	   }
//	@DataProvider(name = "modifyPlateNoByRecord")
//		public Object[][] modifyPlateNoByRecord() {
//		      
//		       return new Object[][]{
//		               {"修改车牌:",ParkingList.billRecordId,"吉Z12345"},
//		              
//		       };
//		   }
//	@DataProvider(name = "createNewWorkOrder")
//	public Object[][] createNewWorkOrder() {
//	       return new Object[][]{
//	               {"派发新工单:",ParkingRoad.placeId},
//	               
//	       };
//	   }
//		
//	
//	@DataProvider(name = "reviseInOutRecordTime")
//	public Object[][] reviseInOutRecordTime() {
//	       return new Object[][]{
//	               {470,this.inDate,this.outDate},
//	               
//	       };
//	   }
//		
//	@DataProvider(name = "deviceEvidence")
//	public Object[][] deviceEvidence() {
//	       return new Object[][]{
//	               {"车位列表-点击取证按钮:",ParkingList.billRecordId},
//	               
//	       };
//	   }
//	
//	
//	@DataProvider(name = "createCleanWorkOrder")
//	public Object[][] createCleanWorkOrder() {
//	       return new Object[][]{
//	               {"派发设备清理单:","55","镜头不干净","CAMERA_LENS_WATER"},
//	               
//	       };
//	   }
//	
//	@DataProvider(name = "createReplaceWorkOrder")
//	public Object[][] createReplaceWorkOrder() {
//	       return new Object[][]{
//	               {"派发设备更换单:","55","自检异常"},
//	               
//	       };
//	   }
//	
//	@DataProvider(name = "manualHandleAudit")
//	public Object[][] manualHandleAudit() {
//	       return new Object[][]{
//	               {"入库复核:",AppData.plateNo,false,false,"SMALL",ParkingList.auditId,"IN"},
//	               
//	       };
//	   }
//}
