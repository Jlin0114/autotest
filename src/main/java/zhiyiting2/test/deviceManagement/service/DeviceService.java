package zhiyiting2.test.deviceManagement.service;

import zhiyiting2.model.ResponseModel;

public interface DeviceService {
	public void reportIn(Integer deviceNo, String type, Integer devicePower, Integer deviceSignal, Long deviceTimestamp,
			Long serialId) throws Exception;

	public void uploadDeviceFile(Integer distance, Integer deviceSignal, Integer devicePower, Integer serialNo,
			Integer total, Integer deviceNo, Long serialId, Long deviceTimestamp) throws Exception;

	public void reportOut(Integer deviceNo, String type, Integer devicePower, Integer deviceSignal,
			boolean lowPowerMode, Long serialId, Long deviceTimestamp) throws Exception;

	public void uploadDeviceOutFile(String testname, Integer distance, Integer deviceSignal, Integer devicePower,
			Integer serialNo, Integer total, Integer deviceNo, Long serialId, Long deviceTimestamp) throws Exception;
	
	public void deviceEvidenceStatus(String deviceNo, String evidenceStatus, Long serialId, Long deviceTimestamp)
			throws Exception ;
	
	public void uploadDeviceEvidenceFile(Integer deviceNo, Long actualDateTime, Long serialId, Long deviceTimestamp)
			throws Exception ;
	
	public void deviceSelfTest(String testName, Integer deviceNo, Integer distance, Integer deviceSignal,
			Integer devicePower, String v, Integer v2, String m) throws Exception ;
	
	public ResponseModel uploadDeviceFile() throws Exception ;
	
	public ResponseModel importDeviceFile(String fileId) throws Exception;
	
	
	
}
