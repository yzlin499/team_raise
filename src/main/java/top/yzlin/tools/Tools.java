package top.yzlin.tools;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

/**
 * 工具类
 * @author yzlin
 */
public class Tools {
    private static MessageDigest md;
    static{
        try {
            md= MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试用
     */
    public static void print(){
        print("test");
    }

    /**
     * 自定义的打印方法，输出当前时间，用来做日记打印
     * @param text
     */
    public static void print(Object text){
        System.out.println(text);
    }

    /**
     * 用来做数组输出，一般是做测试用
     * @param text
     */
    public static void printArrays(Object[]text){
        print("数组共"+text.length+"个");
        for(Object temp:text){
            System.out.println(temp.toString());
        }
    }

    public static void printCollection(Collection collection){
        print("数组共"+collection.size()+"个");
        for(Object temp:collection){
            System.out.println(temp.toString());
        }
    }

    /**
     * 简易时间停止
     * @param millis
     */
    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算MD5
     * @param str 要计算的字符串
     */
    public static String MD5(String str){
        try {
            md.update(str.getBytes("utf8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String num=new BigInteger(1, md.digest()).toString(16);
        while(num.length()<32){
            num="0"+num;
        }
        return num;
    }

}
