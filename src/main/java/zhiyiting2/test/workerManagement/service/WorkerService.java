package zhiyiting2.test.workerManagement.service;

import zhiyiting2.model.ResponseModel;

public interface WorkerService {
	public ResponseModel maintainWorkerInfo(String testName,
			String name,String mobile,String pws,String type,String password) throws Exception ;
	
	public ResponseModel querySingleWorkOrderDetail(String testname, Integer workorderId) throws Exception;
	
	public void backfillConstructWorkOrderActivity(String testName,String activityId,
			String newDeviceNo,String loadWorkerId) throws Exception;

	
	
}
