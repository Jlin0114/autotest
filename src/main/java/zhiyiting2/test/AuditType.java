package zhiyiting2.test;

import org.apache.log4j.Logger;
import zhiyiting2.model.SqlModel;

import java.util.Date;
import java.util.List;

public class AuditType extends ZTest {


    static Logger logger = Logger.getLogger(AuditTest.class);

    public void in(Long serialId, String plateNo, String inHandleType) {
        try {
//			Long serialId = System.currentTimeMillis() / 1000;
            deviceService.reportIn(deviceNo, "PREPARE", 12, 25, serialId,
                    System.currentTimeMillis() / 1000);
            // 设备上传8张图片
            for (int i = 1; i < 9; i++) {
                logger.info("上报入库图片");
                deviceService.uploadDeviceFile(35, 20, 61, 1, 8, deviceNo,
                        serialId, System.currentTimeMillis() / 1000, "C:\\Users\\DELL\\Desktop\\停车自造图片\\入库\\p" + i + ".png");
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
            System.out.println("========================入库审核结束==========================");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    public void out(Long serialId,String outHandleType) {
        try {
            //入库审核后 传取证图 出库过程图片 出库  出库图片 1为出库过程  0为出库图片
            //报出库
            logger.info("上报出库");
            deviceService.reportOut(deviceNo, "OUT", 63, 21,
                    false, serialId, System.currentTimeMillis() / 1000);
            for (int i = 0; i < 4; i++) {
                //出库过程图片
                logger.info("上报出库过程图片");
                deviceService.uploadDeviceOutFile(35, 20, 62,
                        8, deviceNo, serialId, System.currentTimeMillis() / 1000, "1",
                        "C:\\Users\\DELL\\Desktop\\停车自造图片\\出库过程\\p" + i + ".png");
                Thread.sleep(1000);
            }
            logger.info("上报出库图片");
            deviceService.uploadDeviceOutFile(35, 20, 62,
                    8, deviceNo, serialId, System.currentTimeMillis() / 1000, "0",
                    "C:\\Users\\DELL\\Desktop\\停车自造图片\\出库\\p0.png");
            logger.info("确认出库");
            List<Object> objOut = jdbconn
                    .query("select a.id from audit a where a.audit_type='OUT' and a.serial_id='"
                            + serialId.intValue() + "' order by id desc", SqlModel.class);
            if (objOut != null && objOut.size() > 0) {
                Integer auditIdOut = SqlModel.class.cast(objOut.get(0)).getId();
                parkingService.manualHandleAudit(null, null, null, null, auditIdOut, outHandleType, null);
            }
            System.out.println("========================出库审核结束======================");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    public void period_in(Long serialId, String plateNo, String priodInHandleType) {
        try {
            logger.info("定时模式--入库");

            logger.info("定时模式上报");
            deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()),
                    serialId, System.currentTimeMillis() / 1000, "C:\\Users\\DELL\\Desktop\\出入库测试图片\\p5.jpg");
            List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
                    + serialId.intValue() + "' order by id desc", SqlModel.class);
            if (obj != null && obj.size() > 0) {
                Integer auditId_in = SqlModel.class.cast(obj.get(0)).getId();
                logger.info("定时入库审核--auditId_in:" + auditId_in);
                parkingService.manualHandleAudit(plateNo, false, false, "SMALL", auditId_in, priodInHandleType,
                        null);
            }

            System.out.println("================================定时模式入库审核结束=============================");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

    }

    public void period_out(Long serialId,String periodOutHandleType){
        try {
            logger.info("定时模式上报");
            deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()),
                    serialId, System.currentTimeMillis() / 1000, "C:\\Users\\DELL\\Desktop\\出入库测试图片\\p7.jpg");
            List<Object> obj1 = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
                    + serialId.intValue() + "' order by id desc", SqlModel.class);
            if(obj1 != null && obj1.size() > 0) {
                Integer auditId_out = SqlModel.class.cast(obj1.get(0)).getId();
                logger.info("定时审核--auditId_out:"+auditId_out);
                parkingService.manualHandleAudit(null, null, null, null, auditId_out, periodOutHandleType, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

    }





















}