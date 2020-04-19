package zhiyiting2.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import zhiyiting2.model.SqlModel;
import zhiyiting2.test.deviceManagement.service.DeviceService;
import zhiyiting2.test.parkingManagement.service.ParkingService;
import zhiyiting2.test.parkingManagement.service.SpecialVehicleService;
import zhiyiting2.util.JDBCConnection;

public class HomeTest extends ZTest {
	@Autowired
	SpecialVehicleService specialVehicleService;
	@Autowired
	DeviceService deviceService;
	@Autowired
	ParkingService parkingService;
	@Autowired
	JDBCConnection jdbconn;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Test(testName = "assertSpecialVehicle", description = "免费车辆停车免费")
	public void assertSpecialVehicle() throws Exception {
		// 创建免费车辆
		Date validStart;
		Date validEnd;

		// 第一辆车 启用 第二辆车 禁用 第三辆车 启用 不在有效期
		// 断言结果 第一辆车 免费 第二辆车和第三辆车 收费
		for (int i = 0; i < assertSpecialVehicleTestplateNos.length; i++) {
			// 设备出入库
			Long serialId = System.currentTimeMillis() / 1000;
			deviceService.reportIn(this.deviceNo, "PREPARE", 12, 25, serialId, System.currentTimeMillis() / 1000);
			// 设备上传图片
			deviceService.uploadDeviceFile(35, 20, 61, 1, 8, this.deviceNo, serialId,
					System.currentTimeMillis() / 1000);
			// 设备出库
			deviceService.reportOut(this.deviceNo, "OUT", 62, 21, false, serialId, System.currentTimeMillis() / 1000);
			if (i == 0) {
				validStart = simpleDateFormat.parse("2020-3-30 00:00:00");
				validEnd = simpleDateFormat.parse("2020-5-30 00:00:00");
				specialVehicleService.addSpecialCar(assertSpecialVehicleTestplateNos[i], 1, validStart, validEnd);
			} else if (i == 1) {
				validStart = simpleDateFormat.parse("2020-3-30 00:00:00");
				validEnd = simpleDateFormat.parse("2020-5-30 00:00:00");
				specialVehicleService.addSpecialCar(assertSpecialVehicleTestplateNos[i], 0, validStart, validEnd);
			} else if (i == 2) {
				validStart = simpleDateFormat.parse("2020-2-30 00:00:00");
				validEnd = simpleDateFormat.parse("2020-3-30 00:00:00");
				specialVehicleService.addSpecialCar(assertSpecialVehicleTestplateNos[i], 1, validStart, validEnd);
			}
			// 入库审核，填入免费车辆
			List<Object> obj = jdbconn.query("select a.id from audit a where a.audit_type='IN' and a.serial_id='"
					+ serialId.intValue() + "' order by id desc", SqlModel.class);
			Integer auditId = SqlModel.class.cast(obj.get(0)).getId();
			parkingService.manualHandleAudit(this.assertSpecialVehicleTestplateNos[i], false, false, "SMALL", auditId,
					"IN", null);
			// 出库审核
			List<Object> objOut = jdbconn.query("select a.id from audit a where a.audit_type='OUT' and a.serial_id='"
					+ serialId.intValue() + "' order by id desc", SqlModel.class);
			Integer auditIdOut = SqlModel.class.cast(objOut.get(0)).getId();
			parkingService.manualHandleAudit(null, null, null, null, auditIdOut, "OUT", null);
			// 调整出入库时间
			List<Object> billRecord = jdbconn.query(
					"select b.id from bill_record b where b.parking_place_id='" + this.placeId + "' order by id desc",
					SqlModel.class);
			if (billRecord != null && billRecord.size() > 0) {
				Integer billRecordId = SqlModel.class.cast(billRecord.get(0)).getId();
				// 调整出入库时间
				parkingService.reviseInOutRecordTime(billRecordId, "2020-03-21 10:00:00", "2020-03-21 12:00:00");
			}
			// 断言 第一辆车 免费 第二辆车 收费 第三辆车 收费
			List<Object> bill = jdbconn.query("select b.id,b.money from bill b where b.plate_no='"
					+ this.assertSpecialVehicleTestplateNos[0] + "' order by id desc", SqlModel.class);
			Double money = SqlModel.class.cast(bill.get(0)).getMoney();
			if (i == 0) {
				if (money > 0) {
					throw new TestAssertException("301", "有效期内的启用状态免费车辆不应该收费！");
				}
			} else if (i == 1) {
				if(money <= 0) {
					throw new TestAssertException("302", "有效期内的禁用状态的免费车辆应该收费！");
				}
			}else if(i == 2) {
				if(money <= 0) {
					throw new TestAssertException("303", "未在有效期的免费车辆不应该免费！");
				}
			}

		}

	}
}
