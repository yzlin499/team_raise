import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import top.yzlin.teamraise.LoadConfig;
import top.yzlin.teamraise.S;
import top.yzlin.teamraise.entity.GoalFlag;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;
import top.yzlin.teamraise.parse.BasicAlreadyRaiseCache;
import top.yzlin.teamraise.parse.modian.AchieveAlreadyRaise;
import top.yzlin.teamraise.pool.RaisePool;
import top.yzlin.teamraise.savedata.DisposeMember;
import top.yzlin.tools.NetTools;
import top.yzlin.tools.SqlSessionManagement;
import top.yzlin.tools.Tools;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[]args){
        System.out.println(JSONObject.parseObject(NetTools.sendPost("http://m202870.nofollow.axfree.mvote.cn/op.php",
                "action=checkopaction&guid=0fa24065-cabe-bc45-7c03-e41faee04fb1")));
    }
}
