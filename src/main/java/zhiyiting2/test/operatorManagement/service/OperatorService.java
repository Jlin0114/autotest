package zhiyiting2.test.operatorManagement.service;

import zhiyiting2.model.ResponseModel;

public interface OperatorService {
	public ResponseModel maintainOperatorInfo(String name,
					String provinceId,String cityId,String districtId,String type) throws Exception ;
	public void maintainOperatorRelWorkerInfo(int[] workerIds,Integer operatorId) throws Exception ;


}
