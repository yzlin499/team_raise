package top.yzlin.teamraise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import top.yzlin.teamraise.savedata.DisposeMember;

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
    }

    public Object getConfig(String key){
        return context.getBean(key);
    }

    public <T> T getConfig(Class<T> key){
        return context.getBean(key);
    }

}
