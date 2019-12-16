package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;

import java.lang.annotation.Annotation;

@Controller("/test")
public class ControllerTest implements Controller {
static Logger logger= LogManager.getLogger(ControllerTest.class);
    @Override
    public String value() {
        logger.debug("调用");
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        logger.debug("调用");
        return null;
    }
}
