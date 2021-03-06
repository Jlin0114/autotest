package zhiyiting2.test;

import org.apache.http.auth.AUTH;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


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

        try {
            ManagerLogin.login("", "zhangjialin", "f6eabb6eba9afe7283bc456cf454a7bf5a0fa3960c775a91fe55f829b3bf7af5");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test(testName = "正常模式,入库-出库")
    public void normal_in_outTest(){
        try {



            for (int i=0;i<5;i++) {
                AuditType.logger.info("正常模式  入库  出库 ");
                long serialId1 = System.currentTimeMillis() / 1000;
                auditType.in(serialId1,plateNo ,"IN");

//                auditType.evidence(serialId1);
                auditType.out(serialId1,"OUT");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(testName = "正常模式，入库-入库")
    public void normal_in_inTest(){

        try {
            AuditType.logger.info("正常模式  入库  入库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.in(serialId1,plateNo,"IN");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,plateNo1,"IN");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test(testName = "正常模式，入库-出库-入库")

    public void normal_in_out_inTest(){

        try {
            AuditType.logger.info("正常模式，入库-出库-入库");
            long serialId1 = System.currentTimeMillis() /1000;

            auditType.in(serialId1,plateNo,"IN");
            auditType.evidence(serialId1);
            auditType.out(serialId1,"OUT");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,plateNo1,"IN");
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        try {
            long serialId1 = System.currentTimeMillis() /1000;
            auditType.in(serialId1,plateNo,"IN");

            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,plateNo1,"IN");
            auditType.evidence(serialId2);
            auditType.out(serialId2, "OUT");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test(testName = "正常模式，入库-不出库-入库")
    public void normal_in_noout_inTest(){

        try {
            AuditType.logger.info("正常模式，入库-不出库-入库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.in(serialId1,plateNo,"IN");
            auditType.evidence(serialId1);
            auditType.out(serialId1,"NO_OUT");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,plateNo1,"IN");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test(testName = "正常模式，入库-不出库-出库")
    public void normal_in_noout_outTest(){


        try {
            AuditType.logger.info("正常模式，入库-不出库-出库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.in(serialId1,plateNo,"IN");

            auditType.evidence(serialId1);
            auditType.out(serialId1,"NO_OUT");
            long serialId2 = System.currentTimeMillis() / 1000;

            auditType.evidence(serialId2);
            auditType.out(serialId2,"OUT");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test(testName = "定时入库-定时出库")
    public void period_in_outTest(){

        try {
            AuditType.logger.info("定时入库-定时出库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.period(serialId1, plateNo, "PERIOD_IN");

            long serialId2 = System.currentTimeMillis() / 1000;

            auditType.period(serialId2,null,"PERIOD_OUT");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test(testName = "定时入库-定时保持-定时出库")
    public void period_in_keep_inTest(){
        try {
            AuditType.logger.info("定时入库-定时保持-定时出库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.period(serialId1,plateNo,"PERIOD_IN");

            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.period(serialId2,null,"PERIOD_KEEP");

            long serialId3 = System.currentTimeMillis() / 1000;
            auditType.period(serialId3,null,"PERIOD_OUT");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(testName = "定时入库-定时保持，正常模式-出库")
    public void period_in_keep_normaloutTest(){

        try {
            AuditType.logger.info("定时入库-定时保持，正常模式-出库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.period(serialId1,plateNo,"PERIOD_IN");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.period(serialId2,null,"PERIOD_KEEP");
            long serialId3 = System.currentTimeMillis() / 1000;
            auditType.evidence(serialId3);
            auditType.out(serialId3,"OUT");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test(testName = "定时入库-定时保持，正常模式-入库")
    public void period_in_keep_normalinTest(){
        try {
            AuditType.logger.info("定时入库-定时保持，正常模式-入库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.period(serialId1,plateNo,"PERIOD_IN");

            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.period(serialId2,null,"PERIOD_KEEP");

            long serialId3 = System.currentTimeMillis() / 1000;
            auditType.in(serialId3,plateNo1,"IN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(testName = "正常模式-入库-合并")
    public void normal_in_inMergeTest(){
        try {
            AuditType.logger.info("正常模式-入库-合并");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.in(serialId1,plateNo,"IN");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,null,"IN_MERGE");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(testName="正常模式-入库-确认不出库，定时保持，正常模式-确认不出库-合并")
    public void normal_in_noout_PeriodKeep_normal_noout_inmergeTest(){
        try {
            AuditType.logger.info("正常模式-入库-确认不出库，定时保持，正常模式-确认不出库-合并");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.in(serialId1,plateNo,"IN");
            auditType.evidence(serialId1);
            auditType.out(serialId1,"NO_OUT");

            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.period(serialId2,null,"PERIOD_KEEP");

            long serialId3 = System.currentTimeMillis() / 1000;
            auditType.evidence(serialId3);
            auditType.out(serialId3,"NO_OUT");

            long serialId4 = System.currentTimeMillis() / 1000;
            auditType.in(serialId4,null,"IN_MERGE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "定时入库，正常模式-合并")
    public void period_in_normalKeepTest(){
        try {
            AuditType.logger.info("定时入库，正常模式-合并");

            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.period(serialId1,plateNo,"PERIOD_IN");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,null,"IN_MERGE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "定时入库，正常模式-确认不出库-合并")
    public void period_in_normal_noout_inmergeTest(){
        try {
            AuditType.logger.info("定时入库，正常模式-确认不出库-合并");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.period(serialId1,plateNo,"PERIOD_IN");

            auditType.evidence(serialId1);
            auditType.out(serialId1,"NO_OUT");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,null,"IN_MERGE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "定时入库-定时保持，正常模式-合并")
    public void period_in_keep_normal_inMergeTest() {
        try {
            AuditType.logger.info("定时模式-入库-保持不变，正常模式-合并");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.period(serialId1, plateNo, "PERIOD_IN");
            auditType.period(serialId1, null, "PERIOD_KEEP");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,null,"IN_MERGE");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test(testName = "定时入库-定时保持，正常模式-确认不出库，定时保持")
    public void period_in_keep_normal_noout_period_keepTest(){
        try {
            AuditType.logger.info("定时入库-定时保持，正常模式-确认不出库，定时保持");

            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.period(serialId1,plateNo,"PERIOD_IN");

            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.period(serialId2,null,"PERIOD_KEEP");

            long serialId3 = System.currentTimeMillis() / 1000;
            auditType.evidence(serialId3);
            auditType.out(serialId3,"NO_OUT");

            long serialId4 = System.currentTimeMillis() / 1000;
            auditType.period(serialId4,null,"PERIOD_KEEP");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "正常模式-入库-确认不出库-合并")
    public void normal_in_noout_inMergeTest(){
        try {
            AuditType.logger.info("正常模式-入库-确认不出库-合并");

            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.in(serialId1,plateNo,"IN");
            auditType.evidence(serialId1);
            auditType.out(serialId1,"NO_OUT");

            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,null,"IN_MERGE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(testName = "正常模式-自动入库-自动确认不出库-自动合并-自动出库")
    public void auto_in_noout_inMergeTest(){

        try {
            AuditType.logger.info("正常模式-自动入库-自动确认不出库-自动合并-自动出库（识别不到车牌)");
//
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.auto_in(serialId1);

            auditType.evidence(serialId1);
            auditType.auto_noout(serialId1);
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.auto_in(serialId2);

            auditType.evidence(serialId2);
            auditType.auto_out(serialId2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(testName = "正常模式-自动入库，手动出库")
    public void auto_in_manual_outTest(){

        try {
            //手动出库---(出库识别的车牌与最近一条入库识别的车牌不一致,无法自动出库)
            AuditType.logger.info("正常模式-自动入库，手动出库");
            Long serialId1 = System.currentTimeMillis() / 1000;
            auditType.auto_in(serialId1);

            //自动入库的时候，只有自动出库失败，也就是识别到的图片无法自动出库，也无法自动不出库，才能手动处理
            //失败情况模拟：自动入库车牌号为A，出库图片识别到的车牌号为B
            auditType.evidence(serialId1);
            auditType.autoOutHandleFail_mannulHandle(serialId1,"OUT");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test(testName = "正常模式-自动入库，手动不出库，手动合并，自动出库")
    public void auto_in_mannual_noout_mannul_inMerge_auto_outTest() {

        try {
            AuditType.logger.info("正常模式-自动入库，手动不出库，手动合并，自动出库");

            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.auto_in(serialId1);

            auditType.evidence(serialId1);
            auditType.autoOutHandleFail_mannulHandle(serialId1, "NO_OUT");
            Long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2, null, "IN_MERGE");

            auditType.evidence(serialId2);
            auditType.auto_out(serialId2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "正常模式-入库--低功耗出库")
    public void in_lowPoweroutTest(){
        try {
            AuditType.logger.info("正常模式入库--低功耗出库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.in(serialId1,plateNo,"IN");
            auditType.evidence(serialId1);
            auditType.lowPower_out(serialId1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(testName = "正常模式-入库，定时保持，正常模式-低功耗出库")
    public void normalIn_periodKeep_lowPowerOut(){
        try {
            AuditType.logger.info("正常模式-入库，定时模式-保持不变，正常模式-低功耗出库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.in(serialId1,plateNo,"IN");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.period(serialId2,plateNo,"PERIOD_KEEP");
            auditType.evidence(serialId2);
            auditType.lowPower_out(serialId2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "正常模式-入库-确认不出库-合并-低功耗出库")
    public void normal_in_noOut_inMerge_lowPowerOut(){
        try {
            AuditType.logger.info("正常模式-入库-确认不出库-合并-低功耗出库");
            long serialId1 = System.currentTimeMillis() / 1000;
            auditType.in(serialId1,plateNo,"IN");
            auditType.evidence(serialId1);
            auditType.out(serialId1,"NO_OUT");
            long serialId2 = System.currentTimeMillis() / 1000;
            auditType.in(serialId2,plateNo,"IN_MERGE");

            auditType.evidence(serialId2);
            auditType.lowPower_out(serialId2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





//    @Test(testName = "正常模式-入库-入库不处理")
//    public void normal_in_noDo(){
//        try {
//            AuditType.logger.info("正常模式-入库-入库不处理");
//            Long serialId1 = System.currentTimeMillis()/1000;
//            auditType.in(serialId1,plateNo,"IN");
//            Long serialId2 = System.currentTimeMillis()/1000;
//            auditType.normal_in_no_do(serialId2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test(testName = "正常模式-入库-确认不出库-入库不处理")
//    public void normal_in_noout_noDo(){
//        try {
//            AuditType.logger.info("正常模式-入库-确认不出库-入库不处理");
//            Long serialId1=System.currentTimeMillis()/1000;
//            auditType.in(serialId1,plateNo,"IN");
//            auditType.evidence(serialId1);
//            auditType.out(serialId1,"NO_OUT");
//            Long serialId2=System.currentTimeMillis()/1000;
//            auditType.normal_in_no_do(serialId2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test(testName = "正常模式-入库-合并-不处理")
//    public void normal_in_inMerge_noDo(){
//        try {
//            AuditType.logger.info("正常模式-入库-合并-不处理");
//            Long serialId1=System.currentTimeMillis()/1000;
//            auditType.in(serialId1,plateNo,"IN");
//            Long serialId2=System.currentTimeMillis()/1000;
//            auditType.in(serialId2,null,"IN_MERGE");
//            Long serialId3=System.currentTimeMillis()/1000;
//
//            auditType.normal_in_no_do(serialId3);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test(testName = "定时入库，正常模式-不处理")
//    public void period_in_normal_noDo(){
//        try {
//            AuditType.logger.info("定时入库，正常模式-不处理");
//            Long serialId1=System.currentTimeMillis()/1000;
//            auditType.period(serialId1,plateNo,"PERIOD_IN");
//            Long serialId2=System.currentTimeMillis()/1000;
//            auditType.normal_in_no_do(serialId2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test(testName = "定时入库-定时保持，正常模式-不处理")
//    public void period_in_keep_normal_noDo(){
//        try {
//            AuditType.logger.info("定时入库-定时保持，正常模式-不处理");
//            Long serialId1 = System.currentTimeMillis()/1000;
//            auditType.period(serialId1,plateNo,"PERIOD_IN");
//
//            Long serialId2 = System.currentTimeMillis() / 1000;
//            auditType.period(serialId2,null,"PERIOD_KEEP");
//
//            Long serialId3 = System.currentTimeMillis() / 1000;
//            auditType.normal_in_no_do(serialId3);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    @Test(testName = "正常模式-入库，定时保持，正常模式-不处理")
//    public void normalIn_PeriodKeep_normalNoDo(){
//        try {
//            AuditType.logger.info("正常模式-入库，定时模式-保持不变，正常模式-不处理");
//            Long serialId1 = System.currentTimeMillis()/1000;
//            auditType.in(serialId1,plateNo,"IN");
//            Thread.sleep(3000);
//            long serialId2 = System.currentTimeMillis()/1000;
//            auditType.period(serialId2,null,"PERIOD_KEEP");
//            Thread.sleep(3000);
//            Long serialId3 = System.currentTimeMillis() / 1000;
//            auditType.normal_in_no_do(serialId3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test(testName = "自动入库-自动确认不出库-自动合并-入库不处理--出库")
//    public void auto_in_noOut_inMerge_noDo(){
//        try {
//            AuditType.logger.info("自动入库-自动确认不出库-自动合并-入库不处理-出库");
//            Long serialId1 = System.currentTimeMillis()/1000;
//
//            auditType.auto_in(serialId1);
//
//            auditType.evidence(serialId1);
//            auditType.auto_noout(serialId1);
//            Long serialId2 = System.currentTimeMillis()/1000;
//            auditType.auto_in(serialId2);
//
//            Long serialId3 = System.currentTimeMillis()/1000;
//            auditType.normal_in_no_do(serialId3);
//            auditType.out(serialId3,"OUT");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
////
////    //
////    //闽AQ3Y97
////
//    @Test(testName ="自动入库-定时保持-不处理--出库")
//    public void auto_in_keep_normal_in(){
//        try {
//            AuditType.logger.info("自动入库-定时保持-不处理");
//
//            Long serialId1 = System.currentTimeMillis()/1000;
////        auditType.out(serialId1,"OUT");////////////////////////////////
//
//            auditType.auto_in(serialId1);
//            Long serialId2 = System.currentTimeMillis()/1000;
//            auditType.period(serialId2,"闽AQ3Y97","PERIOD_KEEP");
//            Long serialId3 = System.currentTimeMillis()/1000;
//            auditType.normal_in_no_do(serialId3);
//            auditType.out(serialId3,"OUT");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
////
//
//    @Test(testName ="正常模式-入库，定时保持，正常模式-不出库-不处理")
//    public void normalIn_periodKeep_normal_noOut_noDo(){
//        try {
//            AuditType.logger.info("正常模式-入库，定时-保持，正常模式-不出库-不处理");
//            Long serialId1 = System.currentTimeMillis()/1000;
//            auditType.in(serialId1,plateNo,"IN");
//
//            Long serialId2 = System.currentTimeMillis()/1000;
//            auditType.period(serialId2,plateNo,"PERIOD_KEEP");
//
//            Long serialId3 = System.currentTimeMillis()/1000;
//            auditType.evidence(serialId3);
//            auditType.out(serialId3,"NO_OUT");
//
//            Long serialId4 = System.currentTimeMillis()/1000;
//            auditType.normal_in_no_do(serialId4);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Test(testName ="正常模式-入库-不出库，定时保持，正常模式-不处理")
//    public void normal_in_noOut_periodKeep_normalNoDo(){
//        try {
//            AuditType.logger.info("正常模式-入库-不出库，定时保持，正常模式-不处理");
//            Long serialId1 = System.currentTimeMillis()/1000;
//            auditType.in(serialId1,plateNo,"IN");
//            auditType.evidence(serialId1);
//            auditType.out(serialId1,"NO_OUT");
//
//            Long serialId2 = System.currentTimeMillis()/1000;
//            auditType.period(serialId2,plateNo,"PERIOD_KEEP");
//            Long serialId3 = System.currentTimeMillis()/1000;
//            auditType.normal_in_no_do(serialId3);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//



//    @Test(testName = "自动入库-自动出库")
//    public void auton_autoOut(){
//        try {
//            for (int i=0;i<10;i++) {
//                AuditType.logger.info("自动入库-自动出库");
//                Long serialId1 = System.currentTimeMillis()/1000;
//
//                auditType.auto_in(serialId1);
//
//                auditType.evidence(serialId1);
//
//                Long serialId2 = System.currentTimeMillis()/1000;
//                auditType.auto_out(serialId1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//







}