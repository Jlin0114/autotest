package zhiyiting2.test;


import zhiyiting2.model.SqlModel;
import zhiyiting2.test.deviceManagement.service.DeviceService;

import java.util.List;
import java.util.Random;

//后台数据生成
public class quickAuditDataMake extends ZTest {


    public static void main(String[] args) {


        quickAuditDataMake make = new quickAuditDataMake();

        for (int i=1;i<1500;i++) {
            long serialId = System.currentTimeMillis() / 1000;
            make.in(serialId);
            make.out(serialId);
        }

    }

    public String getplateNo(){
        String[] city = {"京","津", "沪","渝","冀",
                "豫","云", "辽","黑","湘",
                "皖","鲁", "新","苏","浙",
                "赣","鄂", "桂","甘","晋",
                "蒙","陕", "吉","闽","贵",
                "粤","青", "藏","川","宁", "琼"
        };
        String[] letter = { "A", "B", "C", "D", "E", "F", "G", "H",
                "J", "K", "L", "M", "N", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z" };


        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(city[new Random().nextInt(31)])
                .append(letter[new Random().nextInt(24)]);
        for (int i = 0; i < 5; i++) {
            stringBuffer.append(new Random().nextInt(10));
        }
        String plateNo = stringBuffer.toString();


        return plateNo;
    }

    //正常模式--入库
    public void in(Long serialId) {
        try {
//			Long serialId = System.currentTimeMillis() / 1000;
            deviceService.reportIn(deviceNo, "PREPARE", 12, 25, serialId,
                    System.currentTimeMillis() / 1000);
            // 设备上传8张图片
            for (int i = 1; i < 2; i++) {
                String url = System.getProperty("user.dir") + "/src/main/resources/image/in/p" + i + ".png";
                deviceService.uploadDeviceFile(35, 20, 61, 1, 8, deviceNo,
                        serialId, System.currentTimeMillis() / 1000, 0, url);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void out(Long serialId) {
        try {
            //入库审核后 传取证图 出库  出库图片 出库过程图片  1为出库过程  0为出库图片
            //报出库
            deviceService.reportOut(deviceNo, "OUT", 63, 21,
                    false, serialId, System.currentTimeMillis() / 1000);
            deviceService.uploadDeviceOutFile(35, 20, 62,
                    8, deviceNo, serialId, System.currentTimeMillis() / 1000, "0",
                    System.getProperty("user.dir")+"/src/main/resources/image/out/p0.png");
            for (int i = 0; i < 1; i++) {    //4
                //出库过程图片
                String url = System.getProperty("user.dir")+"/src/main/resources/image/outProcess/p"+i+".png";
                deviceService.uploadDeviceOutFile(35, 20, 62,
                        8, deviceNo, serialId, System.currentTimeMillis() / 1000, "1",
                        url);
//                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}