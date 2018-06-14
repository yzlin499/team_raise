package top.yzlin.teamraise.parse;

import org.springframework.context.ApplicationContext;
import top.yzlin.teamraise.LoadConfig;
import top.yzlin.teamraise.entity.MemberInfo;

import java.util.Map;

public class AlreadyRaiseFactory {
    private static Map<String,ApplicationContext> contextMap = (Map<String, ApplicationContext>) LoadConfig.getInstance().getConfig("platform");

    public static AlreadyRaise createRaisesParser(MemberInfo memberInfo){
        return createRaisesParser(memberInfo.getPlatform());
    }

    public static AlreadyRaise createRaisesParser(String platform){
        return contextMap.containsKey(platform)?
                contextMap.get(platform).getBean(AlreadyRaise.class):null;
    }

}
