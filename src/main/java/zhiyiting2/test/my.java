package zhiyiting2.test;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import sun.java2d.pipe.hw.AccelDeviceEventNotifier;
import zhiyiting2.test.deviceManagement.service.DeviceService;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class my extends ZTest{
    public static void main(String[] args) throws IOException {
        my my = new my();
        my.deviceNo();


    }
    //设备入库
    public void deviceInsert(){

    }

    //添加路段
    //绑定施工
    //添加车位
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
