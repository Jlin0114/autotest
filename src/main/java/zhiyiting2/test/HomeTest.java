package zhiyiting2.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.testng.annotations.Test;
import zhiyiting2.model.ResponseModel;
import zhiyiting2.model.SqlModel;
import zhiyiting2.util.JDBCConnection;

public class HomeTest extends ZTest {
	public static void main(String[] args) throws Exception {
//		HomeTest homeTest = new HomeTest();
//		homeTest.deleteTestData();
//		homeTest.testDataInit();
		//设备绑定完毕  开始模拟设备做出入库
		ManagerLogin.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");

		AuditTest auditTest = new AuditTest();
//		auditTest.normal_in_outTest();
//		AuditType auditType = new AuditType();
//
//		ManagerLogin.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");


//		auditTest.in_out();




//		auditTest.in_in();





	}
	
	
	
	
	
	public void deleteTestData() {
		JDBCConnection jdbc = new JDBCConnection();
		String[] str = {

				"delete o from operator o where o.name='审核列表专用测试运营商'",
				"delete c from charge_standard c where c.charge_standard_name='审核列表专用收费规则' ",
				"delete pp from parking_place pp where pp.road_id=(select id from parking_road where road_name='审核列表专用测试路段')",
				"delete p from parking_road p where p.road_name='审核列表专用测试路段'",
				"delete w from worker w where w.name='审核列表专用施工人员' ",

		};
		try {
			jdbc.executeUpdate(str);

		} catch (Exception e) {
			// 不处理
		}
	}

	public void testDataInit() {
		try {
			ManagerLogin.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");
			// 创建运营商
			String provinceId = "450000";// 广西省
			String cityId = "450100";// 南宁市
			ResponseModel resp = new ResponseModel();
			resp = operatorService.maintainOperatorInfo("审核列表专用测试运营商", provinceId, cityId, null, "insert");
			this.operatorId = resp.getId();
			// 创建收费规则
			Object[] dayChargeStandardList = new Object[3];
			Map m0 = new HashMap();
			m0.put("freeMinutesMode", 0);
			m0.put("smallCarFreeMinutes", 1);
			m0.put("chargeCapMode", 0);
			m0.put("smallCarChargeCap", 35);
			dayChargeStandardList[0] = m0;
			Map m1 = new HashMap();
			m1.put("startTime", "08:00");
			m1.put("endTime", "20:00");
			m1.put("chargeType", 3);
			m1.put("skipNext", false);
			m1.put("chargeCycleMinutes", 30);
			m1.put("smallCarRate", "1");
			dayChargeStandardList[1] = m1;
			Map m2 = new HashMap();
			m2.put("startTime", "20:00");
			m2.put("endTime", "08:00");
			m1.put("skipNext", false);
			m2.put("chargeType", 0);
			dayChargeStandardList[2] = m2;
			resp = chargeStandardService.addChargeStandardMultipleInfo(operatorId, "审核列表专用收费规则", "ONE_LEVEL", "1", 20,
					1, false, false, dayChargeStandardList);
			chargeStandardId = resp.getId();
			// 创建路段
			resp = parkingRoadService.creatRoad("108.333867", "22.812052", "审核列表专用测试路段", "450103001",
					String.valueOf(chargeStandardId), "Y", "Y", "huawei");
			roadId = resp.getId();
			// 创建车位
			parkingRoadService.addParkPlaces(roadId, "108.334008", "22.812683", "1");
			// 查询车位id
			List<Object> list = jdbconn.query(
					"select p.id from parking_place p where " + "p.road_id='" + roadId + "' and p.grid_no='1'",
					SqlModel.class);
			placeId = SqlModel.class.cast(list.get(0)).getId();
			// 派发工单
			parkingService.createNewWorkOrder(placeId);
			// 创建施工人员
			resp = workerService.maintainWorkerInfo("审核列表专用施工人员", "18834563456", "123456", "insert",
					"8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");
			workerId = resp.getId();
			int[] workerIds = new int[1];
			workerIds[0] = workerId;
			// 施工人员绑定运营商
			operatorService.maintainOperatorRelWorkerInfo(workerIds, operatorId);
//			//施工人员绑定路段
			int[] parkingRoadIds = new int[1];
			parkingRoadIds[0] = roadId;
			Object[] workerInfos = new Object[1];
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("workerId", workerId);
			workerInfos[0] = map;
			parkingRoadService.batchBindParkingRoadAndWorker(workerInfos, parkingRoadIds);
			List<Object> activity = jdbconn.query("select woa.id from work_order_activity woa "
					+ "left join work_order wo on wo.id=woa.work_order_id where " + "wo.parking_place_id='" + placeId
					+ "' order by woa.id desc", SqlModel.class);
			String activityId = String.valueOf(SqlModel.class.cast(activity.get(0)).getId());
//			//设备入库
//			resp = deviceService.uploadDeviceFile();
//			String fileId = resp.getFileId();
//			deviceService.importDeviceFile(fileId);
//			//工单回填
			workerService.backfillConstructWorkOrderActivity(activityId, "112233445566778", String.valueOf(workerId));
			// 路段上线
			int roadIds[] = new int[1];
			roadIds[0] = this.roadId;
			parkingRoadService.batchChangeParkingRoadStatus(roadIds, "1");

			parkingRoadService.batchUpdateParkRoadOperationStatus(roadId, "FORMAL");
			// 开启出库审核
			int[] ids = new int[1];
			ids[0] = this.placeId;
			// 车位上线
			parkingRoadService.batchAuditParkPlace(ids, "PASS");
			//开启出库审核
			parkingRoadService.auditParkPlaceOut(ids, "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			// 如果初始化数据失败了，后边的case不需要执行 程序停止
			System.out.println("初始化数据异常,进程终止！");
		}

	}

//	
}
