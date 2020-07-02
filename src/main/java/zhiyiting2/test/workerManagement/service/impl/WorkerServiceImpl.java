package zhiyiting2.test.workerManagement.service.impl;

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
import zhiyiting2.test.workerManagement.service.WorkerService;
import zhiyiting2.util.Constant;
import zhiyiting2.util.URLConnection;

@Service
public class WorkerServiceImpl implements WorkerService{
	@Autowired
	URLConnection urlConnection;
	public ResponseModel maintainWorkerInfo(String name,String mobile,String pws,String type,String password) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("mobile",mobile);
		map.put("pws",pws);
		map.put("type", type);
		map.put("password",password);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("添加施工人员");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(ManagerLogin.cookie, Constant.WorkingListConstant.maintainWorkerInfo_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}
	
	//工单列表查看详情   获取到回填需要的工单activityId
	public ResponseModel querySingleWorkOrderDetail(Integer workorderId) throws Exception {
		Map map = new HashMap();
		map.put("id", workorderId);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(ManagerLogin.cookie, Constant.querySingleWorkOrderDetail_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
		return resp;
	}
	
	//回填
	public void backfillConstructWorkOrderActivity(String activityId,String newDeviceNo,String loadWorkerId) throws Exception {
		Map map = new HashMap();
		map.put("activityId", activityId);
		map.put("newDeviceNo", newDeviceNo);
		map.put("workerId", loadWorkerId);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("工单回填");
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = urlConnection.doPost(ManagerLogin.cookie, Constant.backfillConstructWorkOrderActivity_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = urlConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");

	}
	
	
	
	
	
}
