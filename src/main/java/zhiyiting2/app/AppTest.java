package zhiyiting2.app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
import zhiyiting2.app.service.AppService;
import zhiyiting2.model.ResponseModel;
import zhiyiting2.model.SqlModel;
import zhiyiting2.test.ManagerLogin;
import zhiyiting2.test.TestAssertException;
import zhiyiting2.test.ZTest;
import zhiyiting2.test.chargeStandardManagement.service.ChargeStandardService;
import zhiyiting2.test.deviceManagement.service.DeviceService;
import zhiyiting2.test.operatorManagement.service.OperatorService;
import zhiyiting2.test.parkingManagement.service.ParkingRoadService;
import zhiyiting2.test.parkingManagement.service.ParkingService;
import zhiyiting2.test.workerManagement.service.WorkerService;
import zhiyiting2.util.JDBCConnection;
import zhiyiting2.util.URLConnection;

public class AppTest extends ZTest {
	@Autowired
	ParkingService parkingService;
	@Autowired
	ChargeStandardService chargeStandardService;
	@Autowired
	DeviceService deviceService;
//	@Autowired
//	OperatorService operatorService;
	@Autowired
	ParkingRoadService parkingRoadService;
	@Autowired
	URLConnection uRLConnection;
	@Autowired
	AppService appService;
	@Autowired
	WorkerService workerService;
	@Autowired
	JDBCConnection jdbconn;
	public static String cookie;
	public static String uuid;
	public static String verifyCode;
	public static Integer carId;
	public static Double money;
	public static Integer userId;
	public static List<Map> bills;
	public static List<Map> coupons;
	public static Map<String, Integer> carIds = new HashMap<String, Integer>();
	public static String[] plateNos = { "吉A12567", "云N12345" };
	public static String[] unbindCarTestPlateNos = { "吉M12345", "吉M23456", "吉M34567" };
	public static Integer operatorId=0;
	public static Integer chargeStandardId=0;
	public static Integer roadId=0;
	public static Integer workerId=0;
//	@BeforeSuite
//	public void deleteTestData() {
//		JDBCConnection jdbc = new JDBCConnection();
//		String[] str = { "delete c from car c where c.plate_no in('" + plateNos[0] + "','" + plateNos[1] + "'," + "'"
//				+ unbindCarTestPlateNos[0] + "','" + unbindCarTestPlateNos[1] + "','" + unbindCarTestPlateNos[2] + "')",
//				"delete b,br from bill b left join bill_record br on b.id=br.bill_id where b.place_code='"
//						+ this.placeId + "'",
//				"delete o from operator o where o.name='压测专用运营商'",
//				"delete c from charge_standard c where c.charge_standard_name='自动化测试收费规则' ",
//				"delete pp from parking_place pp where pp.road_id=(select id from parking_road where road_name='压测专用路段')",
//				"delete p from parking_road p where p.road_name='压测专用路段'",
//				"delete w from worker w where w.name='压测施工人员' ",
//				};
//		try {
//			jdbc.executeUpdate(str);
//
//		} catch (Exception e) {
//			//不处理
//		}
//	}

//	// 初始化测试数据
//	@Test(testName="testDataInit",description="数据初始化")
//	public void testDataInit(){
//		try {
//			//创建运营商
//			String provinceId="450000";//广西省
//			String cityId="450100";//南宁市
//			ResponseModel resp = new ResponseModel();
//			resp = operatorService.maintainOperatorInfo("自动化测试运营商", provinceId, cityId, null, "insert");
//			this.operatorId = resp.getId();
//			//创建收费规则
//			Object[] dayChargeStandardList = new Object[3];
//			Map m0 = new HashMap();
//			m0.put("freeMinutesMode", 0);
//			m0.put("smallCarFreeMinutes", 1);
//			m0.put("chargeCapMode", 0);
//			m0.put("smallCarChargeCap", 35);
//			dayChargeStandardList[0]=m0;
//			Map m1 = new HashMap();
//			m1.put("startTime", "08:00");
//			m1.put("endTime", "20:00");
//			m1.put("chargeType", 3);
//			m1.put("skipNext", false);
//			m1.put("chargeCycleMinutes", 30);
//			m1.put("smallCarRate", "1");
//			dayChargeStandardList[1]=m1;
//			Map m2 = new HashMap();
//			m2.put("startTime","20:00");
//			m2.put("endTime", "08:00");
//			m1.put("skipNext", false);
//			m2.put("chargeType",0);
//			dayChargeStandardList[2]=m2;
//			resp=chargeStandardService.addChargeStandardMultipleInfo(operatorId, "自动化测试收费规则","ONE_LEVEL","1",20,1,false,false,dayChargeStandardList);
//			chargeStandardId = resp.getId();
//			//创建路段
//			resp=parkingRoadService.creatRoad("108.333867", "22.812052", "自动化测试1", "450103001",String.valueOf(chargeStandardId),"Y","Y","");
//			roadId = resp.getId();
//			//创建车位
//			parkingRoadService.addParkPlaces(roadId,"108.334008","22.812683","1");
//			//查询车位id
//			List<Object> list = jdbconn.query("select p.id from parking_place p where "
//					+ "p.road_id='"+roadId+"' and p.grid_no='1'", SqlModel.class);
//			placeId = SqlModel.class.cast(list.get(0)).getId();
//			//派发工单
//			parkingService.createNewWorkOrder(placeId);
//			//创建施工人员
//			resp=workerService.maintainWorkerInfo("自动化测试施工人员","18834563456", "123456", "insert","8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");
//			workerId = resp.getId();
//			int[] workerIds = new int[1];
//			workerIds[0]=workerId;
//			//施工人员绑定运营商
//			operatorService.maintainOperatorRelWorkerInfo(workerIds, operatorId);
////			//施工人员绑定路段
//			int[] parkingRoadIds = new int[1];
//			parkingRoadIds[0]=roadId;
//			Object[] workerInfos = new Object[1];
//			Map<String,Integer> map = new HashMap<String, Integer>();
//			map.put("workerId", workerId);
//			workerInfos[0]=map;
//			parkingRoadService.batchBindParkingRoadAndWorker(workerInfos, parkingRoadIds);
//			List<Object> activity = jdbconn.query("select woa.id from work_order_activity woa "
//					+ "left join work_order wo on wo.id=woa.work_order_id where "
//					+ "wo.parking_place_id='"+placeId+"' order by woa.id desc", SqlModel.class);
//			String activityId = String.valueOf(SqlModel.class.cast(activity.get(0)).getId());
////			//设备入库
////			resp = deviceService.uploadDeviceFile();
////			String fileId = resp.getFileId();
////			deviceService.importDeviceFile(fileId);
////			//工单回填
//			workerService.backfillConstructWorkOrderActivity(activityId, "987654321", String.valueOf(workerId));
//			//路段上线
//			int roadIds[] = new int[1];
//			roadIds[0]=this.roadId;
//			parkingRoadService.batchChangeParkingRoadStatus(roadIds, "0");
//
//			parkingRoadService.batchUpdateParkRoadOperationStatus(roadId, "FORMAL");
//			//开启出库审核
//			int[] ids = new int[1];
//			ids[0]=this.placeId;
//			//车位上线
//			parkingRoadService.auditParkPlaceOut(ids, "PASS");
//		} catch (Exception e) {
//			e.printStackTrace();
//			//如果初始化数据失败了，后边的case不需要执行 程序停止
//			System.out.println("初始化数据异常,进程终止！");
//			System.exit(0);
//		}
//
//	}
//
	// 初始化测试数据
		@Test(testName="testDataInit1",description="数据初始化")
		public void testDataInit1(){
			try {
				//创建运营商
				String provinceId="450000";//广西省
				String cityId="450100";//南宁市
				String[] pcas = new String[2];
				pcas[0]=provinceId;
				pcas[1]=cityId;
				ResponseModel resp = new ResponseModel();
//				resp = operatorService.maintainOperatorInfo("压测专用运营商", provinceId, cityId, null, "insert");
				resp=operatorService.insertOperatorInfo(cityId,null,"压测专用运营商","ZYT",1,provinceId,pcas,null,"insert");
				this.operatorId = resp.getId();
				//创建收费规则
//				Object[] dayChargeStandardList = new Object[3];
//				Map m0 = new HashMap();
//				m0.put("freeMinutesMode", 0);
//				m0.put("smallCarFreeMinutes", 1);
//				m0.put("chargeCapMode", 0);
//				m0.put("smallCarChargeCap", 35);
//				dayChargeStandardList[0]=m0;
//				Map m1 = new HashMap();
//				m1.put("startTime", "08:00");
//				m1.put("endTime", "20:00");
//				m1.put("chargeType", 3);
//				m1.put("chargeCycleMinutes", 30);
//				m1.put("smallCarRate", "1");
//				dayChargeStandardList[1]=m1;
//				Map m2 = new HashMap();
//				m2.put("startTime","20:00");
//				m2.put("endTime", "08:00");
//				m2.put("chargeType",0);
//				dayChargeStandardList[2]=m2;
//				resp=chargeStandardService.addChargeStandardMultipleInfo(Integer.valueOf(provinceId),
//						Integer.valueOf(cityId), "自动化测试收费规则","ONE_LEVEL",20,1,false,false,dayChargeStandardList);
//				chargeStandardId = resp.getId();
				//创建路段
				resp=parkingRoadService.creatRoad("108.333866", "22.812051", "测专用路段压", "450103001","63","Y","Y","");
				roadId = resp.getId();
				//创建施工人员
				resp=workerService.maintainWorkerInfo("压测施工人员","18834563456", "123456", "insert","8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");
				workerId = resp.getId();
				int[] workerIds = new int[1];
				workerIds[0]=workerId;
				//施工人员绑定运营商
				operatorService.maintainOperatorRelWorkerInfo(workerIds, operatorId);
//				//施工人员绑定路段
				int[] parkingRoadIds = new int[1];
				parkingRoadIds[0]=roadId;
				Object[] workerInfos = new Object[1];
				Map<String,Integer> map = new HashMap<String, Integer>();
				map.put("workerId", workerId);
				workerInfos[0]=map;
				parkingRoadService.batchBindParkingRoadAndWorker(workerInfos, parkingRoadIds);
				//路段上线
				int roadIds[] = new int[1];
				roadIds[0]=this.roadId;
				parkingRoadService.batchChangeParkingRoadStatus(roadIds, "1");
				parkingRoadService.batchUpdateParkRoadOperationStatus(roadId, "FORMAL");
				for(int i=0;i<1000;i++) {
					//创建车位
					parkingRoadService.addParkPlaces(roadId,"108.334009"+i,"22.812682"+i,String.valueOf(i));
					//查询车位id
					List<Object> list = jdbconn.query("select p.id from parking_place p where "
							+ "p.road_id='"+roadId+"' order by p.id desc", SqlModel.class);
					placeId = SqlModel.class.cast(list.get(0)).getId();
					//派发工单
					parkingService.createNewWorkOrder(placeId);
					List<Object> activity = jdbconn.query("select woa.id from work_order_activity woa "
							+ "left join work_order wo on wo.id=woa.work_order_id where "
							+ "wo.parking_place_id='"+placeId+"' order by woa.id desc", SqlModel.class);
					String activityId = String.valueOf(SqlModel.class.cast(activity.get(0)).getId());
//					//工单回填
					workerService.backfillConstructWorkOrderActivity(activityId,588885888800000L+i+"", String.valueOf(workerId));
					//开启出库审核
					int[] ids = new int[1];
					ids[0]=this.placeId;
					//车位开日出库审核
					parkingRoadService.auditParkPlaceOut(ids, "PASS");

				}


			} catch (Exception e) {
				e.printStackTrace();
				//如果初始化数据失败了，后边的case不需要执行 程序停止
				System.out.println("初始化数据异常,进程终止！");
				System.exit(0);
			}

		}
	
//
//	@BeforeTest
//	public void login(){
//		try {
//
//			ManagerLogin.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");
////			Applogin.login("","45A3B0FD8F88841DEDC0A5BC04325D938BB3F16D68A561F34BEB43C530B4F115","16620992099","IOS","");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//	}
//	 app登录
	@Test(testName = "appLogin", description = "app登录111", dataProvider = "appLogin", dataProviderClass = AppData.class)
	public void appLogin(String testname, String password, String mobile, String deviceTokenType, String deviceToken)
			throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobile", mobile);
		map.put("deviceTokenType", deviceTokenType);
		map.put("password", password);
		map.put("deviceToken", deviceToken);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("登录");
		Reporter.log("请求参数:" + jsonObject.toString());
		ResponseModel resp = new ResponseModel();
		cookie = uRLConnection.doPost(Constant.app_login_Url, jsonObject.toString());
	}

	// 修改驾驶证提交
