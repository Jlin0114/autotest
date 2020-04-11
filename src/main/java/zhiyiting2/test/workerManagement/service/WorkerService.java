package zhiyiting2.test.workerManagement.service;

import zhiyiting2.model.ResponseModel;

public interface WorkerService {
	public ResponseModel maintainWorkerInfo(
			String name,String mobile,String pws,String type,String password) throws Exception ;
	
	public ResponseModel querySingleWorkOrderDetail(Integer workorderId) throws Exception;
	
	public void backfillConstructWorkOrderActivity(String activityId,
			String newDeviceNo,String loadWorkerId) throws Exception;

	
	
}
