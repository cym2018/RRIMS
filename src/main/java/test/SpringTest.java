package test;

import Beans.Bean1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 b1 = (Bean1) ac.getBean("bean1");
        System.out.println(b1.getName());
    }
}
