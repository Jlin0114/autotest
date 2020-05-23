package zhiyiting2.app;

public class Constant {
	public static final String url = "http://ptestadmin.wisdomep.com";
	
	//登录  
	public static final String  app_login_Url = url+"/api/v1/mobile/user/login.do";
	//发送验证码
	public static final String  sendVerifyCode_Url = url+"/api/v1/mobile/user/sendVerifyCode.do";
	//注册
	public static final String  app_register_Url = url+"/api/v1/mobile/user/register.do";
	
	//发票提交
	public static final String  requestPositiveInvoice_Url = url+"/api/v1/mobile/electronicInvoice/requestPositiveInvoice.do";

	
	
	
	//绑定驾驶证上传图片   绑定行驶证上传图片
	public static final String  uploadFileNew_Url = url+"/api/v1/mobile/user/uploadFileNew.do";
	//绑定驾驶证提交
	public static final String  updateBindApply_Url = url+"/api/v1/mobile/user/updateBindApply.do";
	

	//获取我的车辆
	public static final String  myCar_Url = url+"/api/v1/mobile/user/myCar.do";
	//绑定车牌
	public static final String  bindCar_Url = url+"/api/v1/mobile/user/bindCar.do";
	//解绑车辆
	public static final String  unbindCar_Url = url+"/api/v1/mobile/user/unbindCar.do";

	//行驶证认证提交 驾驶证初次绑定
	public static final String  bindApply_Url = url+"/api/v1/mobile/user/bindApply.do";
	//账单列表
	public static final String  loadBillInfo_Url = url+"/api/v1/mobile/bill/loadBillInfo.do";
	//优惠券列表
	public static final String loadUserCouponList_Url = url+"/api/v1/mobile/loadUserCouponList.do";
	//办理路段包月
	public static final String  walletToMonthPurchase_Url = url+"/api/v1/mobile/recharge/walletToMonthPurchase.do";
	//充值
	public static final String  app_recharge_Url = url+"/api/v1/mobile/recharge/wallet.do";
	//支付
	public static final String  payBill_Url = url+"/api/v1/mobile/pay/payBill.do";
	//账单申诉
	public static final String appealBill_Url = url+"/api/v1/mobile/user/appealBillHandle.do";
	//修改密码
	public static final String modifyPassword_Url = url +"/api/v1/mobile/user/forgetpwd.do";
	//退出登录
	public static final String logOut_Url = url + "/api/v1/mobile/user/logout.do";
	//行驶证审核
	public static final String auditBindApply_Url = url + "/api/background/auditBindApply.do";
	//查询认证记录列表
	public static final String myUserOrder_Url = url + "/api/v1/mobile/user/myUserOrder.do";


	//意见反馈
	//投诉建议
	
	
}
