package zhiyiting2.test.operatorManagement.service;

import zhiyiting2.model.ResponseModel;

public interface OperatorService {
	public ResponseModel maintainOperatorInfo(String name,
					String provinceId,String cityId,String districtId,String type) throws Exception ;

	public  ResponseModel insertOperatorInfo(String cityId,String districtId,String name,String operatorPlatform,
											Integer payeeAccountId,String provinceId,String[] pcas,
											 String streetIds,String  type) throws Exception;
	public void maintainOperatorRelWorkerInfo(int[] workerIds,Integer operatorId) throws Exception ;


}
