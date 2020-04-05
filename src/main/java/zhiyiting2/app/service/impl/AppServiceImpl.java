package zhiyiting2.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
import zhiyiting2.app.AppData;
import zhiyiting2.app.AppTest;
import zhiyiting2.app.Constant;
import zhiyiting2.app.service.AppService;
import zhiyiting2.model.ResponseModel;
import zhiyiting2.model.SqlModel;
import zhiyiting2.util.JDBCConnection;
import zhiyiting2.util.URLConnection;

@Service
public class AppServiceImpl implements AppService {
	@Autowired
	URLConnection uRLConnection;

	public ResponseModel bindCar(String plateNo) throws Exception {
		Map map = new HashMap();
		map.put("plateNo", plateNo);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("绑定车辆");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPost(AppTest.cookie, Constant.bindCar_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		return resp;
	}

	public ResponseModel unbindCar(String plateNo) throws Exception {
		Map map = new HashMap();
		map.put("plateNo", plateNo);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("车辆解绑");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPost(AppTest.cookie, Constant.unbindCar_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		return resp;

	}

	public void payBill(int[] billIds, Double totalMoney, Double walletPayMoney) throws Exception {
		Map map = new HashMap();
		map.put("billIds", billIds);
		map.put("totalMoney", totalMoney);
		map.put("walletPayMoney", walletPayMoney);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("支付");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPost(AppTest.cookie, Constant.payBill_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "支付成功");
		Assert.assertEquals(resp.getCode(), "0");
	}

	public Integer uploadFileNew() throws Exception {
		Map map = new HashMap();
		map.put("type", "driver_license_front_file");
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("file", "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p2.jpg");
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("绑定行驶证上传图片");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPostForm(null, Constant.uploadFileNew_Url, map, fileMap);
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		Integer fileId = Integer.valueOf(resp.getFileId());
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return fileId;
	}

	public void bindApply(String plateNo, String vehicleLicenseNo) throws Exception {
		Integer fileId = this.uploadFileNew();
		Map map = new HashMap();
		map.put("plateNo", plateNo);
		map.put("vehicleLicenseFileId", fileId);
		map.put("vehicleLicenseNo", vehicleLicenseNo);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("绑定行驶证提交");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPost(AppTest.cookie, Constant.bindApply_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}

	public String myUserOrder(String bindOrderType, Integer currPage, Integer pageSize, String type) throws Exception {
		Map map = new HashMap();
		map.put("bindOrderType", bindOrderType);
		map.put("currPage", currPage);
		map.put("pageSize", pageSize);
		map.put("type", type);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPost(AppTest.cookie, Constant.myUserOrder_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		Assert.assertEquals(resp.getCode(), "0");
		return result;
	}

	public ResponseModel sendVerifyCode(String mobile) throws Exception {
		Map map = new HashMap();
		map.put("mobile", mobile);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPost(null, Constant.sendVerifyCode_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}

	public ResponseModel appRegister(String mobile, String password, String uuid, String verifyCode) throws Exception {
		Map map = new HashMap();
		map.put("mobile", mobile);
		map.put("password", password);
		map.put("uuid", uuid);
		map.put("verifyCode", verifyCode);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPost(null, Constant.app_register_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}

	// 办理路段包月
	public void walletToMonthPurchase(Integer carId, Integer count, Integer operatorPeriodRuleId, Integer parkingRoadId,
			String parkingType) throws Exception {
		Map map = new HashMap();
		map.put("carId", carId);
		map.put("count", count);
		map.put("operatorPeriodRuleId", operatorPeriodRuleId);
		map.put("parkingRoadId", parkingRoadId);
		map.put("parkingType", parkingType);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPost(AppTest.cookie, Constant.walletToMonthPurchase_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
	
		// 查询优惠券列表
		public String loadUserCouponList(Integer flag) throws Exception {
			Map map = new HashMap();
			map.put("flag", flag);
			JSONObject jsonObject = JSONObject.fromObject(map);
			Reporter.log("请求参数:" + jsonObject.toString());
			String result = uRLConnection.doPost(AppTest.cookie, Constant.loadUserCouponList_Url, jsonObject.toString());
			Reporter.log("返回参数:" + result);
			ResponseModel resp = new ResponseModel();
			resp = uRLConnection.getResponseModel(result);
			Assert.assertEquals(resp.getCode(), "0");
			return result;
		}
	
		// 我的车辆列表
		public void myCar() throws Exception {
			Map map = new HashMap();
			JSONObject jsonObject = JSONObject.fromObject(map);
			Reporter.log("请求参数:" + jsonObject.toString());
			String result = uRLConnection.doPost(AppTest.cookie, Constant.myCar_Url, jsonObject.toString());
			Reporter.log("返回参数:" + result);
			ResponseModel resp = new ResponseModel();
			resp = uRLConnection.getResponseModel(result);
			Assert.assertEquals(resp.getMessage(), "OK");
			Assert.assertEquals(resp.getCode(), "0");

		}
		// 账单申诉
		public void appealBill(String appealDescription, int billId, String contactMobile)
				throws Exception {
			Map map = new HashMap();
			map.put("appealDescription", appealDescription);
			map.put("billId", billId);
			map.put("contactMobile", contactMobile);
			JSONObject jsonObject = JSONObject.fromObject(map);
			Reporter.log("请求参数" + jsonObject.toString());
			ResponseModel resp = new ResponseModel();
			String result = uRLConnection.doPost(AppTest.cookie, Constant.appealBill_Url, jsonObject.toString());
			Reporter.log("返回参数" + result);
			resp = uRLConnection.getResponseModel(result);
			Assert.assertEquals(resp.getMessage(), "OK");
			Assert.assertEquals(resp.getCode(), "0");
		}
	// 退出登录
	public void logOut() throws Exception {
		Map map = new HashMap();
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		ResponseModel resp = new ResponseModel();
		String result = uRLConnection.doPost(AppTest.cookie, Constant.logOut_Url, jsonObject.toString());
		Reporter.log("返回参数" + result);
		resp = uRLConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
	}
	
}
