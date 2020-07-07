package zhiyiting2.test;

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

    System.out.println("正常模式，入库   出库  开始=============================");

    AuditType.logger.info("正常模式  入库  出库 ");
    long serialId1 = System.currentTimeMillis() / 1000;
    auditType.in(serialId1,plateNo1,"IN");
    auditType.out(serialId1,"OUT");
    System.out.println("正常模式--入库 出库  结束==============================");

}
@Test(testName = "正常模式，入库-入库")
//    @Parameters("auditType")
    public void normal_in_inTest(){
    System.out.println("正常模式，入库   入库  开始=============================");
    AuditType.logger.info("正常模式  入库  入库");
    long serialId1 = System.currentTimeMillis() / 1000;
    auditType.in(serialId1,plateNo,"IN");
    long serialId2 = System.currentTimeMillis() / 1000;
    auditType.in(serialId2,plateNo1,"IN");
    System.out.println("正常模式--入库 入库  结束===============================");
}
@Test(testName = "正常模式，入库-出库-入库")

    public void normal_in_out_inTest(){
    System.out.println("正常模式，入库-出库-入库  开始======================================");
    AuditType.logger.info("正常模式，入库-出库-入库");
    long serialId1 = System.currentTimeMillis() /1000;

    auditType.in(serialId1,plateNo,"IN");
    auditType.out(serialId1,"OUT");
    long serialId2 = System.currentTimeMillis() / 1000;
    auditType.in(serialId2,plateNo1,"IN");
    System.out.println("正常模式，入库-出库-入库  结束======================================");
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
        System.out.println("正常模式，入库-入库-出库 开始======================================");

        AuditType.logger.info("正常模式，入库-入库-出库");

        long serialId1 = System.currentTimeMillis() /1000;
        auditType.in(serialId1,plateNo,"IN");

        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2,plateNo1,"IN");
        auditType.out(serialId2, "OUT");
        System.out.println("正常模式，入库-出库-入库  结束======================================");
    }


    @Test(testName = "正常模式，入库-不出库-入库")
    public void normal_in_noout_inTest(){
        System.out.println("正常模式，入库-不出库-入库  开始========================");

        AuditType.logger.info("正常模式，入库-不出库-入库");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.in(serialId1,plateNo,"IN");
        auditType.out(serialId1,"NO_OUT");
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.in(serialId2,plateNo1,"IN");

        System.out.println("正常模式，入库-不出库-入库  结束========================");

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
        auditType.period_in(serialId1, plateNo, "PERIOD_IN");
        auditType.period_out(serialId1,"PERIOD_OUT");


    }

    @Test(testName = "定时模式，入库-保持不变-出库")
    public void period_in_keep_in(){

        AuditType.logger.info("定时模式，入库-保持不变-出库");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.period_in(serialId1,plateNo,"PERIOD_IN");
        auditType.period_out(serialId1,"PERIOD_KEEP");
        auditType.period_out(serialId1,"PERIOD_OUT");


    }

    @Test(testName = "定时模式-入库-保持不变，正常模式-入库")
    public void period_in_keep_normalinTest(){

        AuditType.logger.info("定时模式-入库-保持不变，正常模式-入库");
        long serialId1 = System.currentTimeMillis() / 1000;
        auditType.period_in(serialId1,plateNo,"PERIOD_IN");
        auditType.period_out(serialId1,"PERIOD_KEEP");
        long serialId2 = System.currentTimeMillis() / 1000;
        auditType.out(serialId2,"OUT");


    }

    @Test
    public void period_in_keep_out(){
        System.out.println();
        AuditType.logger.info("定时模式-入库-保持不变-出库");
        long serialId = System.currentTimeMillis() / 1000;

        auditType.period_in(serialId,plateNo,"PERIOD_IN");
        auditType.period_out(serialId,"PERIOD_KEEP");
        auditType.period_out(serialId,"PERIOD_OUT");
    }

	

	
	
}
