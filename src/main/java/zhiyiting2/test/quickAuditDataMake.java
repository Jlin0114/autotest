package zhiyiting2.test;


import zhiyiting2.model.SqlModel;
import zhiyiting2.test.deviceManagement.service.DeviceService;

import java.util.List;

//后台数据生成
public class quickAuditDataMake extends ZTest {


    public static void main(String[] args) {


    }

    //正常模式--入库
    public void in(Long serialId, String plateNo, String inHandleType) {
        try {
//			Long serialId = System.currentTimeMillis() / 1000;
            deviceService.reportIn(deviceNo, "PREPARE", 12, 25, serialId,
                    System.currentTimeMillis() / 1000);
            // 设备上传8张图片
            for (int i = 1; i < 3; i++) {
                String url = System.getProperty("user.dir") + "/src/main/resources/image/in/p" + i + ".png";
                deviceService.uploadDeviceFile(35, 20, 61, 1, 8, deviceNo,
                        serialId, System.currentTimeMillis() / 1000, 0, url);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}