package top.yzlin.teamraise.parse;

import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;

public interface AlreadyRaise {

    default double getMoney(RaiseInfo raiseInfo){
        return getMoney(raiseInfo.getProID());
    }

    double getMoney(int proID);
}
