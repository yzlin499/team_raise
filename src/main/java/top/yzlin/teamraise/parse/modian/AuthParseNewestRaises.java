package top.yzlin.teamraise.parse.modian;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import top.yzlin.teamraise.entity.CompleteInfo;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;
import top.yzlin.teamraise.parse.AlreadyRaiseFactory;
import top.yzlin.teamraise.parse.RaiseProjectParser;
import top.yzlin.teamraise.parse.RaisesAchieveStrategy;
import top.yzlin.tools.NetTools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AuthParseNewestRaises implements RaisesAchieveStrategy {
    private final static String listApi = "https://mapi.modian.com/v41/user/build_product_list";
    private RaiseProjectParser raiseProjectParser;
    private long achieveTime = 24 * 60 * 60 * 1000;

    public static void main(String[] args) {
        JSONObject jo = JSONObject.parseObject(NetTools.sendPost(listApi, "to_user_id=1452058"));
        JSONArray ja = JSONArray.parseArray(jo.getString("data"));
        System.out.println(ja);
    }

    public void setAchieveTime(long achieveTime) {
        this.achieveTime = achieveTime;
    }

    @Override
    public void setRaiseProjectParser(RaiseProjectParser raiseProjectParser) {
        this.raiseProjectParser = raiseProjectParser;
    }

    @Override
    public RaiseInfo[] parser(MemberInfo memberInfo) {
        int memberID = memberInfo.getId();
        RaiseInfo[] ris = downloadData(memberInfo.getInfo());
        for (RaiseInfo r : ris) {
            r.setMemberID(memberID);
        }
        return ris;
    }

    @Override
    public boolean updateStrategy(CompleteInfo completeInfo) {
        return System.currentTimeMillis() - completeInfo.getLastAchieveTime() > achieveTime;
    }

    private RaiseInfo[] downloadData(String yyhID) {
        JSONObject jo = JSONObject.parseObject(NetTools.sendPost(listApi, "to_user_id=" + yyhID));
        if ("0".equals(jo.getString("status"))) {
            JSONArray ja = JSONArray.parseArray(jo.getString("data"));
            return raiseProjectParser.getRaiseInfos(ja.toArray(new JSONObject[ja.size()]));
        } else {
            return new RaiseInfo[0];
        }
    }
}
