//package zhiyiting2.data;
//
//import org.testng.annotations.DataProvider;
//
//import zhiyiting2.test.parkingManagement.ParkingList;
//import zhiyiting2.test.workerManagement.WorkOrderList;
//import zhiyiting2.test.workerManagement.WorkerList;
//
//public class WorkOrderListData {
//	public static Integer deviceNo=999012;//999033
//	@DataProvider(name = "querySingleWorkOrderDetail")
//	public Object[][] querySingleWorkOrderDetail() {
//	       return new Object[][]{
//	               {"工单列表查看详情:",ParkingList.workorderId},
//	               
//	       };
//	   }
//	
//	@DataProvider(name = "backfillConstructWorkOrderActivity")
//	public Object[][] backfillConstructWorkOrderActivity() {
//	       return new Object[][]{
//	               {"派发新装单回填:",String.valueOf(WorkOrderList.activityId),String.valueOf(this.deviceNo),String.valueOf(WorkerList.loadWorkerId)},
//	               
//	       };
//	   }
//	
//	
//	
//}
