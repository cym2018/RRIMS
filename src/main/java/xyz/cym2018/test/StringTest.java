package xyz.cym2018.test;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String[] test = {"字符串1", "字符串2","字符串3","字符串4"};
        String test2 = Arrays.toString(test);
        test2 = test2.substring(1, test2.length() - 1);
        test = test2.split(", ");
        for (String i : test) {
            System.out.println(i);
        }
    }
}
