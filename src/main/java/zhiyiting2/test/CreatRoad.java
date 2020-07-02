package zhiyiting2.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
import zhiyiting2.util.Constant;
import zhiyiting2.util.ParameterData;
import zhiyiting2.util.URLConnection;

/**
 * 添加路段
 * 
 * @author zhaoming
 *
 */

@Component
public class CreatRoad {

	
	 
	
	
//	@Test(testName="deleteTestData")
//	public void deleteTestData() throws Exception{
//		Thread.sleep(10000);
//		JDBCConnection jdbc = new JDBCConnection();
//		String[] str = new String[10];
//		String sql = "DELETE parkingroad,parkingplace,workorder from  parking_road parkingroad left join parking_place parkingplace\r\n"
//				+ "on parkingroad.id=parkingplace.road_id left join work_order workorder on  workorder.parking_place_id=parkingplace.id "
//				+ "      where parkingroad.id="
//				+ ParkingRoad.roadId;
//		String sql1 = "delete w from worker w where w.name='自动化'";//删除新增施工人员
//		String sql2 = "delete o from operator o where o.name='自动化测试运营商'";//删除新增运营商
//		String sql3 = "delete o from charge_standard o where o.id='"+MaintainChargeStandard.chargeStandardId+"'";
//		String sql4 = "delete o from operator_period_rule o where o.id='"+MonthlyChargeStandard.operatorPeriodRuleId+"'";
//		String sql5 = "delete b,r from bill b left join bill_record r on b.id=r.bill_id where b.id='"+ParkingList.billId+"'";
//		String sql6 = "delete v from verify_code v where v.uuid='"+AppTest.uuid+"'";
//		String sql7 = "delete u from user u where u.mobile='"+AppData.mobile+"'";
//		String sql8 = "delete uw from user_wallet uw where uw.user_id='"+AppTest.userId+"'";
//		String sql9 = "delete c from car c where c.plate_no='"+AppData.plateNo+"'";
//		str[0]=sql;
//		str[1]=sql1;
//		str[2]=sql2;
//		str[3]=sql3;
//		str[4]=sql4;
//		str[5]=sql5;
//		str[6]=sql6;
//		str[7]=sql7;
//		str[8]=sql8;
//		str[9]=sql9;
//		jdbc.mysqlConnection("", str);
//	}
	


	

//	@Test(priority = 3, testName = "getRoadList", description = "获取路段管理列表")
//	public void getRoadList() throws Exception {
//		URLConnection conn = new URLConnection();
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("currPage", "1");
//		map.put("pageSize", "20");
//		map.put("status", "0");
//		map.put("roadName", "自动化测试1");
//
//		JSONObject jsonObject = JSONObject.fromObject(map);
//		Reporter.log("请求参数:" + jsonObject.toString());
//		ResponseModel resp = new ResponseModel();
//		resp = conn.doPost(CreatRoad.cookie, Constant.getRoadListUrl, jsonObject.toString());
//		List<Map> list = resp.getList();
//		for (Map m : list) {
//			if (m.containsKey("id")) {
//				roadId = (Integer) m.get("id");
//			}
//		}
//		Assert.assertEquals(resp.getMessage(), "OK");
//		Assert.assertEquals(resp.getCode(), "0");
//
//	}

	


//	[{"parkingRoadId":15,"longitude":"113.9299854300157","latitude":"22.52091618113091","gradNo":"5","gridNo":"5"}]

//	@Test(priority = 6, testName = "loadParkingPlace", description = "获取车位列表")
//	public void loadParkingPlace() throws Exception {
//		URLConnection conn = new URLConnection();
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("roadCode", roadId.toString());
//		map.put("currPage", "1");
//		map.put("pageSize", "20");
//		map.put("gradNo", "1");
//		JSONObject jsonObject = JSONObject.fromObject(map);
//		Reporter.log("请求参数:" + jsonObject.toString());
//		ResponseModel resp = new ResponseModel();
//		resp = conn.doPost(CreatRoad.cookie, Constant.loadParkingPlace_Url, jsonObject.toString());
//		String gradNo = "";
//		List<Map> list = resp.getList();
//		for (Map m : list) {
//			if (m.containsKey("id")) {
//				placeId = (Integer) m.get("id");
//			}
//			gradNo = (String) m.get("gradNo");
//		}
//
//		Assert.assertEquals(resp.getCode(), "0");
//		Assert.assertEquals(gradNo, "1");
//
//	}

	


	
	
	
	
	

	


	

	

	

	

}
