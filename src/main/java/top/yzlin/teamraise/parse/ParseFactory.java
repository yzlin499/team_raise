package top.yzlin.teamraise.parse;

import org.springframework.context.ApplicationContext;
import top.yzlin.teamraise.LoadConfig;
import top.yzlin.teamraise.entity.MemberInfo;

import java.util.Map;

public class ParseFactory {
    private static Map<String,ApplicationContext> contextMap = (Map<String, ApplicationContext>) LoadConfig.getInstance().getConfig("platform");

    /**
     * 快速获得策略
     * @param memberInfo
     * @return
     */
    public static RaisesAchieveStrategy createRaisesParser(MemberInfo memberInfo){
        return createRaisesParser(memberInfo.getPlatform(),memberInfo.getSearchWay());
    }

    /**
     * 获取到获取最新集资项目的
     * @param platform
     * @param searchWay
     * @return
     */
    public static RaisesAchieveStrategy createRaisesParser(String platform, String searchWay){
        return contextMap.containsKey(platform)?
                (RaisesAchieveStrategy)contextMap.get(platform).getBean(searchWay):null;
    }

}
