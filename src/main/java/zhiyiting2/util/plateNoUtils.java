package zhiyiting2.util;

import java.util.Random;

public class plateNoUtils {

//    public static void main(String[] args) {
//        String plateNo = new plateNoUtils().getPlateNo();
//        System.out.println(plateNo);
//    }
        // 车牌号开头
        private static String[] city = {
                "京","津", "沪","渝","冀",
                "豫","云", "辽","黑","湘",
                "皖","鲁", "新","苏","浙",
                "赣","鄂", "桂","甘","晋",
                "蒙","陕", "吉","闽","贵",
                "粤","青", "藏","川","宁", "琼"
        };
        //车牌号第二个字母
        private static String[] letter = { "A", "B", "C", "D", "E", "F", "G", "H",
                                           "J", "K", "L", "M", "N", "P", "Q", "R",
                                           "S", "T", "U", "V", "W", "X", "Y", "Z" };


        /**
         * 随机生成车牌号
         * @return
         */
        public  String getPlateNo() {

            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(city[new Random().nextInt(31)])
                        .append(letter[new Random().nextInt(24)]);
            for (int i = 0; i < 5; i++) {
                stringBuffer.append(new Random().nextInt(10));
            }
            String plateNo = stringBuffer.toString();
            return plateNo;

            }
    }





