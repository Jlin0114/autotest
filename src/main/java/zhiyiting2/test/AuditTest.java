package zhiyiting2.test;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import zhiyiting2.model.SqlModel;

/**
 * 审核列表处理审核单
 * 
 * @author zhaoming
 *
 */
public class AuditTest extends ZTest{
	static Logger logger = Logger.getLogger(AuditTest.class);
	//正常模式  入库  出库 先做最简单的情况 图片是没有车牌的  无法识别车牌 没有审核单堆积 做一个审核单就处理一个
	public void in_out() {
		try {
			creatRoad.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");
			logger.info("正常模式--入库  正常模式--出库");
			Long serialId = System.currentTimeMillis() / 1000;
			deviceService.reportIn(deviceNo, "PREPARE", 12, 25, serialId,
					System.currentTimeMillis() / 1000);
			// 设备上传8张图片
			for(int i=1;i<9;i++) {
				logger.info("上报入库图片");
				deviceService.uploadDeviceFile(35, 20, 61, 1, 8, deviceNo,
						serialId, System.currentTimeMillis() / 1000,"C:\\Users\\Administrator\\Desktop\\停车自造图片\\入库\\p"+i+".png");
				Thread.sleep(1000);
			}
			List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='IN' and a.serial_id='"
					+ serialId.intValue() + "' order by id desc", SqlModel.class);
			if(obj != null && obj.size() > 0) {
				Integer auditId = SqlModel.class.cast(obj.get(0)).getId();
				logger.info("入库审核--auditId:"+auditId);
				parkingService.manualHandleAudit(plateNo, false, false, "SMALL", auditId, "IN",
						null);
				//入库审核后 传取证图 出库过程图片 出库  出库图片 1为出库过程  0为出库图片
				//报出库
				logger.info("上报出库");
				deviceService.reportOut(deviceNo, "OUT", 63, 21, 
						false, serialId, System.currentTimeMillis() / 1000);
				logger.info("上报出库图片");
				deviceService.uploadDeviceOutFile(35, 20, 62,
						8, deviceNo, serialId, System.currentTimeMillis() / 1000, "0",
						"C:\\Users\\Administrator\\Desktop\\停车自造图片\\出库\\p0.png");
				for(int i=0;i<4;i++) {
					//出库过程图片
					logger.info("上报出库过程图片");
					deviceService.uploadDeviceOutFile(35, 20, 62,
							8, deviceNo, serialId, System.currentTimeMillis() / 1000, "1",
							"C:\\Users\\Administrator\\Desktop\\停车自造图片\\出库过程\\p"+i+".png");
					Thread.sleep(1000);
				}
				logger.info("确认出库");
				List<Object> objOut = jdbconn
						.query("select a.id from audit a where a.audit_type='OUT' and a.serial_id='"
								+ serialId.intValue() + "' order by id desc", SqlModel.class);
				if(objOut != null && objOut.size() > 0) {
					Integer auditIdOut = SqlModel.class.cast(objOut.get(0)).getId();
					parkingService.manualHandleAudit(null, null, null, null, auditIdOut, "OUT", null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
	}
	
	//定时模式入库   定时模式出库
	public void periodModeIn_periodModeOut() {
		try {
			creatRoad.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");
			logger.info("定时模式--入库  定时模式--出库");
			Long serialId = System.currentTimeMillis() / 1000;
			logger.info("定时模式上报");
			deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()), 
					serialId, System.currentTimeMillis() / 1000, "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p5.jpg");
			List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
					+ serialId.intValue() + "' order by id desc", SqlModel.class);
			if(obj != null && obj.size() > 0) {
				Integer auditId_in = SqlModel.class.cast(obj.get(0)).getId();
				logger.info("定时入库--auditId_in:"+auditId_in);
				parkingService.manualHandleAudit(plateNo, false, false, "SMALL", auditId_in, "PERIOD_IN",
						null);
				logger.info("定时模式上报");
				deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()), 
						serialId, System.currentTimeMillis() / 1000, "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p7.jpg");
				List<Object> obj1 = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
						+ serialId.intValue() + "' order by id desc", SqlModel.class);
				if(obj1 != null && obj1.size() > 0) {
					Integer auditId_out = SqlModel.class.cast(obj1.get(0)).getId();
					logger.info("定时出库--auditId_out:"+auditId_out);
					parkingService.manualHandleAudit(null, null, null, null, auditId_out, "PERIOD_OUT", null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	//定时模式入库   定时模式保持  正常模式出库
	public void periodModeIn_periodModeKeep_out() {
		try {
			creatRoad.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");
			logger.info("定时模式--入库  定时模式--保持不变  正常模式--出库");
			Long serialId = System.currentTimeMillis() / 1000;
			logger.info("定时模式上报");
			deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()), 
					serialId, System.currentTimeMillis() / 1000, "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p5.jpg");
			List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
					+ serialId.intValue() + "' order by id desc", SqlModel.class);
			if(obj != null && obj.size() > 0) {
				Integer auditId_in = SqlModel.class.cast(obj.get(0)).getId();
				logger.info("定时入库--auditId_in:"+auditId_in);
				parkingService.manualHandleAudit(plateNo, false, false, "SMALL", auditId_in, "PERIOD_IN",
						null);
				logger.info("定时模式上报");
				deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()), 
						serialId, System.currentTimeMillis() / 1000, "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p7.jpg");
				List<Object> obj1 = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
						+ serialId.intValue() + "' order by id desc", SqlModel.class);
				if(obj1 != null && obj1.size() > 0) {
					Integer auditId_out = SqlModel.class.cast(obj1.get(0)).getId();
					logger.info("保持不变--auditId_out:"+auditId_out);
					parkingService.manualHandleAudit(null, null, null, null, auditId_out, "PERIOD_KEEP", null);
					
					Long serialIdOut = System.currentTimeMillis() / 1000;
					logger.info("上报出库");
					deviceService.reportOut(deviceNo, "OUT", 63, 21, 
							false, serialIdOut, System.currentTimeMillis() / 1000);
					logger.info("上报出库图片");
					deviceService.uploadDeviceOutFile(35, 20, 62,
							8, deviceNo, serialIdOut, System.currentTimeMillis() / 1000, "0",
							"C:\\Users\\Administrator\\Desktop\\停车自造图片\\出库\\p0.png");
					Thread.sleep(1000);
					for(int i=0;i<4;i++) {
						//出库过程图片
						logger.info("上报出库过程图片");
						deviceService.uploadDeviceOutFile(35, 20, 62,
								8, deviceNo, serialIdOut, System.currentTimeMillis() / 1000, "1",
								"C:\\Users\\Administrator\\Desktop\\停车自造图片\\出库过程\\p"+i+".png");
						Thread.sleep(1000);
					}
					logger.info("确认出库");
					List<Object> objOut = jdbconn
							.query("select a.id from audit a where a.audit_type='OUT' and a.serial_id='"
									+ serialIdOut.intValue() + "' order by id desc", SqlModel.class);
					if(objOut != null && objOut.size() > 0) {
						Integer auditIdOut = SqlModel.class.cast(objOut.get(0)).getId();
						parkingService.manualHandleAudit(null, null, null, null, auditIdOut, "OUT", null);
					}
					
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	
	}
	
	//定时入库 定时保持  定时出库
	public void periodModeIn_periodModeKeep_periodModeOut() {

		try {
			creatRoad.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");
			logger.info("定时模式--入库  定时模式--保持不变  正常模式--出库");
			Long serialId = System.currentTimeMillis() / 1000;
			logger.info("定时模式上报");
			deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()), 
					serialId, System.currentTimeMillis() / 1000, "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p5.jpg");
			List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
					+ serialId.intValue() + "' order by id desc", SqlModel.class);
			if(obj != null && obj.size() > 0) {
				Integer auditId_in = SqlModel.class.cast(obj.get(0)).getId();
				logger.info("定时入库--auditId_in:"+auditId_in);
				parkingService.manualHandleAudit(plateNo, false, false, "SMALL", auditId_in, "PERIOD_IN",
						null);
				Thread.sleep(1000);
				logger.info("定时模式上报");
				deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()), 
						serialId, System.currentTimeMillis() / 1000, "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p7.jpg");
				List<Object> obj1 = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
						+ serialId.intValue() + "' order by id desc", SqlModel.class);
				if(obj1 != null && obj1.size() > 0) {
					Integer auditId_keep = SqlModel.class.cast(obj1.get(0)).getId();
					logger.info("保持不变--auditId_keep:"+auditId_keep);
					parkingService.manualHandleAudit(null, null, null, null, auditId_keep, "PERIOD_KEEP", null);
					
					Thread.sleep(2000);
					logger.info("定时模式上报");
					deviceService.uploadDevicePeriodModeFile(deviceNo, sdf.format(new Date()), 
							serialId, System.currentTimeMillis() / 1000, "C:\\Users\\Administrator\\Desktop\\出入库测试图片\\p7.jpg");
					List<Object> obj2 = jdbconn.query("select a.id from audit a where a.audit_type='PERIOD' and a.serial_id='"
							+ serialId.intValue() + "' order by id desc", SqlModel.class);
					if(obj2 != null && obj2.size() > 0) {
						Integer auditId_out = SqlModel.class.cast(obj2.get(0)).getId();
						logger.info("定时出库--auditId_out:"+auditId_out);
						parkingService.manualHandleAudit(null, null, null, null, auditId_out, "PERIOD_OUT", null);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	
	
	}
	
	
	
	
	
	
}
