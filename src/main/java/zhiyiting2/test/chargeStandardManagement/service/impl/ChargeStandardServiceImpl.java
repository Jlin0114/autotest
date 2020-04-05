package zhiyiting2.test.chargeStandardManagement.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.Reporter;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import zhiyiting2.model.MarketingPlan;
import zhiyiting2.model.ResponseModel;
import zhiyiting2.test.CreatRoad;
import zhiyiting2.test.chargeStandardManagement.service.ChargeStandardService;
import zhiyiting2.util.Constant;
import zhiyiting2.util.JsonDateValueProcessor;
import zhiyiting2.util.URLConnection;
@Service
public class ChargeStandardServiceImpl implements ChargeStandardService{
	@Autowired
	URLConnection urlConnection;
	
	public ResponseModel addMarketingPlan(MarketingPlan mp) throws Exception {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		JSONObject jsonObject = JSONObject.fromObject(mp,jsonConfig);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.DiscountsChargeStandard.addMarketingPlan_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}
	
	
	public void editMarketingPlan(MarketingPlan mp) throws Exception {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		JSONObject jsonObject = JSONObject.fromObject(mp,jsonConfig);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.DiscountsChargeStandard.editMarketingPlan_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
	}
	
	public void deleteMarketingPlanById(Integer marketingPlanId,String type) throws Exception {
		Map map = new HashMap();
		map.put("id", marketingPlanId);
		map.put("type", type);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.DiscountsChargeStandard.deleteMarketingPlanById_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
	
	public ResponseModel addChargeStandardMultipleInfo( Integer provinceId,Integer cityId,
			String chargeStandardName,String areaType,
			Integer chargeSort,Integer newEnergyDiscount,Boolean distNotWorkDay,Boolean distVehicleType,
			Object[] dayChargeStandardList) throws Exception {
		Map map = new HashMap();
		map.put("provinceId",provinceId );
		map.put("cityId", cityId);
		map.put("chargeStandardName", chargeStandardName);
		map.put("areaType",areaType );
		map.put("chargeSort", chargeSort);
		map.put("newEnergyDiscount", newEnergyDiscount);
		map.put("distNotWorkDay",distNotWorkDay );
		map.put("distVehicleType",distVehicleType );
		map.put("dayChargeStandardList", dayChargeStandardList);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ChargeStandardConstant.addChargeStandardMultipleInfo_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;

	}
	public ResponseModel addPeriodRuleItem(Integer operatorId, Integer cityId, int[] parkingRoadIds,
			Boolean supportMutual, Double price, Integer month, Boolean enable, Integer containParkingLot,
			Integer containParkingRoad) throws Exception {
		Map map = new HashMap();
		map.put("operatorId", operatorId);
		map.put("cityId", cityId);
		map.put("parkingRoadIds", parkingRoadIds);
		map.put("supportMutual", supportMutual);
		map.put("price", price);
		map.put("month", month);
		map.put("enable", enable);
		map.put("containParkingLot", containParkingLot);
		map.put("containParkingRoad", containParkingRoad);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.ChargeStandardConstant.addPeriodRuleItem_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}
	
	
	
}
