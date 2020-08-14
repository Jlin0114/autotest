package zhiyiting2.app;

import org.testng.annotations.DataProvider;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppData {
	public static String mobile="13712341234";
	public static String password="a1234567";
	public static String newPassword = "a123456789";
	public static String plateNo="吉A12567";
	public static String plateNo1="云N12345";
	/**
	* 利用java原生的摘要实现SHA256加密
	* @param str 加密后的报文
	* @return
	*/
	public static String getSHA256StrJava(String str){
	 MessageDigest messageDigest;
	 String encodeStr = "";
	 try {
	  messageDigest = MessageDigest.getInstance("SHA-256");
	  messageDigest.update(str.getBytes("UTF-8"));
	  encodeStr = byte2Hex(messageDigest.digest());
	 } catch (NoSuchAlgorithmException e) {
	  e.printStackTrace();
	 } catch (UnsupportedEncodingException e) {
	  e.printStackTrace();
	 }
	 return encodeStr;
	}
	/**
	* 将byte转为16进制
	* @param bytes
	* @return
	*/
	private static String byte2Hex(byte[] bytes){
	 StringBuffer stringBuffer = new StringBuffer();
	 String temp = null;
	 for (int i=0;i<bytes.length;i++){
	  temp = Integer.toHexString(bytes[i] & 0xFF);
	  if (temp.length()==1){
	  //1得到一位的进行补0操作
	  stringBuffer.append("0");
	  }
	  stringBuffer.append(temp);
	 }
	 return stringBuffer.toString();
	}


	@DataProvider(name = "appLogin")
	public Object[][] appLogin() {
	       return new Object[][]{
	               {"app登录:",getSHA256StrJava(this.password),
	            	   this.mobile,"IOS","324e21e59f669b668526a32cf7a9107cd42f5245092fb457fb3bf2ef06602992"},
	               
	       };
	   }
	
	@DataProvider(name = "sendVerifyCode")
	public Object[][] sendVerifyCode() {
	       return new Object[][]{
	               {"注册发送验证码:",this.mobile},
	               
	       };
	   }
	
	
	@DataProvider(name = "appRegister")
	public Object[][] appRegister() {
	       return new Object[][]{
	               {"app注册:",this.mobile,getSHA256StrJava(this.password),AppTest.uuid,AppTest.verifyCode},
	               
	       };
	   }
	
	
//	@DataProvider(name = "uploadFileNew")
//	public Object[][] uploadFileNew() {
//	       return new Object[][]{
//	               {"绑定驾驶证上传图片:"},
//
//	       };
//	   }
//
//	@DataProvider(name = "updateBindApply")
//	public Object[][] updateBindApply() {
//
//	       return new Object[][]{
//	               {"修改驾驶证提交:",AppTest.fileId,"1234567"},
//
//	       };
//	   }
//
	@DataProvider(name = "myCar")
	public Object[][] myCar() {
	       return new Object[][]{
	               {"我的车辆列表:"},
	               
	       };
	   }
	
	
	@DataProvider(name = "bindCar")
	public Object[][] bindCar() {
	       return new Object[][]{
	               {"绑定车辆:",this.plateNo},
	               {"绑定车辆:",this.plateNo1},
	               
	       };
	   }
	@DataProvider(name = "unbindCar")
	public Object[][] unbindCar() {
	       return new Object[][]{
	               {"解绑车辆:",this.plateNo},
	               
	       };
	   }
	@DataProvider(name = "bindApply")
	public Object[][] bindApply() {
	       return new Object[][]{
	               {"行驶证认证提交:",AppData.plateNo,"1234567"},
	               
	       };
	   }
	
	@DataProvider(name = "myUserOrder")
	public Object[][] myUserOrder() {
	       return new Object[][]{
	               {"查询认证记录:","BIND_VEHICLE_LICENSE",1,20,"BIND_CAR_APPLY"},
	               
	       };
	   }
	
	
	
	@DataProvider(name = "auditBindApply")
	public Object[][] auditBindApply() {
		String[] statuses =new String[1];
		statuses[0]="INPUT";
	       return new Object[][]{
	               {"行驶证审核:",statuses,2},
	               
	       };
	   }
	
	
	
	@DataProvider(name = "loadBillInfo")
	public Object[][] loadBillInfo() {
		
	       return new Object[][]{
//	               {"账单列表--所有:","20","1","all"},
//	               {"账单列表--免费:","20","1","free"},
//	               {"账单列表--已支付:","20","1","paid"},
	               {"账单列表--未支付:","20","1","unpaid"},
	       };
	   }

//	 @DataProvider(name = "loadUserCouponList")
//	 public Object[][] loadUserCouponList(){
//			return new Object[][]{
//					{"flag:", 0},//可用的
////					{"flag:", 1},//所有
//			};
//	 }
	
	@DataProvider(name = "payBill")
	public Object[][] payBill() {
//		int[] billIds = new int[1];
//		billIds[0]=ParkingList.billId;
		int [] billIds = new int[AppTest.bills.size()];
		double money = 0.0;
		for(int i = 0; i < AppTest.bills.size(); i++){
			billIds[i] = Integer.class.cast(AppTest.bills.get(i).get("id"));
			money += Double.parseDouble(AppTest.bills.get(i).get("money").toString());
		}

		return new Object[][]{
	               {"支付:",billIds, money, money},
		};
	}

	
	@DataProvider(name = "assertUnbindCar")
	public Object[][] assertUnbindCar() {

		return new Object[][]{
	               {"解绑车辆限制条件验证:"},
		};
	}
	
	@DataProvider(name = "payBillWithCoupon")
	public Object[][] payBillWithCoupon(){

		int [] billIds = new int[AppTest.bills.size()];
//		Map<Integer, Integer> billIdsAndCarsIds = new HashMap<Integer, Integer>();
		double money = 0.0;
//		int [] usableCouponIds;

		for(int i = 0; i < AppTest.bills.size(); i++){
			billIds[i] = Integer.class.cast(AppTest.bills.get(i).get("id"));
			money += Double.parseDouble(AppTest.bills.get(i).get("money").toString());
//			billIdsAndCarsIds.put((int) AppTest.bills.get(i).get("id"), (int) AppTest.bills.get(i).get("carId"));
		}

		int oneCouponId = 0;
		int oneCarId = Integer.class.cast(AppTest.bills.get(0).get("carId"));
		int couponPosition = 0;

		for(int j = 0; j < AppTest.coupons.size(); j++){
			if (int.class.cast(AppTest.coupons.get(j).get("carId")) == oneCarId){
				oneCouponId = Integer.class.cast(AppTest.coupons.get(j).get("id"));
				couponPosition = j;
				break;
			}
		}
		System.out.println(oneCouponId);

		return new Object[][]{
				{"用优惠券和钱包支付:", billIds, oneCouponId,
				"CASH", Double.parseDouble(AppTest.coupons.get(couponPosition).get("moneyAmount").toString()) , money,
						money - Double.parseDouble(AppTest.coupons.get(couponPosition).get("moneyAmount").toString())},
		};
	}

	@DataProvider(name = "payBillAllWithCoupon")
	public Object[][] payBillAllWithCoupon(){
		int [] billIds = new int[AppTest.bills.size()];
		double money = 0.0;
		for(int i = 0; i < AppTest.bills.size(); i++){
			billIds[i] = Integer.class.cast(AppTest.bills.get(i).get("id"));
			money += double.class.cast(AppTest.bills.get(i).get("money"));
		}

		int oneCouponId = 0;
		int oneCarId = Integer.class.cast(AppTest.bills.get(0).get("carId"));
		int couponPosition = 0;

		for(int j = 0; j < AppTest.coupons.size(); j++){
			if (int.class.cast(AppTest.coupons.get(j).get("carId")) == oneCarId){
				oneCouponId = Integer.class.cast(AppTest.coupons.get(j).get("id"));
				break;
			}
		}

		return new Object[][]{
				{"用优惠券和钱包支付:", billIds, oneCouponId,
						"CASH", Double.parseDouble(AppTest.coupons.get(couponPosition).get("moneyAmount").toString()), money, 0},
		};
	}

	@DataProvider(name = "appealBill")
	public  Object[][] appealBill(){
		return new Object[][]{
				{"账单申诉", "测试账单申诉试试", Integer.class.cast(AppTest.bills.get(0).get("id")), "18819259458"},
				{"账单申诉", "？", Integer.class.cast(AppTest.bills.get(1).get("id")), "18819259458"},
		};
	}

	@DataProvider(name = "modifyPassword")
	public Object[][] modifyPassword(){
		return new Object[][]{
				{"修改密码:",this.mobile,getSHA256StrJava(this.newPassword),AppTest.uuid,AppTest.verifyCode},

		};
	}

	@DataProvider(name = "logOut")
	public Object[][] logOut(){
		return new Object[][]{
				{"退出登录:"},

		};
	}
	
	
}
