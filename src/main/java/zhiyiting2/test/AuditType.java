package zhiyiting2.test;

import com.jcraft.jsch.HASH;
import org.apache.log4j.Logger;
import sun.awt.AWTAccessor;
import zhiyiting2.model.SqlModel;

import javax.swing.text.html.StyleSheet;
import java.util.*;

public class AuditType extends ZTest {


    static Logger logger = Logger.getLogger(AuditTest.class);

        //正常模式--入库
    public void in(Long serialId, String plateNo, String inHandleType) {
        try {
//			Long serialId = System.currentTimeMillis() / 1000;
            deviceService.reportIn(deviceNo, "PREPARE", 12, 25, serialId,
                    System.currentTimeMillis() / 1000);
            // 设备上传8张图片
            for (int i = 1; i < 9; i++) {
            	String url = System.getProperty("user.dir")+"/src/main/resources/image/in/p"+i+".png";
                logger.info("上报入库图片");
                deviceService.uploadDeviceFile(35, 20, 61, 1, 8, deviceNo,
                        serialId, System.currentTimeMillis() / 1000,0, url);
                //C:\Users\DELL\Desktop
                Thread.sleep(1000);
            }
            List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='IN' and a.serial_id='"
                    + serialId.intValue() + "' order by id desc", SqlModel.class);

            if (obj != null && obj.size() > 0) {

                Integer auditId = SqlModel.class.cast(obj.get(0)).getId();
                logger.info("入库审核--auditId:" + auditId);
                parkingService.manualHandleAudit(plateNo, false, false, "SMALL", auditId, inHandleType,
                        null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    //正常模式，出库
    public void out(Long serialId,String outHandleType) {
        try {
            //入库审核后 传取证图 出库  出库图片 出库过程图片  1为出库过程  0为出库图片
            //报出库
            logger.info("上报出库");
            deviceService.reportOut(deviceNo, "OUT", 63, 21,
                    false, serialId, System.currentTimeMillis() / 1000);

            logger.info("上报出库图片");
            deviceService.uploadDeviceOutFile(35, 20, 62,
                    8, deviceNo, serialId, System.currentTimeMillis() / 1000, "0",
                    System.getProperty("user.dir")+"/src/main/resources/image/out/p0.png");
            for (int i = 0; i < 4; i++) {
                //出库过程图片
                String url = System.getProperty("user.dir")+"/src/main/resources/image/outProcess/p"+i+".png";
                logger.info("上报出库过程图片");
                deviceService.uploadDeviceOutFile(35, 20, 62,
                        8, deviceNo, serialId, System.currentTimeMillis() / 1000, "1",
                        url);
                Thread.sleep(1000);
            }

            logger.info("确认出库");
            List<Object> objOut = jdbconn
                    .query("select a.id from audit a where a.audit_type='OUT' and a.serial_id='"
                            + serialId.intValue() + "' order by id desc", SqlModel.class);
            if (objOut != null && objOut.size() > 0) {
                Integer auditIdOut = SqlModel.class.cast(objOut.get(0)).getId();
                logger.info("出库审核--auditOut:" + auditIdOut);
                parkingService.manualHandleAudit(null, null, null, null, auditIdOut, outHandleType, null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }
    //定时模式
    public void period(Long serialId, String plateNo, String periodAuditHandleType) {
        try {
            logger.info("定时模式");
            logger.info("定时模式上报");

            String url = System.getProperty("user.dir")+"/src/main/resources/image/period/period.png";
            deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()),
                    serialId, System.currentTimeMillis() / 1000, url);
            List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
                    + serialId.intValue() + "' order by id desc", SqlModel.class);
            if (obj != null && obj.size() > 0) {
                Integer auditId_in = SqlModel.class.cast(obj.get(0)).getId();
                logger.info("定时审核--auditId_in:" + auditId_in);
                parkingService.manualHandleAudit(plateNo, false, false, "SMALL", auditId_in, periodAuditHandleType,
                        null);
            }
            logger.info("定时模式审核结束");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

    }
    //自动入库
    public void auto_in(Long serialId){
        try {

            logger.info("上报入库");
            deviceService.reportIn(deviceNo, "PREPARE", 12, 25, serialId,
                    System.currentTimeMillis() / 1000);
            // 设备上传8张图片
            for (int i = 1; i < 9; i++) {
                String url = System.getProperty("user.dir")+"/src/main/resources/image/auto_in/p"+i+".png";
                logger.info("上报入库图片");
                deviceService.uploadDeviceFile(35, 20, 61, 1, 8, deviceNo,
                        serialId, System.currentTimeMillis() / 1000, 0,url);
                //C:\Users\DELL\Desktop
                Thread.sleep(1000);
            }
            logger.info("自动入库结束");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

    }

    //自动不出库
    public void auto_noout(Long serialId) {
        try {
            //入库审核后 传取证图 出库过程图片 出库  出库图片 1为出库过程  0为出库图片
            //报出库
            logger.info("上报出库");
            deviceService.reportOut(deviceNo, "OUT", 63, 21,
                    false, serialId, System.currentTimeMillis() / 1000);

            logger.info("上报出库图片");

            deviceService.uploadDeviceOutFile(35, 20, 62,
                    8, deviceNo, serialId, System.currentTimeMillis() / 1000, "0",
                    System.getProperty("user.dir")+"/src/main/resources/image/auto_noout/p1.png");

            for (int i = 0; i < 4; i++) {
                //出库过程图片
                String url = System.getProperty("user.dir")+"/src/main/resources/image/auto_outProcess/p"+i+".png";
                logger.info("上报出库过程图片");
                deviceService.uploadDeviceOutFile(35, 20, 62, 8, deviceNo, serialId,
                        System.currentTimeMillis() / 1000, "1", url);
                Thread.sleep(1000);
            }

            logger.info("确认不出库");


        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }
    //自动出库
    public void auto_out(Long serialId) {
        try {
                      logger.info("上报出库");
            deviceService.reportOut(deviceNo, "OUT", 63, 21,
                    false, serialId, System.currentTimeMillis() / 1000);
            logger.info("上报出库图片");
            deviceService.uploadDeviceOutFile(35, 20, 62,
                    8, deviceNo, serialId, System.currentTimeMillis() / 1000, "0",
                    System.getProperty("user.dir")+"/src/main/resources/image/auto_out/p1.png");
            for (int i = 0; i < 4; i++) {
                //出库过程图片
                String url = System.getProperty("user.dir")+"/src/main/resources/image/auto_outProcess/p"+i+".png";
                logger.info("上报出库过程图片");
                deviceService.uploadDeviceOutFile(35, 20, 62, 8, deviceNo, serialId,
                        System.currentTimeMillis() / 1000, "1", url);
                Thread.sleep(1000);
            }


            logger.info("确认出库");


        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }



    //自动出库失败，手动处理出库
    public void autoOutHandleFail_mannulHandle(Long serialId,String outHandleType) {
        try {
            logger.info("上报出库");
            deviceService.reportOut(deviceNo, "OUT", 63, 21,
                    false, serialId, System.currentTimeMillis() / 1000);

            logger.info("上报出库图片");
            deviceService.uploadDeviceOutFile(35, 20, 62,
                    8, deviceNo, serialId, System.currentTimeMillis() / 1000, "0",
                    System.getProperty("user.dir")+"/src/main/resources/image/auto_out/p9.png");  //p9.png为另一张车牌的图片
            for (int i = 0; i < 4; i++) {
                //出库过程图片
                logger.info("上报出库过程图片");
                deviceService.uploadDeviceOutFile(35, 20, 62, 8, deviceNo, serialId,
                        System.currentTimeMillis() / 1000, "1", "C:\\Users\\DELL\\Desktop\\自动出入库图片\\出库过程\\p" + i + ".png");
                Thread.sleep(1000);
            }

            logger.info("确认出库");
            List<Object> objOut = jdbconn
                    .query("select a.id from audit a where a.audit_type='OUT' and a.serial_id='"
                            + serialId.intValue() + "' order by id desc", SqlModel.class);
            if (objOut != null && objOut.size() > 0) {
                Integer auditIdOut = SqlModel.class.cast(objOut.get(0)).getId();
                parkingService.manualHandleAudit(null, null, null, null, auditIdOut, outHandleType, null);
            }

            logger.info("确认出库");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        //低功耗，自动出库
    public void lowPower_out(Long serialId) {
        try {

            logger.info("上报出库");
            deviceService.reportOut(deviceNo, "OUT", 63, 21,
                    true, serialId, System.currentTimeMillis() / 1000);

            logger.info("上报出库图片");
            deviceService.uploadDeviceOutFile(35, 20, 62,
                    8, deviceNo, serialId, System.currentTimeMillis() / 1000, "0",
                    System.getProperty("user.dir")+"/src/main/resources/image/out/p0.png");

            logger.info("低功耗自动出库");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    public void normal_in_no_do(Long serialId){
        try {
            logger.info("上报入库");
            deviceService.reportIn(deviceNo,"PREPARE", 12, 25, serialId,
                    System.currentTimeMillis() / 1000);
            logger.info("上传入库图片");
            for (int i = 1; i < 9; i++) {
                String url = System.getProperty("user.dir")+"/src/main/resources/image/in/p"+i+".png";
                logger.info("上报入库图片");
                deviceService.uploadDeviceFile(35, 20, 61, 1, 8, deviceNo,
                        serialId, System.currentTimeMillis() / 1000,0, url);
                //C:\Users\DELL\Desktop
                Thread.sleep(1000);
            }
            List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='IN' and a.serial_id='"
                    + serialId.intValue() + "' order by id desc", SqlModel.class);

            if (obj != null && obj.size() > 0) {
                Integer auditId = SqlModel.class.cast(obj.get(0)).getId();

                logger.info("入库审核--auditId:" + auditId);
                parkingService.manualHandleAudit2("IN_NO_DO",auditId,false,3,
                        "跨车格停车",2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //上传取证图
    public void evidence(Long serialId){
        try {
            logger.info("上传取证图");
            String url = System.getProperty("user.dir")+"/src/main/resources/image/evidence/evidence.png";
            deviceService.uploadDeviceFile(35, 20, 61, 1, 8, deviceNo,
                    serialId, System.currentTimeMillis() / 1000,1, url);
            Thread.sleep(5000);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }









}