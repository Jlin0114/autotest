package zhiyiting2.test.parkingManagement.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.Reporter;

import net.sf.json.JSONObject;
import zhiyiting2.model.ResponseModel;
import zhiyiting2.test.CreatRoad;
import zhiyiting2.test.parkingManagement.service.ParkingService;
import zhiyiting2.util.Constant;
import zhiyiting2.util.URLConnection;
@Service
public class ParkingServiceImpl implements ParkingService{
	@Autowired
	URLConnection urlConnection;
	
	public ResponseModel createNewWorkOrder(Integer placeId) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("parkingPlaceId", placeId);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("派发工单");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingListConstant.createNewWorkOrder_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}
	
	public void createCleanWorkOrder(String placeCode,String remark,String cleanWorkOrderSubType) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("placeCode", placeCode);
		map.put("remark", remark);
		map.put("cleanWorkOrderSubType", cleanWorkOrderSubType);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingListConstant.createCleanWorkOrder_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
	public void createReplaceWorkOrder( String placeCode,String remark) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("placeCode", placeCode);
		map.put("remark", remark);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingListConstant.createReplaceWorkOrder_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
	
	// 车位列表----停车记录--调账
	public void reviseBillMoney( Integer id, Double money, String reviseMoney, String reason)
			throws Exception {
			Map map = new HashMap();
			map.put("id", id);// 账单ID
			map.put("money", money);// 原金额
			map.put("reviseMoney", reviseMoney);// 修改后的金额
			map.put("reason", reason);
			JSONObject jsonObject = JSONObject.fromObject(map);
			Reporter.log("请求参数:" + jsonObject.toString());
			String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingListConstant.reviseBillMoney_Url, jsonObject.toString());
			Reporter.log("返回参数:" + result);
			ResponseModel resp = new ResponseModel();
			resp = urlConnection.getResponseModel(result);
			Assert.assertEquals(resp.getMessage(), "OK");
			Assert.assertEquals(resp.getCode(), "0");

	}

	// 车位列表----停车记录--修改车牌
	public void modifyPlateNoByRecord(Integer billRecordId, String plateNo) throws Exception {
		Map map = new HashMap();
		map.put("billRecordId", billRecordId);// 账单ID
		map.put("plateNo", plateNo);// 车牌
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingListConstant.modifyPlateNoByRecord_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	// 车位列表----停车记录--调整出入库时间
	public void reviseInOutRecordTime(Integer billRecordId, String reviseInTime,String reviseOutTime) throws Exception {
		Map map = new HashMap();
		map.put("billRecordId", billRecordId);// 账单ID
		map.put("reviseInTime", reviseInTime);// 入库时间
		map.put("reviseOutTime", reviseOutTime);//出库时间
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("调整出入库时间");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingListConstant.reviseInOutRecordTime_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
	public void deviceEvidence( Integer billRecordId) throws Exception {
		Map map = new HashMap();
		map.put("billRecordId", billRecordId);// 账单ID
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingListConstant.deviceEvidence_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
	
	public void manualHandleAudit(String plateNo,Boolean newEnergy,
			Boolean specialCar,String vehicleType,Integer auditId,String auditHandleType,String appShowImageFileId) throws Exception {
		Map map = new HashMap();
		map.put("plateNo", plateNo);
		map.put("newEnergy", newEnergy);
		map.put("specialCar", specialCar);
		map.put("vehicleType", vehicleType);
		map.put("auditId", auditId);
		map.put("appShowImageFileId", appShowImageFileId);
		map.put("auditHandleType", auditHandleType);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("出入库审核");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ParkingListConstant.manualHandleAudit_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
}
