package zhiyiting2.app.service;

import zhiyiting2.model.ResponseModel;

public interface AppService {
	//绑定车辆
	public ResponseModel bindCar(String plateNo) throws Exception;
	//解绑车辆
	public ResponseModel unbindCar(String plateNo) throws Exception;
	//支付
	public void payBill(int[] billIds, Double totalMoney, Double walletPayMoney) throws Exception;
	//行驶证上传图片
	public Integer uploadFileNew() throws Exception;
	//行驶证提交审核
	public void bindApply(String plateNo, String vehicleLicenseNo) throws Exception;
	//
	public String myUserOrder(String bindOrderType, Integer currPage, Integer pageSize, String type) throws Exception;







//	public ResponseModel sendVerifyCode(String mobile) throws Exception;
//
//	public ResponseModel appRegister(String mobile, String password, String uuid, String verifyCode) throws Exception;
//
//	public void walletToMonthPurchase(Integer carId, Integer count, Integer operatorPeriodRuleId, Integer parkingRoadId,
//			String parkingType) throws Exception;
//
//	public void logOut() throws Exception;
//
//	public String loadUserCouponList(Integer flag) throws Exception;
//	public void myCar() throws Exception;
//
//	public ResponseModel requestPositiveInvoice(int[] payBillIdList,Double totalMoney,Map userInvoiceHead) throws Exception;
}