//	@Test(testName = "updateBindApply", description = "绑定驾驶证提交", dataProvider = "updateBindApply", dataProviderClass = AppData.class)
//	public void updateBindApply(String testname, Integer driverLicenseFileId, String driverLicenseNo) throws Exception {
//		Map map = new HashMap();
//		map.put("driverLicenseFileId", driverLicenseFileId);
//		map.put("driverLicenseNo", driverLicenseNo);
//		JSONObject jsonObject = JSONObject.fromObject(map);
//		Reporter.log("请求参数:" + jsonObject.toString());
//		String result = uRLConnection.doPost(this.cookie, Constant.updateBindApply_Url, jsonObject.toString());
//		Reporter.log("返回参数:" + result);
//		ResponseModel resp = new ResponseModel();
//		resp = uRLConnection.getResponseModel(result);
//		Assert.assertEquals(resp.getMessage(), "OK");
//		Assert.assertEquals(resp.getCode(), "0");
//
//	}

	// 行驶证审核 创建两辆车 一个审核 一个驳回
	@Test(testName = "auditBindApply", description = "行驶证审核", dataProvider = "auditBindApply", dataProviderClass = AppData.class)
	public void auditBindApply(String testname, String[] statuses, int type) throws Exception {
		ResponseModel re = new ResponseModel();
		for (int i = 0; i < this.plateNos.length; i++) {
			// 绑定车辆
			re = appService.bindCar(plateNos[i]);
			carIds.put(plateNos[i], re.getCarId());
			// 提交行驶证审核
			appService.bindApply(this.plateNos[i], "456789");
		}
		// 查询认证记录
		Reporter.log("查询认证列表");
		String result = appService.myUserOrder("BIND_VEHICLE_LICENSE", 1, 20, "BIND_CAR_APPLY");
		ResponseModel resp = uRLConnection.getResponseModel(result);
		List<Map> list = resp.getList();
		String[] status = { "PASS", "VETO" };
		int[] ids = new int[1];
		for (int i = 0; i < list.size(); i++) {
			String carId = String.valueOf(list.get(i).get("carId"));
			String s = String.valueOf(list.get(i).get("status"));
			for (int n = 0; n < plateNos.length; n++) {
				if (String.valueOf(this.carIds.get(this.plateNos[n])).equals(carId) && "INPUT".equals(s)) {
					Integer userOrderId = Integer.class.cast(list.get(i).get("id"));
					ids[0] = userOrderId;
					Map map = new HashMap();
					map.put("ids", ids);
					map.put("status", status[i]);
					map.put("statuses", statuses);
					map.put("type", type);
					JSONObject jsonObject = JSONObject.fromObject(map);
					Reporter.log("后台审核行驶证");
					Reporter.log("请求参数:" + jsonObject.toString());
					String r = uRLConnection.doPost(ManagerLogin.cookie, Constant.auditBindApply_Url,
							jsonObject.toString());
					Reporter.log("返回参数:" + r);
					ResponseModel res = new ResponseModel();
					res = uRLConnection.getResponseModel(r);
					Assert.assertEquals(res.getCode(), "0");
				}
			}
		}

	}

