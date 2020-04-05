package zhiyiting2.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import zhiyiting2.model.ResponseModel;

public class Util {
		public static String getParameter(Map<String,String> map) {
			JSONObject jsonObject = JSONObject.fromObject(map);
			
			return jsonObject.toString();
		}
}
