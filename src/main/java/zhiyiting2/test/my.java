package zhiyiting2.test;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import sun.java2d.pipe.hw.AccelDeviceEventNotifier;
import zhiyiting2.model.SqlModel;
import zhiyiting2.test.deviceManagement.service.DeviceService;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class my extends ZTest{
    public static void main(String[] args) throws IOException {
//        my my = new my();
//        my.deviceNo();


    }
    //设备入库
    public void deviceInsert(){

    }

    //添加路段
    //绑定施工
    //添加车位
    public void addParkPlace(){
        try {
            for(int i=0;i<1000;i++) {
                //创建车位
                parkingRoadService.addParkPlaces(roadId,"108.334009"+i,"22.812682"+i,String.valueOf(i));
                //查询车位id
                List<Object> list = jdbconn.query("select p.id from parking_place p where "
                        + "p.road_id='"+roadId+"' order by p.id desc", SqlModel.class);
                placeId = SqlModel.class.cast(list.get(0)).getId();
                //派发工单
                parkingService.createNewWorkOrder(placeId);
                List<Object> activity = jdbconn.query("select woa.id from work_order_activity woa "
                        + "left join work_order wo on wo.id=woa.work_order_id where "
                        + "wo.parking_place_id='"+placeId+"' order by woa.id desc", SqlModel.class);
                String activityId = String.valueOf(SqlModel.class.cast(activity.get(0)).getId());
    //					//工单回填
                workerService.backfillConstructWorkOrderActivity(activityId,588885888800000L+i+"", String.valueOf(workerId));
                //开启出库审核
                int[] ids = new int[1];
                ids[0]=this.placeId;
                //车位开启出库审核
                parkingRoadService.auditParkPlaceOut(ids, "PASS");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //派发工单
    //工单回填


    //随机生成设备号
    public void deviceNo() throws IOException {

        Random r = new Random();
//            File file = new File("C:\\Users\\DELL\\Desktop\\deviceNo.txt");
        BufferedWriter fw = new BufferedWriter(new FileWriter("deviceNo.txt"));
        for (int n=0;n<100;n++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i=0;i<15;i++){
                StringBuffer deviceNo = stringBuffer.append(r.nextInt(10));
            }
            fw.write(String.valueOf(stringBuffer));
            fw.newLine();

        }
        fw.close();


    }


}
