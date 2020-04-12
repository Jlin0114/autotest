package zhiyiting2.test.parkingManagement.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import zhiyiting2.data.SpecialVehicleData;
import zhiyiting2.model.ResponseModel;
import zhiyiting2.test.CreatRoad;
import zhiyiting2.test.ZTest;
import zhiyiting2.test.parkingManagement.service.SpecialVehicleService;
import zhiyiting2.util.Constant;
import zhiyiting2.util.JsonDateValueProcessor;
import zhiyiting2.util.URLConnection;

/**
 * 路边免费车辆
 * @author zhaoming
 *
 */
@Service
public class SpecialVehicleServiceImpl implements SpecialVehicleService{
	@Autowired
	URLConnection urlConnection;
	public static Integer specialCarId;
	@Test(testName = "addSpecialCar", description = "新增路边免费车辆", dataProvider = "addSpecialCar", dataProviderClass = SpecialVehicleData.class)
	public ResponseModel addSpecialCar(String plateNo,int isEnable,Date validStart,Date validEnd) throws Exception {
		Map map = new HashMap();
		map.put("plateNo", plateNo);
		map.put("isEnable", isEnable);
		map.put("validStart", validStart);
		map.put("validEnd", validEnd);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		JSONObject jsonObject = JSONObject.fromObject(map,jsonConfig);
		Reporter.log("新增路边免费车辆");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.SpecialVehicleConstant.addSpecialCar_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}
	@Test(testName = "updateSpecialCar", description = "编辑路边免费车辆", dataProvider = "updateSpecialCar", dataProviderClass = SpecialVehicleData.class)
	public void updateSpecialCar(int id,String plateNo,int isEnable,Date validStart,Date validEnd) throws Exception {
		Map map = new HashMap();
		map.put("id", id);
		map.put("plateNo", plateNo);
		map.put("isEnable", isEnable);
		map.put("validStart", validStart);
		map.put("validEnd", validEnd);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		JSONObject jsonObject = JSONObject.fromObject(map,jsonConfig);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.SpecialVehicleConstant.updateSpecialCar_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
	}
	@Test(testName = "deleteSpecialCar", description = "删除路边免费车辆", dataProvider = "deleteSpecialCar", dataProviderClass = SpecialVehicleData.class)
	public void deleteSpecialCar(Integer id) throws Exception {
		Map map = new HashMap();
		map.put("id", id);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(CreatRoad.cookie, Constant.SpecialVehicleConstant.deleteSpecialCar_Url,
				jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
	}
}
