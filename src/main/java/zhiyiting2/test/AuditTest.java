package zhiyiting2.test;

import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import zhiyiting2.model.SqlModel;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * 审核列表处理审核单
 * 
 * @author zhaoming
 *
 */

public class AuditTest extends ZTest{


    AuditType auditType = new AuditType();



    @BeforeTest
    public void init(){

        AuditType auditType = new AuditType();

        try {
            ManagerLogin.login("", "zhaoming", "9c5946d01d87b796cff3593166ae327e05c242ac5b3317a843964b789ddcfecb");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test(testName = "正常模式，入库-出库")
//@Parameters("auditType")
    public void normal_in_outTest(){
    AuditType.logger.info("正常模式  入库  出库 ");
    long serialId1 = System.currentTimeMillis() / 1000;
    auditType.in(serialId1,plateNo,"IN");
    auditType.out(serialId1,"OUT");


}
@Test(testName = "正常模式，入库-入库")
//    @Parameters("auditType")
    public void normal_in_inTest(){

    AuditType.logger.info("正常模式  入库  入库");
    long serialId1 = System.currentTimeMillis() / 1000;
    auditType.in(serialId1,plateNo,"IN");
    long serialId2 = System.currentTimeMillis() / 1000;
    auditType.in(serialId2,plateNo1,"IN");

}
@Test(testName = "正常模式，入库-出库-入库")

    public void normal_in_out_inTest(){

    AuditType.logger.info("正常模式，入库-出库-入库");
    long serialId1 = System.currentTimeMillis() /1000;

    auditType.in(serialId1,plateNo,"IN");
    auditType.out(serialId1,"OUT");
    long serialId2 = System.currentTimeMillis() / 1000;
    auditType.in(serialId2,plateNo1,"IN");
}

//    @Test(testName = "正常模式，入库-出库-出库")
//    public void normal_in_out_outTest(){
//        System.out.println("正常模式，入库-出库-出库  开始======================================");
//        AuditType.logger.info("正常模式，入库-出库-出库");
//        long serialId1 = System.currentTimeMillis() /1000;
//        auditType.in(serialId1,plateNo,"IN");
//        auditType.out(serialId1, "OUT");
//        long serialId2 = System.currentTimeMillis() / 1000;
//        auditType.out(serialId2,"OUT");
//        System.out.println("正常模式，入库-出库-出库  结束======================================");
//    }

    @Test(testName = "正常模式，入库-入库-出库")

    public void normal_in_in_outTest(){


        AuditType.logger.info("正常模式，入库-入库-出库");

        long serialId1 = System.currentTimeMillis() /1000;
        auditType.in(serialId1,plateNo,"IN");

        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2,plateNo1,"IN");
        auditType.out(serialId2, "OUT");

    }


    @Test(testName = "正常模式，入库-不出库-入库")
    public void normal_in_noout_inTest(){

        AuditType.logger.info("正常模式，入库-不出库-入库");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.in(serialId1,plateNo,"IN");
        auditType.out(serialId1,"NO_OUT");
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2,plateNo1,"IN");


    }

    @Test(testName = "正常模式，入库-不出库-出库")
    public void normal_in_noout_outTest(){


        AuditType.logger.info("正常模式，入库-不出库-出库");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.in(serialId1,plateNo,"IN");
        auditType.out(serialId1,"NO_OUT");
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.out(serialId2,"OUT");


    }

    @Test(testName = "定时模式, 入库-出库")
    public void period_in_outTest(){

        AuditType.logger.info("定时模式，入库-出库");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.period(serialId1, plateNo, "PERIOD_IN");

        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.period(serialId2,null,"PERIOD_OUT");



    }

    @Test(testName = "定时模式，入库-保持不变-出库")
    public void period_in_keep_in(){
        AuditType.logger.info("定时模式，入库-保持不变-出库");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.period(serialId1,plateNo,"PERIOD_IN");

        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.period(serialId2,null,"PERIOD_KEEP");

        long serialId3 = System.currentTimeMillis() / 1000;
        auditType.period(serialId3,null,"PERIOD_OUT");

    }

    @Test(testName = "定时模式-入库-保持不变，正常模式-出库")
    public void period_in_keep_normalinTest(){

        AuditType.logger.info("定时模式-入库-保持不变，正常模式-出库");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.period(serialId1,plateNo,"PERIOD_IN");
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.period(serialId1,null,"PERIOD_KEEP");
        long serialId3 = System.currentTimeMillis() / 1000;
        auditType.out(serialId3,"OUT");


    }


    @Test(testName = "定时模式-入库-保持不变，正常模式-入库")
    public void period_in_keep_normalin(){
    AuditType.logger.info("定时模式-入库-保持不变，正常模式-入库");
    long serialId1 = System.currentTimeMillis() / 1000;
    auditType.period(serialId1,plateNo,"PERIOD_IN");

    long serialId2 = System.currentTimeMillis() / 1000;
    auditType.period(serialId2,null,"PERIOD_KEEP");

    long serialId3 = System.currentTimeMillis() / 1000;
    auditType.in(serialId3,plateNo1,"IN");
    }


