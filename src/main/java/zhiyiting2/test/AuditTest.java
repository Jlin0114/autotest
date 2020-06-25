package zhiyiting2.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import zhiyiting2.model.SqlModel;
import zhiyiting2.util.Log4jDemo;

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
				for(int i=0;i<4;i++) {
					//出库过程图片
					logger.info("上报出库过程图片");
					deviceService.uploadDeviceOutFile(35, 20, 62,
							8, deviceNo, serialId, System.currentTimeMillis() / 1000, "1",
							"C:\\Users\\Administrator\\Desktop\\停车自造图片\\出库过程\\p"+i+".png");
					Thread.sleep(1000);
				}
				logger.info("上报出库图片");
				deviceService.uploadDeviceOutFile(35, 20, 62,
						8, deviceNo, serialId, System.currentTimeMillis() / 1000, "0",
						"C:\\Users\\Administrator\\Desktop\\停车自造图片\\出库\\p0.png");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
