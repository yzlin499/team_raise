import top.yzlin.teamraise.S;
import top.yzlin.teamraise.entity.GoalFlag;
import top.yzlin.teamraise.parse.BasicAlreadyRaiseCache;
import top.yzlin.teamraise.parse.modian.AchieveAlreadyRaise;
import top.yzlin.teamraise.pool.RaisePool;
import top.yzlin.teamraise.savedata.DisposeMember;
import top.yzlin.tools.SqlSessionManagement;
import top.yzlin.tools.Tools;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class Test {
    public static void main(String[]args){
        SqlSessionManagement.getInstance().customSqlSession(s -> {
            GoalFlag goalFlag = new GoalFlag();
            goalFlag.setType("ad");
            goalFlag.setRewardMoney(123);
            goalFlag.setGoalMoney(123123);
            goalFlag.setInfo("qwe");
            goalFlag.setMemberID(555);
            goalFlag.setContactWay("zcxxzczx");
            goalFlag.setEnable(true);
            goalFlag.setEndTime(new Date());
            goalFlag.setId(123);
            s.insert(S.flag.SubmitGoalFlag, goalFlag);
            return null;
        });

    }
}
