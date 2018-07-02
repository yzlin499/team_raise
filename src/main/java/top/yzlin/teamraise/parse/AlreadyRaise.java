package top.yzlin.teamraise.parse;

import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;

/**
 * 这个接口是用来获取最新的集资量的
 */
public interface AlreadyRaise {

    default double getMoney(RaiseInfo raiseInfo){
        return getMoney(raiseInfo.getProID());
    }

    /**
     * 获取集资量
     *
     * @param proID 项目ID
     * @return 集资量
     */
    double getMoney(int proID);
}
