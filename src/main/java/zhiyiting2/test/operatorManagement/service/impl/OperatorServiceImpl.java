package zhiyiting2.test.operatorManagement.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.Reporter;

import net.sf.json.JSONObject;
import zhiyiting2.model.ResponseModel;
import zhiyiting2.test.CreatRoad;
import zhiyiting2.test.ManagerLogin;
import zhiyiting2.test.operatorManagement.service.OperatorService;
import zhiyiting2.util.Constant;
import zhiyiting2.util.URLConnection;
@Service
public class OperatorServiceImpl implements OperatorService{
	@Autowired
	URLConnection urlConnection;
	public ResponseModel maintainOperatorInfo(String name,String provinceId,String cityId,String districtId,String type) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("provinceId", provinceId);
		map.put("cityId", cityId);
		map.put("districtId", districtId);
		map.put("type", type);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("添加运营商");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(ManagerLogin.cookie, Constant.maintainOperatorInfo_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		return resp;
	}

	public ResponseModel insertOperatorInfo(String cityId, String districtId, String name, String operatorPlatform, Integer payeeAccountId, String provinceId, String[] pcas, String streetIds, String type) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("cityId",cityId);
		map.put("districtId",districtId);
		map.put("name",name);
		map.put("operatorPlatform",operatorPlatform);
		map.put("payeeAccountId",payeeAccountId.toString());
		map.put("provinceId",provinceId);
		map.put("provinceId",provinceId);
		map.put("pcas",pcas.toString());
		map.put("streetIds",streetIds);
		map.put("type",type);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("添加运营商");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(ManagerLogin.cookie, Constant.maintainOperatorInfo_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);

		return resp;
	}


	public void maintainOperatorRelWorkerInfo(int[] workerIds,Integer operatorId) throws Exception {
		Map map = new HashMap();
		map.put("id", operatorId);
		map.put("workerIds",workerIds);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("运营商绑定施工人员");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(ManagerLogin.cookie, Constant.maintainOperatorRelWorkerInfo_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
	
	
	
	
}
