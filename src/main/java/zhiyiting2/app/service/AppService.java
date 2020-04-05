package zhiyiting2.app.service;

import zhiyiting2.model.ResponseModel;

public interface AppService {
	public ResponseModel bindCar(String plateNo) throws Exception;

	public ResponseModel unbindCar(String plateNo) throws Exception;

	public void payBill(int[] billIds, Double totalMoney, Double walletPayMoney) throws Exception;

	public Integer uploadFileNew() throws Exception;

	public void bindApply(String plateNo, String vehicleLicenseNo) throws Exception;

	public String myUserOrder(String bindOrderType, Integer currPage, Integer pageSize, String type) throws Exception;

	public ResponseModel sendVerifyCode(String mobile) throws Exception;

	public ResponseModel appRegister(String mobile, String password, String uuid, String verifyCode) throws Exception;

	public void walletToMonthPurchase(Integer carId, Integer count, Integer operatorPeriodRuleId, Integer parkingRoadId,
			String parkingType) throws Exception;

	public void logOut() throws Exception;

	public String loadUserCouponList(Integer flag) throws Exception;
	public void myCar() throws Exception;
}
