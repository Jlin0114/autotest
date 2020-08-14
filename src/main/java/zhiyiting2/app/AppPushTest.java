package zhiyiting2.app;


import org.aspectj.lang.annotation.Before;
import org.springframework.test.context.jdbc.Sql;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import zhiyiting2.model.SqlModel;
import zhiyiting2.test.AuditType;
import zhiyiting2.test.ManagerLogin;
import zhiyiting2.test.ZTest;
import zhiyiting2.util.JDBCConnection;
import zhiyiting2.util.plateNoUtils;

import java.util.List;

public class AppPushTest extends ZTest {
    public static String cookie="";
    plateNoUtils plateNoUtils = new plateNoUtils();
    String plateNo = plateNoUtils.getPlateNo();

    @BeforeTest()
    public void login(){
        try {
            //后台登录
            ManagerLogin.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");
            //智优停  IOS  app登录
            cookie=AppLogin.appLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "")
    public void bindCarTest() {
        try {
            //绑定车辆
            Integer carId = appService.bindCar(plateNo).getCarId();
            //上传行驶证图片
            appService.uploadFileNew();
            //行驶证提交审核
            appService.bindApply(plateNo,"987654321");
            //后台行驶证审核驳回

//            List<Object> objUser = JDBCConnection.query("select user.id from user where user.mobile= '16620997273'", SqlModel.class);
//            Integer userId = SqlModel.class.cast(objUser.get(0)).getId();
//            JDBCConnection.query("select")
            //再次提交行驶证审核
            appService.uploadFileNew();
            //行驶证提交审核
            appService.bindApply(plateNo,"987654321");
            //后台行驶证申请通过

            //路边停车入库-出库
            AuditType auditType = new AuditType();
            long serialId = System.currentTimeMillis() / 1000;
            auditType.in(serialId,plateNo,"IN");
            auditType.out(serialId,"OUT");

            //支付账单



            //绑定驾驶证上传，前提是改账号没有待审核的驾驶证
            appService.bindApply(null,"1111111");
            //后台审核不通过


            //再次绑定驾驶证
            appService.bindApply(null,"222222");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("绑定车辆失败");
        }

    }

    @Test
    public void in_outTest(){

    }




}
