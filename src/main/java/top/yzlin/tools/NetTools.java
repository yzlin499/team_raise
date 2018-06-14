package top.yzlin.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

public class NetTools {
    /**
     * 获取GET数据
     */

    public static String sendGet(String url, String param) {
        return sendGet(url + "?" + param);
    }

    public static String sendGet(String url) {
        HttpURLConnection connection;
        try {
            url= URLEncoder.encode(url,"utf8");
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection","Keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            HttpURLConnection.setFollowRedirects(true);
            connection.setInstanceFollowRedirects(false);
            connection.connect();
        } catch (IOException e) {
            Tools.print("get的网络区炸了，10秒之后重新获取");
            Tools.sleep(10000);
            return sendGet(url);
        }
        try (BufferedReader in= new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf8"))){
            String line;
            StringBuilder result=new StringBuilder();
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e ) {
            Tools.print("get的读写区炸了，10秒之后重新获取");
            Tools.sleep(10000);
            return sendGet(url);
        }
    }

    /**
     * post数据
     * @param url 网址
     * @param param 参数
     * @return 数据
     */
    public static String sendPost(String url, String param){
        return sendPost(url,param, conn -> {
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        });
    }

    /**
     * 获取post数据，可自定义头文件
     * @param url 网址
     * @param param 参数
     * @param m 用map图来添加各项数据
     * @return 数据
     */
    public static String sendPost(String url, String param,Map<String,String> m){
        return sendPost(url,param,conn->{
            for(String key:m.keySet()){
                conn.setRequestProperty(key,m.get(key));
            }
        });
    }

    /**
     * 获取post数据，可自定义头文件
     * @param url 网址
     * @param param 参数
     * @param connections 头文件接口
     * @return 数据
     */
    public static String sendPost(String url, String param,SetConnection connections){
        return sendPost(url,param,connections,null);
    }

    /**
     * 获取post数据，可自定义头文件与异常处理方法
     * @param url 网址
     * @param param 参数
     * @param connections 头文件接口
     * @param solution 处理方法
     * @return 数据
     */
    public static String sendPost(String url, String param, SetConnection connections, IOExceptionSolution solution){
        URLConnection conn;
        try {
            conn = new URL(url).openConnection();
            connections.setConnection(conn);
            conn.setDoOutput(true);
            conn.setDoInput(true);
        } catch (IOException e) {
            if(solution!=null){
                solution.exceptionSolution(e);
            }
            Tools.print("post的网络区炸了，10秒之后重新获取");
            Tools.sleep(10000);
            return sendPost(url,param,connections,solution);
        }
        try(PrintWriter out = new PrintWriter(conn.getOutputStream())){
            out.print(param);
            out.flush();
        }catch (IOException e) {
            if(solution!=null){
                solution.exceptionSolution(e);
            }
            Tools.print("post的PrintWriter读写区炸了，10秒之后重新获取");
            Tools.sleep(10000);
            return sendPost(url,param,connections,solution);
        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf8"))){
            String line;
            StringBuilder result=new StringBuilder();
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            if(solution!=null){
                solution.exceptionSolution(e);
            }
            Tools.print("post的BufferedReader读写区炸了，10秒之后重新获取");
            Tools.sleep(10000);
            return sendPost(url,param,connections,solution);
        }
    }


}
