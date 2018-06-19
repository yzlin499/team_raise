package top.yzlin.teamraise.parse.modian;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import top.yzlin.teamraise.entity.RaiseInfo;
import top.yzlin.teamraise.parse.AlreadyRaiseFactory;
import top.yzlin.teamraise.parse.RaiseProjectParser;
import top.yzlin.tools.NetTools;
import top.yzlin.tools.Tools;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ProjectParser implements RaiseProjectParser {
    @Override
    public RaiseInfo[] getRaiseInfos(int[] ID) {
        ArrayList<RaiseInfo> infoArrayList=new ArrayList<>(ID.length);
        Arrays.stream(ID)
                .parallel()
                .forEach(n->{
            JSONObject jo=JSONObject.parseObject(
                    NetTools.sendPost("https://wds.modian.com/api/project/detail",infoParam(n)));
            if(jo.getIntValue("status")==0) {
                RaiseInfo raiseInfo = jo.getJSONArray("data").getJSONObject(0).toJavaObject(RaiseInfo.class);
                raiseInfo.setUrl("https://zhongchou.modian.com/item/" + n + ".html");
                raiseInfo.setIntroduce(introduce(raiseInfo.getUrl()));
                raiseInfo.setAlreadyRaise(AlreadyRaiseFactory.createRaisesParser("modian"));
                infoArrayList.add(raiseInfo);
            }
        });
        return infoArrayList.toArray(new RaiseInfo[infoArrayList.size()]);
    }

    private String infoParam(int proID){
        return "pro_id="+proID+"&sign="+ Tools.MD5("pro_id="+proID+"&p=das41aq6").substring(5,21);
    }

    private static String introduce(String url){
        return Jsoup.parse(NetTools.sendGet(url))
                    .body().getElementsByClass("short-intro").first().child(0).text();
    }
}
