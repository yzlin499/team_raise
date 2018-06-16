package top.yzlin.teamraise.parse.modian;

import com.alibaba.fastjson.JSONObject;
import top.yzlin.teamraise.entity.RaiseInfo;
import top.yzlin.teamraise.parse.AlreadyRaise;
import top.yzlin.teamraise.parse.AlreadyRaiseFactory;
import top.yzlin.teamraise.parse.BasicAlreadyRaiseCache;
import top.yzlin.tools.NetTools;
import top.yzlin.tools.Tools;

import java.util.Map;

public class AchieveAlreadyRaise extends BasicAlreadyRaiseCache {
    @Override
    protected double getAlready(int proID) {
        JSONObject jo=JSONObject.parseObject(
                NetTools.sendPost("https://wds.modian.com/api/project/detail",infoParam(proID)));
        if(jo.getIntValue("status")==0) {
            return jo.getJSONArray("data").getJSONObject(0).getDoubleValue("already_raised");
        }
        return -1;
    }

    private String infoParam(int proID){
        return "pro_id="+proID+"&sign="+ Tools.MD5("pro_id="+proID+"&p=das41aq6").substring(5,21);
    }
}
