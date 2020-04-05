package zhiyiting2.test.chargeStandardManagement.service;

import zhiyiting2.model.MarketingPlan;
import zhiyiting2.model.ResponseModel;

public interface ChargeStandardService {
	public ResponseModel addMarketingPlan(MarketingPlan mp) throws Exception;

	public void editMarketingPlan(MarketingPlan mp) throws Exception;

	public void deleteMarketingPlanById(Integer marketingPlanId, String type) throws Exception;

	public ResponseModel addChargeStandardMultipleInfo(Integer provinceId, Integer cityId, String chargeStandardName,
			String areaType, Integer chargeSort, Integer newEnergyDiscount, Boolean distNotWorkDay,
			Boolean distVehicleType, Object[] dayChargeStandardList) throws Exception;

	public ResponseModel addPeriodRuleItem(Integer operatorId, Integer cityId, int[] parkingRoadIds,
			Boolean supportMutual, Double price, Integer month, Boolean enable, Integer containParkingLot,
			Integer containParkingRoad) throws Exception;
}
