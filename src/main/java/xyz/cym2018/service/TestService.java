package xyz.cym2018.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("WeakerAccess")
public class TestService {
    private Logger logger = LogManager.getLogger(TestService.class);
    TestService(){
        logger.info("TestService(0)");
    }
}
