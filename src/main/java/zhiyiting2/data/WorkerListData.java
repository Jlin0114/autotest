package zhiyiting2.data;

import org.testng.annotations.DataProvider;

public class WorkerListData {
	public static String workerName="自动化";
	public static String workerMobile="18943940155";
	public static String workerPassword="123456";
	@DataProvider(name = "maintainWorkerInfo")
	public Object[][] maintainWorkerInfo() {
	       return new Object[][]{
	               {"增加施工人员:",this.workerName,this.workerMobile,this.workerPassword,"insert","8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"},
	               
	       };
	   }
}
