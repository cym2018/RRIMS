package Beans;

import org.springframework.beans.factory.annotation.Value;

public class Bean1 {
    private String Name = "BeanTest";

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
