package zhiyiting2.test;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
import org.testng.Reporter;
import org.testng.annotations.Test;
import zhiyiting2.util.Constant;
import zhiyiting2.util.ParameterData;
import zhiyiting2.util.URLConnection;

import java.util.HashMap;
import java.util.Map;

@Component
public class ManagerLogin {

    public static String cookie = "";

    @Test(testName = "login", description = "登录", dataProvider = "login", dataProviderClass = ParameterData.class)
    public static void login(String testname, String managerCode, String managerPassword) throws Exception {
        URLConnection conn = new URLConnection();
        Map<String, String> map = new HashMap<String, String>();
        map.put("managerCode", managerCode);
        map.put("managerPassword", managerPassword);
        JSONObject jsonObject = JSONObject.fromObject(map);
        Reporter.log("请求参数:" + jsonObject.toString());
        cookie = conn.doPost(Constant.loginUrl, jsonObject.toString());
    }
}
