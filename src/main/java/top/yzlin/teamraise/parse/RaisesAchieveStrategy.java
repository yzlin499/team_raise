package top.yzlin.teamraise.parse;

import top.yzlin.teamraise.entity.CompleteInfo;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;

/**
 * 给ID生成集资信息
 */
public interface RaisesAchieveStrategy {

    /**
     * 设置解析器
     *
     * @param raiseProjectParser 解析器
     */
    void setRaiseProjectParser(RaiseProjectParser raiseProjectParser);

    /**
     * 获取集资
     * @param memberInfo
     * @return
     */
    RaiseInfo[] parser(MemberInfo memberInfo);

    /**
     * 是否有更新
     * @param completeInfo
     * @return
     */
    boolean updateStrategy(CompleteInfo completeInfo);
}
