package zhiyiting2.test.deviceManagement.service;

import zhiyiting2.model.ResponseModel;

public interface DeviceService {
	public ResponseModel reportIn(String deviceNo, String type, Integer devicePower, Integer deviceSignal, Long deviceTimestamp,
			Long serialId) throws Exception;

	public ResponseModel uploadDeviceFile(Integer distance, Integer deviceSignal, Integer devicePower, Integer serialNo,
			Integer total, String deviceNo, Long serialId, Long deviceTimestamp,String fileUrl) throws Exception;

	public void reportOut(String deviceNo, String type, Integer devicePower, Integer deviceSignal,
			boolean lowPowerMode, Long serialId, Long deviceTimestamp) throws Exception;

	public void uploadDeviceOutFile(Integer distance, Integer deviceSignal, Integer devicePower,
			Integer total, String deviceNo, Long serialId, Long deviceTimestamp,String evidence
			,String fileUrl) throws Exception;
	
	public void deviceEvidenceStatus(String deviceNo, String evidenceStatus, Long serialId, Long deviceTimestamp)
			throws Exception ;
	
	public void uploadDeviceEvidenceFile(String deviceNo, Long actualDateTime, Long serialId, Long deviceTimestamp)
			throws Exception ;
	
	public void deviceSelfTest( String deviceNo, Integer distance, Integer deviceSignal,
			Integer devicePower, String v, Integer v2, String m) throws Exception ;
	
	public ResponseModel uploadDeviceFile() throws Exception ;
	
	public ResponseModel importDeviceFile(String fileId) throws Exception;
	
	public void uploadDevicePeriodModeFile(String deviceNo,String dateTime,Long serialId, 
			Long deviceTimestamp,
			String fileUrl) throws Exception;
	
}
