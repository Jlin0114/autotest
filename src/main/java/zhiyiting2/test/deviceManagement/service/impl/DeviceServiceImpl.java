package zhiyiting2.test.deviceManagement.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
import zhiyiting2.model.ResponseModel;
import zhiyiting2.test.deviceManagement.service.DeviceService;
import zhiyiting2.util.Constant;
import zhiyiting2.util.Log4jDemo;
import zhiyiting2.util.URLConnection;

@Service
public class DeviceServiceImpl implements DeviceService {
	static Logger logger = Logger.getLogger(DeviceServiceImpl.class);
	@Autowired
	URLConnection urlConnection;

	public ResponseModel reportIn(String deviceNo, String type, Integer devicePower, Integer deviceSignal, Long deviceTimestamp,
			Long serialId) throws Exception {
		Thread.sleep(2000);
		Map map = new HashMap();
		map.put("deviceNo", deviceNo);
		map.put("type", type);
		map.put("devicePower", devicePower);
		map.put("deviceSignal", deviceSignal);
		map.put("deviceTimestamp", deviceTimestamp);
		map.put("serialId", serialId);
		JSONObject jsonObject = JSONObject.fromObject(map);
		logger.info("设备入库  req:"+jsonObject.toString());
		String result = urlConnection.doPost(null, Constant.ParkingListConstant.reportIn_Url, jsonObject.toString());
		logger.info("设备入库  resp:"+result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		return resp;
	}

	// 设备入库上传图片
	public ResponseModel uploadDeviceFile(Integer distance, Integer deviceSignal, Integer devicePower, Integer serialNo,
			Integer total, String deviceNo, Long serialId, Long deviceTimestamp,Integer evidence,String fileUrl) throws Exception {
		Thread.sleep(2000);
		Map map = new HashMap();
		map.put("distance", 35);
		map.put("deviceSignal", 20);
		map.put("devicePower", 61);
		map.put("serialNo", 1);
		map.put("total", 8);
		map.put("deviceNo", deviceNo);
		map.put("serialId", serialId);
		map.put("deviceTimestamp", deviceTimestamp);
		if (evidence == 1) {
			map.put("evidence",evidence);
		}
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("file", fileUrl);
		JSONObject jsonObject = JSONObject.fromObject(map);
		logger.info("req:" + jsonObject.toString());
		String result = urlConnection.doPostForm(null, Constant.ParkingListConstant.uploadDeviceFile_Url, map, fileMap);
		logger.info("resp:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}
	//导入设备
	public ResponseModel uploadDeviceFile() throws Exception {
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("file", "C:\\Users\\Administrator\\Desktop\\in.txt");
		logger.info("导入设备号");
		String result = urlConnection.doPostForm(null, Constant.ParkingListConstant.uploadDeviceFile_Url, null, fileMap);
		logger.info("resp:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}
	
	
	
	
	// 设备出库
	public void reportOut(String deviceNo, String type, Integer devicePower, Integer deviceSignal,
			boolean lowPowerMode, Long serialId, Long deviceTimestamp) throws Exception {
		Thread.sleep(2000);
		Map map = new HashMap();
		map.put("deviceNo", deviceNo);
		map.put("type", type);
		map.put("devicePower", devicePower);
		map.put("deviceSignal", deviceSignal);
		map.put("lowPowerMode", lowPowerMode);
		map.put("serialId", serialId);
		map.put("deviceTimestamp", deviceTimestamp);
		JSONObject jsonObject = JSONObject.fromObject(map);
		logger.info("req:" + jsonObject.toString());
		String result = urlConnection.doPost(null, Constant.ParkingListConstant.reportOut_Url, jsonObject.toString());
		logger.info("resp:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	// 设备出库上传图片
	public void uploadDeviceOutFile(Integer distance, Integer deviceSignal, Integer devicePower,
			Integer total, String deviceNo, Long serialId, Long deviceTimestamp,String evidence,String fileUrl) throws Exception {
		Map map = new HashMap();
		map.put("distance", distance);
		map.put("deviceSignal", deviceSignal);
		map.put("devicePower", devicePower);
		map.put("total", total);
		map.put("evidence", evidence);
		map.put("deviceNo", deviceNo);
		map.put("serialId", serialId);
		map.put("deviceTimestamp", deviceTimestamp);
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("file", fileUrl);
		JSONObject jsonObject = JSONObject.fromObject(map);
		logger.info("req:" + jsonObject.toString());
		String result = urlConnection.doPostForm(null, Constant.ParkingListConstant.uploadDeviceOutFile_Url, map,
				fileMap);
		logger.info("resp:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	// 设备取证
	public void deviceEvidenceStatus(String deviceNo, String evidenceStatus, Long serialId, Long deviceTimestamp)
			throws Exception {
		Map map = new HashMap();
		map.put("deviceNo", deviceNo);
		map.put("evidenceStatus", evidenceStatus);
		map.put("serialId", serialId);
		map.put("deviceTimestamp", deviceTimestamp);
		JSONObject jsonObject = JSONObject.fromObject(map);
		logger.info("req:" + jsonObject.toString());
		String result = urlConnection.doPost(null, Constant.ParkingListConstant.deviceEvidenceStatus_Url,
				jsonObject.toString());
		logger.info("resp:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	// 设备取证上传图片
	public void uploadDeviceEvidenceFile(String deviceNo, Long actualDateTime, Long serialId, Long deviceTimestamp)
			throws Exception {
		Map map = new HashMap();
		map.put("deviceNo", deviceNo);
		map.put("actualDateTime", actualDateTime);
		map.put("serialId", serialId);
		map.put("deviceTimestamp", deviceTimestamp);
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("file", "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p3.jpg");
		JSONObject jsonObject = JSONObject.fromObject(map);
		logger.info("req:" + jsonObject.toString());
		String result = urlConnection.doPostForm(null, Constant.ParkingListConstant.uploadDeviceEvidenceFile_Url, map,
				fileMap);
		logger.info("resp:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	// 设备自检
	public void deviceSelfTest(String deviceNo, Integer distance, Integer deviceSignal,
			Integer devicePower, String v, Integer v2, String m) throws Exception {
		Map map = new HashMap();
		map.put("deviceNo", deviceNo);
		map.put("distance", distance);
		map.put("deviceSignal", deviceSignal);
		map.put("devicePower", devicePower);
		map.put("v", v);
		map.put("v2", v2);
		map.put("m", m);
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("file", "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p3.jpg");
		JSONObject jsonObject = JSONObject.fromObject(map);
		logger.info("req:" + jsonObject.toString());
		String result = urlConnection.doPostForm(null, Constant.ParkingListConstant.deviceSelfTest_Url, map, fileMap);
		logger.info("resp:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
	
	public ResponseModel importDeviceFile(String fileId) throws Exception{
		Map map = new HashMap();
		map.put("fileId", fileId);
		JSONObject jsonObject = JSONObject.fromObject(map);
		logger.info("req:" + jsonObject.toString());
		String result = urlConnection.doPost(null, Constant.ParkingListConstant.importDeviceFile_Url,
				jsonObject.toString());
		logger.info("resp:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}
	
	public  void uploadDevicePeriodModeFile(String deviceNo,String dateTime,Long serialId, Long deviceTimestamp,
			String fileUrl) throws Exception{
		Map map = new HashMap();
		map.put("deviceNo", deviceNo);
		map.put("dateTime", dateTime);
		map.put("serialId", serialId);
		map.put("deviceTimestamp", deviceTimestamp);
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("file",fileUrl);
		JSONObject jsonObject = JSONObject.fromObject(map);
		logger.info("req:" + jsonObject.toString());
		String result = urlConnection.doPostForm(null, Constant.ParkingListConstant.uploadDevicePeriodModeFile_Url, map, fileMap);
		logger.info("resp:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
	}
	

}
