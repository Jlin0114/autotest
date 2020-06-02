package zhiyiting2.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = { "classpath*:spring-config.xml" })
public class ZTest extends AbstractTestNGSpringContextTests{
	public static String deviceNo = "987654321";// 999033
	public static Integer placeId=0;
	public static String assertSpecialVehicleTestplateNos[] = {"吉AKJ500","吉AKJ501","吉AKJ502"};
	
}
