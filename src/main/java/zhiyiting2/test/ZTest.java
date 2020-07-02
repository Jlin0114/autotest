package zhiyiting2.test;

import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhiyiting2.app.service.AppService;
import zhiyiting2.test.chargeStandardManagement.service.ChargeStandardService;
import zhiyiting2.test.deviceManagement.service.DeviceService;
import zhiyiting2.test.operatorManagement.service.OperatorService;
import zhiyiting2.test.parkingManagement.service.ParkingRoadService;
import zhiyiting2.test.parkingManagement.service.ParkingService;
import zhiyiting2.test.parkingManagement.service.SpecialVehicleService;
import zhiyiting2.test.workerManagement.service.WorkerService;
import zhiyiting2.util.JDBCConnection;
import zhiyiting2.util.URLConnection;

//@ContextConfiguration(locations = { "classpath*:spring-config.xml" })
public class ZTest {
	SpecialVehicleService specialVehicleService;
	DeviceService deviceService;
	ParkingService parkingService;
	JDBCConnection jdbconn;
	ChargeStandardService chargeStandardService;
	OperatorService operatorService;
	ParkingRoadService parkingRoadService;
	URLConnection urlConnection;
	AppService appService;
	CreatRoad creatRoad;
	WorkerService workerService;
	public static Integer operatorId=0;
	public static Integer chargeStandardId=0;
	public static Integer roadId=0;
	public static Integer workerId=0;
	public static String deviceNo="112233445566778";
	public static String plateNo = "云L54321";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public static Integer placeId=0;
	
	public ZTest() {
		ApplicationContext application = new ClassPathXmlApplicationContext("spring-config.xml");
		this.appService = application.getBean(AppService.class);
		this.specialVehicleService = application.getBean(SpecialVehicleService.class);
		this.deviceService = application.getBean(DeviceService.class);
		this.parkingService = application.getBean(ParkingService.class);
		this.jdbconn = application.getBean(JDBCConnection.class);
		this.chargeStandardService = application.getBean(ChargeStandardService.class);
		this.operatorService = application.getBean(OperatorService.class);
		this.parkingRoadService = application.getBean(ParkingRoadService.class);
		this.urlConnection = application.getBean(URLConnection.class);
		this.creatRoad = application.getBean(CreatRoad.class);
		this.workerService = application.getBean(WorkerService.class);
	}
	
	
}
