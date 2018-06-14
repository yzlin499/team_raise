package top.yzlin.teamraise.parse;

import top.yzlin.teamraise.entity.CompleteInfo;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;

/**
 * 给ID生成集资信息
 */
public interface RaisesAchieveStrategy {

    void setRaiseProjectParser(RaiseProjectParser raiseProjectParser);

    RaiseInfo[] parser(MemberInfo memberInfo);

    boolean updateStrategy(CompleteInfo completeInfo);
}
