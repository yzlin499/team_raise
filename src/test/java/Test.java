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
import top.yzlin.tools.SqlSessionManagement;
import top.yzlin.tools.Tools;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[]args){
        JSONObject j = JSONObject.parseObject("asdaa{\"status\":\"0\",\"message\":\"\",\"data\":[{\"pro_id\":\"22968\",\"pro_name\":\"\\u3010\\u603b\\u9009\\u3011\\u90b5\\u96ea\\u806a\\u603b\\u9009\\u96c6\\u8d44\\u653b\\u575a\\u8ba1\\u5212\",\"goal\":\"82800\",\"already_raised\":0,\"backer_count\":0,\"success_order_count\":0,\"end_time\":\"2018-07-18 23:59:00\",\"pc_cover\":\"https:\\/\\/p.moimg.net\\/bbs_attachments\\/2018\\/06\\/18\\/20180618_1529295302_8106.jpg?imageMogr2\\/auto-orient\\/strip\",\"mobile_cover\":\"https:\\/\\/p.moimg.net\\/bbs_attachments\\/2018\\/06\\/18\\/20180618_1529295302_2195.jpg?imageMogr2\\/auto-orient\\/strip\",\"left_time\":\"\\u8ddd\\u79bb\\u7ed3\\u675f\\u8fd8\\u5269\\u3010710\\u5c0f\\u65f616\\u5206\\u949f43\\u79d2\\u3011\"}],\"mapi_query_time\":1529372537}");
        System.out.println(j);
    }
}
