package Test;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggerTest {
    private static Log logger = LogFactory.getLog(LoggerTest.class);

    public static void main(String[] args) {
    logger.trace("trace");
    logger.info("info");
    logger.debug("debug");
    logger.warn("warn");
    logger.error("error");
    logger.fatal("fatal");
    }
}