//	 绑定车辆校验是否送优惠券
//	@Test(testName = "断言绑定车辆送优惠券")
//	public void assertBindCarSendCoupon() throws Exception {
//		String result = appService.loadUserCouponList(1);
//		ResponseModel resp = uRLConnection.getResponseModel(result);
//		List<Map> list = resp.getList();
//		for (Map map : list) {
//			if (!AppData.plateNo.equals(list.get(0).get("plateNo"))) {
//				throw new TestAssertException("100", "优惠车牌和本人车牌不符！");
//			}
//			if (Integer.valueOf(DiscountsChargeStandardData.count) != list.size()) {
//				throw new TestAssertException("101", "所发优惠券数量有误！");
//			}
//
//		}
//
//	}

	// 有未支付账单和已支付账单解绑车辆业务验证
	@Test(testName = "assertUnbindCar", description = "解绑车辆限制条件验证")
	public void assertUnbindCar() throws Exception {
		// 绑定三辆车，做三笔账单，一笔停车中，一笔未支付，一笔已支付，停车中的和未支付的都不可以解绑车辆
		for (int i = 0; i < unbindCarTestPlateNos.length; i++) {
			// 绑定车辆
			appService.bindCar(unbindCarTestPlateNos[i]);
			// 设备入库
			Long serialId = System.currentTimeMillis() / 1000;
				
			deviceService.reportIn(this.deviceNo, "PREPARE", 12, 25, serialId, System.currentTimeMillis() / 1000);
			// 设备上传图片
			deviceService.uploadDeviceFile(35, 20, 61, 1, 8, this.deviceNo, serialId,
					System.currentTimeMillis() / 1000,0,"");
			// 设备出库
			deviceService.reportOut(this.deviceNo, "OUT", 62, 21, false, serialId, System.currentTimeMillis() / 1000);
			List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='IN' and a.serial_id='"
					+ serialId.intValue() + "' order by id desc", SqlModel.class);
			if (obj != null && obj.size() > 0) {
				ResponseModel resp = new ResponseModel();
				Integer auditId = SqlModel.class.cast(obj.get(0)).getId();
				parkingService.manualHandleAudit(this.unbindCarTestPlateNos[i], false, false, "SMALL", auditId, "IN",
						null);
				// 第一辆车支付 第二辆车只生成账单 第三辆车不出库
				if (i < 2) {
					List<Object> objOut = jdbconn
							.query("select a.id from audit a where a.audit_type='OUT' and a.serial_id='"
									+ serialId.intValue() + "' order by id desc", SqlModel.class);
					Integer auditIdOut = SqlModel.class.cast(objOut.get(0)).getId();
					parkingService.manualHandleAudit(null, null, null, null, auditIdOut, "OUT", null);
					// 查询账单
					List<Object> billRecord = jdbconn.query("select b.id from bill_record b where b.parking_place_id='"
							+ this.placeId + "' order by id desc", SqlModel.class);
					if (billRecord != null && billRecord.size() > 0) {
						Integer billRecordId = SqlModel.class.cast(billRecord.get(0)).getId();
						// 调整出入库时间
						parkingService.reviseInOutRecordTime(billRecordId, "2020-03-21 10:00:00",
								"2020-03-21 12:00:00");
					}

					if (i == 0) {
						List<Object> bill = jdbconn.query("select b.id,b.money from bill b where b.plate_no='"
								+ this.unbindCarTestPlateNos[0] + "' order by id desc", SqlModel.class);
						Integer billId = SqlModel.class.cast(bill.get(0)).getId();
						Double walletPayMoney = SqlModel.class.cast(bill.get(0)).getMoney();
						int[] billIds = new int[1];
						billIds[0] = billId;
						appService.payBill(billIds, walletPayMoney, walletPayMoney);
					}

				}
				// 解绑
				resp = appService.unbindCar(unbindCarTestPlateNos[i]);
				String message = "";
				// 第一辆车 断言 返回500 且应该提示
				if (i == 2) {
					message = unbindCarTestPlateNos[i] + "正在停车中，请结束停车后再解绑";
					if (!("500".equals(resp.getCode()) && message.equals(resp.getMessage()))) {
						throw new TestAssertException("200", "停车中车辆不可以解绑断言失败");
					}
				} else if (i == 1) {
					// 第二辆车 未支付车辆不允许解绑
					message = unbindCarTestPlateNos[i] + "还有1笔未支付账单，请先完成支付再解绑";
					if (!("500".equals(resp.getCode()) && message.equals(resp.getMessage()))) {
						throw new TestAssertException("201", "有未支付账单车辆解绑断言失败");
					}
				} else if (i == 0) {
					// 第三辆车 已支付车辆可以解绑
					if (!("0".equals(resp.getCode()) && "OK".equals(resp.getMessage()))) {
						throw new TestAssertException("202", "无未支付账单车辆解绑断言失败");
					}
				}

			}

		}

	}

	@Test(testName = "loadBillInfo", description = "账单列表", dataProvider = "loadBillInfo", dataProviderClass = AppData.class)
	public void loadBillInfo(String testname, String pageSize, String currPage, String status) throws Exception {
		Map map = new HashMap();
		map.put("pageSize", pageSize);
		map.put("currPage", currPage);
		if ("all".equals(status)) {
//					map.put("payStatusList", payStatusList);
		} else if ("free".equals(status)) {
			List<String> payStatusList = new ArrayList<String>();
			payStatusList.add("FREE");
			payStatusList.add("REVISE_FREE");
			payStatusList.add("FREE_SPECIAL");
			payStatusList.add("MONTH_PURCHASE");
			map.put("payStatusList", payStatusList);
		} else if ("paid".equals(status)) {
			List<String> payStatusList = new ArrayList<String>();
			payStatusList.add("PAID");
			map.put("payStatusList", payStatusList);
		} else if ("unpaid".equals(status)) {
			List<String> payStatusList = new ArrayList<String>();
			payStatusList.add("UNPAID");
			payStatusList.add("TAIL");
			map.put("payStatusList", payStatusList);
		}
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		String result = uRLConnection.doPost(this.cookie, Constant.loadBillInfo_Url, jsonObject.toString());
		Reporter.log("返回参数:" + result);
		ResponseModel resp = new ResponseModel();
		resp = uRLConnection.getResponseModel(result);
		this.bills = resp.getList();
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
	}

	// 账户修改钱包余额
