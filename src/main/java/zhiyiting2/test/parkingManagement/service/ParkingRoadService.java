package zhiyiting2.test.parkingManagement.service;

import zhiyiting2.model.ResponseModel;

public interface ParkingRoadService {
	public ResponseModel creatRoad(String longitude, String latitude, String roadName, String regionId,
			String chargeStandardId, String recognizeConfig, String watermarkConfig) throws Exception;

	public void batchChangeParkingRoadStatus(int[] roadIds, String status) throws Exception;

	public void batchUpdateParkRoadOperationStatus(Integer roadId, String operationStatus)
			throws Exception;

	public void auditParkPlaceOut(int[] ids, String enableOutAudit) throws Exception;
	
	public void batchOutAuditByParkingRoadCodes(int[] roadCodes, String enableOutAudit)
			throws Exception;
	public void batchAuditParkPlace(int[] ids, String status) throws Exception ;
	public void deviceConfig(String deviceNo, Integer mode, Boolean enableLog, Boolean enableWork,
			Boolean ledOnOff, Integer selfTestMinutes, Integer evidenceMinutes, Integer rainMinutes,
			Boolean enableSelfTestNotify, Boolean enableLowPowerNotify, String deviceVersion, String deviceNewVersion,
			String deviceMCUVersion, String deviceMCUNewVersion, String deviceDistance) throws Exception;
	
	public ResponseModel addParkPlaces(Integer parkingRoadId, String longitude, String latitude, String gradNo,
			String gridNo) throws Exception;
	
	public void batchBindParkingRoadAndWorker( Object[] workerInfos, int parkingRoadIds[])
			throws Exception;
	
	
	
	
	
}
