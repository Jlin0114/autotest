package zhiyiting2.test.parkingManagement.service;

import zhiyiting2.model.ResponseModel;

public interface ParkingService {
	public ResponseModel createNewWorkOrder(String testname, Integer placeId) throws Exception;

	public void createCleanWorkOrder(String testname, String placeCode, String remark, String cleanWorkOrderSubType)
			throws Exception;

	public void createReplaceWorkOrder(String testname, String placeCode, String remark) throws Exception;

	public void reviseBillMoney(String testname, Integer id, Double money, String reviseMoney, String reason)
			throws Exception;

	public void modifyPlateNoByRecord(String testname, Integer billRecordId, String plateNo) throws Exception;

	public void reviseInOutRecordTime(Integer billRecordId, String reviseInTime, String reviseOutTime) throws Exception;

	public void deviceEvidence(String testname, Integer billRecordId) throws Exception;

	public void manualHandleAudit(String plateNo, Boolean newEnergy, Boolean specialCar, String vehicleType,
			Integer auditId, String auditHandleType, String appShowImageFileId) throws Exception;

}