//	@Test(testName = "updateUserBalance", description = "修改账户钱包余额")
//	public void updateUserBalance() throws Exception {
//		JDBCConnection jdbc = new JDBCConnection();
//		String[] str = new String[1];
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String format = sf.format(new Date());
//		
//		String sql = "insert into user_wallet values(null," + "'" + this.userId + "'" + "," + "'"
//				+ OperatorList.operatorId + "'" + ",'" + 210100 + "','预存钱包','" + 1000 + "','0','DEPOSITE','" + format
//				+ "'," + "'" + format + "'," + "'" + 8 + "','测试')";
//		str[0] = sql;
//		jdbc.mysqlConnection("", str);
//	}

	// 只用优惠券支付
	@Test(testName = "payBillAllWithCoupon", description = "只用优惠券支付", dataProvider = "payBillAllWithCoupon", dataProviderClass = AppData.class)
	public void payBillAllWithCoupon(String testname, int[] billIds, int couponId, String couponPayChannel,
			Double couponPayMoney, Double totalMoney, Double walletPayMoney) throws Exception {
		Map map = new HashMap();
		map.put("billIds", billIds);
		map.put("couponId", couponId);
		map.put("couponPayChannel", couponPayChannel);
		map.put("couponPayMoney", couponPayMoney);
		map.put("totalMoney", totalMoney);
		map.put("walletPayMoney", walletPayMoney);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数" + jsonObject.toString());
		ResponseModel resp = new ResponseModel();
		String result = uRLConnection.doPost(this.cookie, Constant.payBill_Url, jsonObject.toString());
		Reporter.log("返回参数" + result);
		resp = uRLConnection.getResponseModel(result);
		Assert.assertEquals(resp.getMessage(), "支付成功");
		Assert.assertEquals(resp.getCode(), "0");
	}

	// 修改密码
	@Test(testName = "modifyPassword", description = "修改密码", dataProvider = "modifyPassword", dataProviderClass = AppData.class)
	public void modifyPassword(String testname, String mobile, String newPassword, String uuid, String verifyCode)
			throws Exception {
		Map map = new HashMap();
		map.put("mobile", mobile);
		map.put("password", newPassword);
		map.put("uuid", uuid);
		map.put("verifyCode", verifyCode);
		JSONObject jsonObject = JSONObject.fromObject(map);
		Reporter.log("请求参数:" + jsonObject.toString());
		ResponseModel resp = new ResponseModel();
		String result = uRLConnection.doPost(null, Constant.modifyPassword_Url, jsonObject.toString());
		Reporter.log("返回参数" + result);
		resp = uRLConnection.getResponseModel(result);
		this.uuid = resp.getUuid();
		Assert.assertEquals(resp.getMessage(), "OK");
		Assert.assertEquals(resp.getCode(), "0");
	}


	//tuisong








}
