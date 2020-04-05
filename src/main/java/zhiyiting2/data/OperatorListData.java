//package zhiyiting2.data;
//
//import org.testng.annotations.DataProvider;
//
//import zhiyiting2.test.operatorManagement.OperatorList;
//import zhiyiting2.test.workerManagement.WorkerList;
//
//public class OperatorListData {
//	public static String operatorName="自动化测试运营商";
//	public static String provinceId="450000";//广西
//	public static String cityId="450100";//南宁
//	@DataProvider(name = "maintainOperatorInfo")
//	public Object[][] maintainOperatorInfo() {
//	       return new Object[][]{
//	               {"增加运营商:",this.operatorName,this.provinceId,this.cityId,"","insert"},
//	               
//	       };
//	   }
//	
//	@DataProvider(name = "maintainOperatorRelWorkerInfo")
//	public Object[][] maintainOperatorRelWorkerInfo() {
//		int[] workerIds = new int[1];
//		workerIds[0]=WorkerList.loadWorkerId;
//	       return new Object[][]{
//	               {"施工人员绑定运营商:",workerIds,OperatorList.operatorId},
//	               
//	       };
//	   }
//}
