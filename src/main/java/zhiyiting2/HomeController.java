package zhiyiting2;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import zhiyiting2.model.ResponseModel;
import zhiyiting2.test.deviceManagement.service.DeviceService;
import zhiyiting2.util.URLConnection;

//import zhiyiting2.test.deviceManagement.service.DeviceService;

@Controller
public class HomeController {
	@Autowired
	DeviceService deviceService;
	@Autowired
	URLConnection urlConnection;

	@RequestMapping(value = "/creatAudit", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String creatAudit(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();

		try {
			Long serialId = System.currentTimeMillis() / 1000;
			deviceService.reportIn(Integer.valueOf(request.getParameter("deviceNo")), "PREPARE", 12, 25, serialId,
					System.currentTimeMillis() / 1000);
			// 设备上传图片
			deviceService.uploadDeviceFile(35, 20, 61, 1, 8, Integer.valueOf(request.getParameter("deviceNo")),
					serialId, System.currentTimeMillis() / 1000);
			// 设备出库
			deviceService.reportOut(Integer.valueOf(request.getParameter("deviceNo")), "OUT", 62, 21, false, serialId,
					System.currentTimeMillis() / 1000);
			map.put("message", "出入库成功");
		} catch (Exception e) {
			map.put("message", "出入库失败");
		}

		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "/reportIn")
	@ResponseBody
	public JSONObject reportIn(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();
		ResponseModel resp = new ResponseModel();
		System.out.println(request.getParameter("deviceNo"));
		try {
			Long serialId = System.currentTimeMillis() / 1000;
			deviceService.reportIn(Integer.valueOf(request.getParameter("deviceNo")), "PREPARE", 12, 25, serialId,
					System.currentTimeMillis() / 1000);
			// 设备上传图片
			deviceService.uploadDeviceFile(35, 20, 61, 1, 8, Integer.valueOf(request.getParameter("deviceNo")),
					serialId, System.currentTimeMillis() / 1000);
			map.put("message", "入库成功");
			map.put("serialId", String.valueOf(serialId));
		} catch (Exception e) {
			map.put("message", "入库失败");
		}
		JSONObject result = JSONObject.parseObject(JSON.toJSONString(map));

		return result;
	}

	@RequestMapping(value = "/reportOut")
	@ResponseBody
	public JSONObject reportOut(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(request.getParameter("deviceNo"));
		try {
			// 设备出库
			Long serialId = Long.valueOf(request.getParameter("serialId"));
			deviceService.reportOut(Integer.valueOf(request.getParameter("deviceNo")), "OUT", 62, 21, false, serialId,
					System.currentTimeMillis() / 1000);
			map.put("message", "出库成功");
		} catch (Exception e) {
			map.put("message", "入库失败");
		}
		JSONObject result = JSONObject.parseObject(JSON.toJSONString(map));

		return result;
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	public static void main(String[] args) {
			for(int i=0;i<100;i++) {
				System.out.println(System.currentTimeMillis() / 1000);
			}
	}
}
