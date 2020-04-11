package zhiyiting2.util;

public class Constant {
	
	public static class ParkingRoadConstant{
		//编辑路段提交
		public static final String  updateParkRoad_Url = url+"/api/background/updateParkRoad.do";
		//修改路段运营状态
		public static final String  batchUpdateParkRoadOperationStatus_Url = url+"/api/background/batchUpdateParkRoadOperationStatus.do";
		//车位开启关闭出库审核
		public static final String  auditParkPlaceOut_Url = url+"/api/background/auditParkPlaceOut.do";
		//路段开启关闭出库审核
		public static final String  batchOutAuditByParkingRoadCodes_Url = url+"/api/background/batchOutAuditByParkingRoadCodes.do";
		//设备配置
		public static final String  deviceConfig_Url = url+"/api/background/deviceConfig.do";

		
	}
	
	public static class ChargeStandardConstant{
		//新增收费规则
		public static final String  addChargeStandardMultipleInfo_Url=url+"/api/background/addChargeStandardMultipleInfo.do";
		//新增包月套餐
		public static final String  addPeriodRuleItem_Url=url+"/api/background/addPeriodRuleItem.do";

	}
	
	public static class DiscountsChargeStandard{
		//新增优惠策略
		public static final String  addMarketingPlan_Url=url+"/api/background/addMarketingPlan.do";
		//编辑优惠策略
		public static final String  editMarketingPlan_Url=url+"/api/background/editMarketingPlan.do";
		//删除优惠策略
		public static final String  deleteMarketingPlanById_Url=url+"/api/background/deleteMarketingPlanById.do";

	}
	   
	public static class SpecialVehicleConstant{
		//新增免费车辆
		public static final String  addSpecialCar_Url=url+"/api/background/addSpecialCar.do";
		//编辑免费车辆
		public static final String  updateSpecialCar_Url=url+"/api/background/updateSpecialCar.do";
		//删除免费车辆
		public static final String  deleteSpecialCar_Url=url+"/api/background/deleteSpecialCar.do";

	}
	
	
	
		public class WorkingListConstant{
			//新增施工人员
			public static final String  maintainWorkerInfo_Url=url+"/api/background/maintainWorkerInfo.do";
			//编辑

			//修改密码
			//删除
			
		}
	
	
	
	
		public static class ParkingListConstant{
		
		//车位列表----停车记录
		public static final String  queryRecord_Url = url+"/api/background/queryRecord.do";
		//车位列表----停车记录--调账	
		public static final String  reviseBillMoney_Url = url+"/api/background/reviseBillMoney.do";
		//修改出入库时间
		public static final String  reviseInOutRecordTime_Url = url+"/api/background/reviseInOutRecordTime.do";
		//车位列表--取证
		public static final String  deviceEvidence_Url = url+"/api/background/deviceEvidence.do";

		//车位列表----停车记录--修改车牌	
		public static final String  modifyPlateNoByRecord_Url = url+"/api/background/modifyPlateNoByRecord.do";
		//设备入库
		public static final String  reportIn_Url = url+"/api/device/report.do";
		//设备上传图片
		public static final String  uploadDeviceFile_Url = url+"/api/device/uploadDeviceFile.do";
		//设备入库导入
		public static final String  importDeviceFile_Url = url+"/api/background/importDeviceFile.do";

		//设备出库reportOut  /api/device/report.do
		public static final String  reportOut_Url = url+"/api/device/report.do";
		//设备出库上传图片
		public static final String  uploadDeviceOutFile_Url = url+"/api/device/uploadDeviceOutFile.do";
		//入库复核
		public static final String  manualHandleAudit_Url = url+"/api/background/manualHandleAudit.do";
		
		
		//设备取证开始
		public static final String  deviceEvidenceStatus_Url = url+"/api/device/deviceEvidenceStatus.do";
		//设备取证上传图片
		public static final String  uploadDeviceEvidenceFile_Url = url+"/api/device/uploadDeviceEvidenceFile.do";
		//设备自检
		public static final String  deviceSelfTest_Url = url+"/api/device/deviceSelfTest.do";

		//派发新装单
		public static final String  createNewWorkOrder_Url = url+"/api/background/createNewWorkOrder.do";
		//派发设备清理单
		public static final String  createCleanWorkOrder_Url = url+"/api/background/createCleanWorkOrder.do";
		//派发设备更换单
		public static final String  createReplaceWorkOrder_Url = url+"/api/background/createReplaceWorkOrder.do";

		

	}
	
	
	
	public static final String url = "http://ptestadmin.wisdomep.com";//测试
//	public static final String url = "http://parkingadmin.wisdomep.com";//正式
	public static final String  loginUrl = url+"/api/background/login.do";
	public static final String  addLoadUrl = url+"/api/background/addParkRoad.do";
	public static final String  getRoadListUrl=url+"/api/background/manager/loadParkingRoad.do";
	//上线路段
	public static final String  batchChangeParkingRoadStatus_Url=url+"/api/background/batchChangeParkingRoadStatus.do";
	//添加车位
	public static final String addParkPlace_Url=url+"/api/background/addParkPlace.do";
	//新装车位列表
	public static final String  loadParkingPlace_Url=url+"/api/background/manager/loadParkingPlace.do";
	//上下线车位
	public static final String  batchAuditParkPlace_Url=url+"/api/background/batchAuditParkPlace.do";

	
	
	
	
	//查看工单列表，返回工单的ID
	public static final String  queryWorkOrder_Url=url+"/api/background/queryWorkOrder.do";
	//工单列表点击详情
	public static final String  querySingleWorkOrderDetail_Url=url+"/api/background/querySingleWorkOrderDetail.do";
	
	
	
	//获取施工人员列表
	public static final String  loadWorkerInfo_Url=url+"/api/background/loadWorkerInfo.do";
	//新增运营商
	public static final String  maintainOperatorInfo_Url=url+"/api/background/maintainOperatorInfo.do";
	
	//运营商绑定施工人员
	public static final String  maintainOperatorRelWorkerInfo_Url=url+"/api/background/maintainOperatorRelWorkerInfo.do";
	//路段绑定施工人员
	public static final String  batchBindParkingRoadAndWorker_Url=url+"/api/background/batchBindParkingRoadAndWorker.do";
	//派发新装单回填
	public static final String  backfillConstructWorkOrderActivity_Url=url+"/api/background/backfillConstructWorkOrderActivity.do";
	
	
	
	//app注册
	public static final String  app_register_Url=url+"/api/v1/mobile/user/register.do";

	//app注册发送短信
	public static final String  app_sendVerifyCode_Url=url+"/api/v1/mobile/user/sendVerifyCode.do";

	
	
	
	//上传驾驶证
	//上传行驶证
	
	
	
	
	
}
