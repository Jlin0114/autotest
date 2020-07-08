package zhiyiting2.app;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Reporter;
import zhiyiting2.app.service.AppService;
import zhiyiting2.test.ZTest;
import zhiyiting2.test.chargeStandardManagement.service.ChargeStandardService;
import zhiyiting2.test.deviceManagement.service.DeviceService;
import zhiyiting2.test.operatorManagement.service.OperatorService;
import zhiyiting2.test.parkingManagement.service.ParkingRoadService;
import zhiyiting2.test.parkingManagement.service.ParkingService;
import zhiyiting2.test.workerManagement.service.WorkerService;
import zhiyiting2.util.JDBCConnection;
import zhiyiting2.util.URLConnection;

import java.util.HashMap;

public class AppLogin extends ZTest {
    @Autowired
    ParkingService parkingService;
    @Autowired
    ChargeStandardService chargeStandardService;
    @Autowired
    DeviceService deviceService;
    @Autowired
    OperatorService operatorService;
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
    public static  String cookie="";

    public static String appLogin(){

        try {
            URLConnection urlConnection = new URLConnection();
            String password="45A3B0FD8F88841DEDC0A5BC04325D938BB3F16D68A561F34BEB43C530B4F115";
            String mobile="16620992099";

            //ios登录
            String deviceTokenType="IOS";
            String deviceToken="3cf7cad799db1bbfd6a084df49d1c27b1ca52c0a34de0f94909877dd417fa330";
            //安卓登录



            HashMap<String, String> map = new HashMap<String, String>();
            map.put("password",password);
            map.put("mobile",mobile);
            map.put("deviceTokenType",deviceTokenType);
            map.put("passwdeviceTokenord",deviceToken);

            JSONObject jsonObject = JSONObject.fromObject(map);
            Reporter.log("登录");
            Reporter.log("请求参数："+jsonObject.toString());

            cookie= urlConnection.doPost(Constant.app_login_Url, jsonObject.toString());


        } catch (Exception e) {
            e.printStackTrace();


        }
        return cookie;
    }


    public void bindCar(){
        String plateNo="苏M99999";
        try {
            uRLConnection.doPost(Constant.bindCar_Url,plateNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

