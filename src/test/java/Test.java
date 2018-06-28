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
        JSONArray.parseArray(
                JSONObject.parseObject(
                        NetTools.sendPost("https://mapi.modian.com/v41/user/build_product_list",
                                "to_user_id=1082202"
                        ))
                        .getString("data")).forEach(System.out::println);
    }
}
