package zhiyiting2.test.parkingManagement.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
import zhiyiting2.model.ResponseModel;
import zhiyiting2.test.CreatRoad;
import zhiyiting2.test.parkingManagement.service.ParkingRoadService;
import zhiyiting2.util.Constant;
import zhiyiting2.util.URLConnection;

@Service
public class ParkingRoadServiceImpl implements ParkingRoadService {
	@Autowired
	URLConnection urlConnection;
	
	// 添加路段
	public ResponseModel creatRoad(String longitude, String latitude, String roadName, String regionId,
			String chargeStandardId, String recognizeConfig, String watermarkConfig) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("longitude", longitude);
		map.put("latitude", latitude);
		map.put("roadName", roadName);
		map.put("regionId", regionId);
		map.put("chargeStandardId", chargeStandardId);
		map.put("recognizeConfig", recognizeConfig);
		map.put("watermarkConfig", watermarkConfig);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("添加路段");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.addLoadUrl, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		return resp;
	}

	// 路段上线
	public void batchChangeParkingRoadStatus(int[] roadIds, String status) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roadIds", roadIds);
		map.put("status", status);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.batchChangeParkingRoadStatus_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	// 修改路段运营状态
	public void batchUpdateParkRoadOperationStatus(Integer roadId, String operationStatus)
			throws Exception {
		Map<String, Comparable> map = new HashMap<String, Comparable>();
		map.put("roadId", roadId);
		map.put("operationStatus", operationStatus);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie,
				Constant.ParkingRoadConstant.batchUpdateParkRoadOperationStatus_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	// 车位开启出入库审核
	public void auditParkPlaceOut( int[] ids, String enableOutAudit) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		map.put("enableOutAudit", enableOutAudit);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("车位开启出入库审核");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingRoadConstant.auditParkPlaceOut_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	public void batchOutAuditByParkingRoadCodes(int[] roadCodes, String enableOutAudit)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roadCodes", roadCodes);
		map.put("enableOutAudit", enableOutAudit);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie,
				Constant.ParkingRoadConstant.batchOutAuditByParkingRoadCodes_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	// 车位上下线
	public void batchAuditParkPlace(int[] ids, String status) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		map.put("status", status);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.batchAuditParkPlace_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	public void deviceConfig(String deviceNo, Integer mode, Boolean enableLog, Boolean enableWork,
			Boolean ledOnOff, Integer selfTestMinutes, Integer evidenceMinutes, Integer rainMinutes,
			Boolean enableSelfTestNotify, Boolean enableLowPowerNotify, String deviceVersion, String deviceNewVersion,
			String deviceMCUVersion, String deviceMCUNewVersion, String deviceDistance) throws Exception {
		Map<String, Comparable> map = new HashMap<String, Comparable>();
		map.put("deviceNo", deviceNo);
		map.put("mode", mode);
		map.put("enableLog", enableLog);
		map.put("enableWork", enableWork);
		map.put("ledOnOff", ledOnOff);
		map.put("selfTestMinutes", selfTestMinutes);
		map.put("evidenceMinutes", evidenceMinutes);
		map.put("rainMinutes", rainMinutes);
		map.put("enableSelfTestNotify", enableSelfTestNotify);
		map.put("enableLowPowerNotify", enableLowPowerNotify);
		map.put("deviceVersion", deviceVersion);
		map.put("deviceNewVersion", deviceNewVersion);
		map.put("deviceMCUVersion", deviceMCUVersion);
		map.put("deviceMCUNewVersion", deviceMCUNewVersion);
		map.put("deviceDistance", deviceDistance);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingRoadConstant.deviceConfig_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

//		//编辑路段提交
//		@Test(priority = 2, testName = "updateParkRoad", dataProvider = "updateParkRoad", dataProviderClass = ParkingRoadData.class)
//		public void creatRoad(String testname,Integer id,Integer regionId, int[] pcas,String longitude,String latitude,
//				String recognizeConfig,String watermarkConfig,String roadName,String lowpowerStartTime,
//				String lowpowerEndTime,Integer chargeStandardId) {
//			URLConnection conn = new URLConnection();
//			Map map = new HashMap();
//			map.put("id", id);
//			map.put("regionId", regionId);
//			map.put("pcas", pcas);
//			map.put("longitude", longitude);
//			map.put("latitude", latitude);
//			map.put("recognizeConfig", recognizeConfig);
//			map.put("watermarkConfig", watermarkConfig);
//			map.put("roadName", roadName);
//			map.put("lowpowerStartTime", lowpowerStartTime);
//			map.put("lowpowerEndTime", lowpowerEndTime);
//			map.put("chargeStandardId", chargeStandardId);
//			JSONObject jsonObject = JSONObject.fromObject(map);
//			Reporter.log("请求参数:" + jsonObject.toString());
//			ResponseModel resp = new ResponseModel();
//			try {
//				resp = conn.doPost(CreatRoad.cookie, Constant.ParkingRoadConstant.updateParkRoad_Url, jsonObject.toString());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			Assert.assertEquals(resp.getMessage(), "OK");
//		}

	public ResponseModel addParkPlaces(Integer parkingRoadId, String longitude, String latitude, String gradNo,
			String gridNo) throws Exception {
		Map<String, Comparable> map = new HashMap<String, Comparable>();
		map.put("parkingRoadId", parkingRoadId);
		map.put("longitude", longitude);
		map.put("latitude", latitude);
		map.put("gradNo", gradNo);
		map.put("gridNo", gridNo);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("添加车位");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.addParkPlace_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}

	// 路段绑定施工人员
	public void batchBindParkingRoadAndWorker(Object[] workerInfos, int parkingRoadIds[])
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("workerInfos", workerInfos);
		map.put("parkingRoadIds", parkingRoadIds);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("路段绑定施工人员");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.batchBindParkingRoadAndWorker_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
}
