package top.yzlin.teamraise;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import top.yzlin.teamraise.savedata.DisposeMember;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 配置加载类
 */
public class LoadConfig {
    private static LoadConfig newInstance=new LoadConfig();
    private LoadConfig(){
        init();
    }
    public static LoadConfig getInstance(){
        return newInstance;
    }

    private ApplicationContext context;

    private void init(){
        context =new FileSystemXmlApplicationContext("classpath:raise_config.xml");
//        try {
//            File file = new ClassPathResource(getConfig("logPath").toString()).getFile();
//            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
//            ConfigurationSource source = new ConfigurationSource(in);
//            Configurator.initialize(null, source);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public Object getConfig(String key){
        return context.getBean(key);
    }

    public <T> T getConfig(Class<T> key){
        return context.getBean(key);
    }


}
