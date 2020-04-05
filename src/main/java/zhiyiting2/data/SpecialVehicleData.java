package zhiyiting2.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.DataProvider;

import zhiyiting2.test.parkingManagement.SpecialVehicle;

public class SpecialVehicleData {
	public static String specialCar="吉AKJ500";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@DataProvider(name = "addSpecialCar")
	public Object[][] addSpecialCar() {
		Date validStart=null;
		Date validEnd=null;
		try {
			validStart = simpleDateFormat.parse("2020-3-30 00:00:00");
			validEnd = simpleDateFormat.parse("2020-5-30 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
	       return new Object[][]{
	               {"新增路边免费车辆:",this.specialCar,1,validStart,validEnd},
	               
	       };
	   }
	@DataProvider(name = "updateSpecialCar")
	public Object[][] updateSpecialCar() {
		Date validStart=null;
		Date validEnd=null;
		try {
			validStart = simpleDateFormat.parse("2020-3-30 00:00:00");
			validEnd = simpleDateFormat.parse("2020-5-30 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
	       return new Object[][]{
	               {"编辑路边免费车辆:",SpecialVehicle.specialCarId,this.specialCar,0,validStart,validEnd},
	               
	       };
	   }
	@DataProvider(name = "deleteSpecialCar")
	public Object[][] deleteSpecialCar() {
	       return new Object[][]{
	               {"删除路边免费车辆:",SpecialVehicle.specialCarId},
	               
	       };
	   }
}
