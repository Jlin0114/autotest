//package zhiyiting2.data;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.testng.annotations.DataProvider;
//
//import zhiyiting2.model.MarketingPlan;
//import zhiyiting2.test.chargeStandardManagement.DiscountsChargeStandard;
//import zhiyiting2.test.operatorManagement.OperatorList;
//
//
//public class DiscountsChargeStandardData {
//	public static String count = "5";
//	@DataProvider(name = "addMarketingPlan")
//	public Object[][] addMarketingPlan() {
//		MarketingPlan d = new MarketingPlan();
//		d.setBriefIntroduction("app描述");
//		d.setCashMinAmount("10");
//		d.setConditionAmount("0.01");
//		d.setCount(count);
//		d.setCouponType("CASH");
//		d.setDescription("测试");
//		d.setGroupCode("888");
//		d.setMoneyAmount("3");
//		d.setName("绑定车辆送优惠券");
//		d.setOperatorId(OperatorList.operatorId);
//		d.setType("COUPON");
//		d.setUserOrderType("BIND_CAR_APPLY");
//		d.setValidDays("2");
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			Date validStart = simpleDateFormat.parse("2020-3-30 00:00:00");
//			Date validEnd = simpleDateFormat.parse("2020-4-30 00:00:00");
//			d.setValidStart(validStart);
//			d.setValidEnd(validEnd);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	       return new Object[][]{
//	               {"新增优惠策略:",d}, 
//	       };
//	   }
//	
//	@DataProvider(name = "editMarketingPlan")
//	public Object[][] editMarketingPlan() {
//		MarketingPlan d = new MarketingPlan();
//		d.setId(DiscountsChargeStandard.marketingPlanId);
//		d.setBriefIntroduction("app描述");
//		d.setCashMinAmount("12");
//		d.setConditionAmount("0.01");
//		d.setCount("5");
//		d.setCouponType("CASH");
//		d.setDescription("测试");
//		d.setGroupCode("888");
//		d.setMoneyAmount("3");
//		d.setName("绑定车辆送优惠券");
//		d.setOperatorId(OperatorList.operatorId);
//		d.setType("COUPON");
//		d.setUserOrderType("BIND_CAR_APPLY");
//		d.setValidDays("2");
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			Date validStart = simpleDateFormat.parse("2020-3-30 00:00:00");
//			Date validEnd = simpleDateFormat.parse("2020-5-30 00:00:00");
//			d.setValidStart(validStart);
//			d.setValidEnd(validEnd);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	       return new Object[][]{
//	               {"编辑优惠策略:",d}, 
//	       };
//	   }
//	
//	@DataProvider(name = "deleteMarketingPlanById")
//	public Object[][] deleteMarketingPlanById() {
//	       return new Object[][]{
//	               {"删除优惠策略:",DiscountsChargeStandard.marketingPlanId,"delete"}, 
//	       };
//	   }
//	
//}
