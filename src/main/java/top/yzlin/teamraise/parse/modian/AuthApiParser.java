package top.yzlin.teamraise.parse.modian;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import top.yzlin.teamraise.entity.RaiseInfo;
import top.yzlin.teamraise.parse.AlreadyRaiseFactory;
import top.yzlin.teamraise.parse.RaiseProjectParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;

public class AuthApiParser implements RaiseProjectParser<JSONObject> {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public RaiseInfo[] getRaiseInfos(JSONObject[] data) {
        return Stream.of(data)
                .filter(d -> "众筹中".equals(((JSONObject) d).getString("status")))
                .map(d -> {
                    RaiseInfo raiseInfo = new RaiseInfo();
                    raiseInfo.setIntroduce(Objects.toString(d.getString("des"), ""));
                    raiseInfo.setUrl(Objects.toString("https://zhongchou.modian.com/item/" + d.getString("id") + ".html", ""));
                    raiseInfo.setProID(d.getIntValue("id"));
                    raiseInfo.setCover(Objects.toString(d.getString("logo_4x3"), ""));
                    try {
                        raiseInfo.setEndTime(simpleDateFormat.parse(Objects.toString(d.getString("end_time"), "")));
                    } catch (ParseException e) {
                        raiseInfo.setEndTime(new Date());
                    }
                    raiseInfo.setTitle(Objects.toString(d.getString("name"), ""));
                    raiseInfo.setGoalMoney(d.getDoubleValue("install_money"));
                    raiseInfo.setAlreadyRaise(AlreadyRaiseFactory.createRaisesParser("modian"));
                    return raiseInfo;
                }).toArray(RaiseInfo[]::new);
    }
}