    @Test(testName = "正常模式-入库-合并")
    public void normal_in_inMerge(){
        AuditType.logger.info("正常模式-入库-合并");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.in(serialId1,plateNo,"IN");
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2,null,"IN_MERGE");

    }

	@Test(testName="正常模式-入库-确认不出库，定时模式-保持不变，正常模式-确认不出库-合并")
    public void normal_in_noout_PeriodKeep_normal_noout_inmerge(){
        AuditType.logger.info("正常模式-入库-确认不出库，定时模式-保持不变，正常模式-确认不出库-合并");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.in(serialId1,plateNo,"IN");
        auditType.out(serialId1,"NO_OUT");

        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.period(serialId2,null,"PERIOD_KEEP");

        long serialId3 = System.currentTimeMillis() / 1000;
        auditType.out(serialId3,"NO_OUT");

        long serialId4 = System.currentTimeMillis() / 1000;
        auditType.in(serialId4,null,"IN_MERGE");
    }

    @Test(testName = "定时模式-入库，正常模式-合并")
    public void period_in_normalKeep(){
        AuditType.logger.info("定时模式-入库，正常模式-合并");

        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.period(serialId1,plateNo,"PERIOD_IN");
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2,null,"IN_MERGE");
    }

    @Test(testName = "定时模式-入库，正常模式-确认不出库-合并")
    public void period_in_normal_noout_inmerge(){
        AuditType.logger.info("定时模式-入库，正常模式-确认不出库-合并");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.period(serialId1,plateNo,"PERIOD_IN");
        auditType.out(serialId1,"NO_OUT");
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2,null,"IN_MERGE");
    }

    @Test(testName = "定时模式-入库-保持不变，正常模式-合并")
    public void period_in_keep_normal_inMerge() {
        AuditType.logger.info("定时模式-入库-保持不变，正常模式-合并");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.period(serialId1, plateNo, "PERIOD_IN");
        auditType.period(serialId1, null, "PERIOD_KEEP");
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2,null,"IN_MERGE");


    }


    @Test(testName = "定时模式-入库-保持不变，正常模式-确认不出库，定时模式-保持不变")
    public void period_in_keep_normal_noout_period_keep(){
        AuditType.logger.info("定时模式-入库-保持不变，正常模式-确认不出库，定时模式-保持不变");

        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.period(serialId1,plateNo,"PERIOD_IN");

        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.period(serialId2,null,"PERIOD_KEEP");

        long serialId3 = System.currentTimeMillis() / 1000;
        auditType.out(serialId3,"NO_OUT");

        long serialId4 = System.currentTimeMillis() / 1000;
        auditType.period(serialId4,null,"PERIOD_KEEP");
    }

    @Test(testName = "正常模式-入库-确认不出库-合并")
    public void normal_in_noout_inMerge(){
        AuditType.logger.info("正常模式-入库-确认不出库-合并");

        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.in(serialId1,plateNo,"IN");
        auditType.out(serialId1,"NO_OUT");

        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2,null,"IN_MERGE");
    }


    @Test(testName = "自动入库-自动确认不出库-自动合并-自动出库")
    public void auto_in_noout_inMerge(){

        AuditType.logger.info("自动入库-自动确认不出库-自动合并-自动出库（识别不到车牌)");
//
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.auto_in(serialId1);
        auditType.auto_noout(serialId1);
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.auto_in(serialId2);
        auditType.auto_out(serialId2);
    }


    @Test(testName = "自动入库，手动出库")
    public void auto_in_manual_out(){

        //手动出库---(出库识别的车牌与最近一条入库识别的车牌不一致,无法自动出库)
        AuditType.logger.info("自动入库，手动出库");
        Long serialId1 = System.currentTimeMillis() / 1000;
        auditType.auto_in(serialId1);

        //自动入库的时候，只有自动出库失败，也就是识别到的图片无法自动出库，也无法自动不出库，才能手动处理
        //失败情况模拟：自动入库车牌号为A，出库图片识别到的车牌号为B
        auditType.autoOutHandleFail_mannulHandle(serialId1,"OUT");


    }

    @Test(testName = "自动入库，手动不出库，手动合并，自动出库")
    public void auto_in_mannual_noout_mannul_inMerge_auto_out() {

        AuditType.logger.info("自动入库，手动不出库，手动合并，自动出库");

        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.auto_in(serialId1);
        auditType.autoOutHandleFail_mannulHandle(serialId1, "NO_OUT");
        Long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2, null, "IN_MERGE");

        auditType.auto_out(serialId2);
    }























}
