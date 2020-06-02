package zhiyiting2.util;

import org.apache.log4j.Logger;

public class Log4jDemo {
	static Logger logger = Logger.getLogger(Log4jDemo.class);
	public static void main(String[] args) {
		logger.info("测试");
		logger.debug("好好");
		logger.error("发送邮件");
	}
}
