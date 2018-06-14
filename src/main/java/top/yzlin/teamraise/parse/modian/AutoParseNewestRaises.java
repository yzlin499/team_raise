package top.yzlin.teamraise.parse.modian;

import org.jsoup.Jsoup;
import top.yzlin.teamraise.entity.CompleteInfo;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;
import top.yzlin.teamraise.parse.RaiseProjectParser;
import top.yzlin.teamraise.parse.RaisesAchieveStrategy;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;


public class AutoParseNewestRaises implements RaisesAchieveStrategy {
    private RaiseProjectParser raiseProjectParser;
    private long achieveTime=24*60*60*1000;

    public void setAchieveTime(long achieveTime){
        this.achieveTime= achieveTime;
    }

    @Override
    public void setRaiseProjectParser(RaiseProjectParser raiseProjectParser) {
        this.raiseProjectParser=raiseProjectParser;
    }

    @Override
    public RaiseInfo[] parser(MemberInfo memberInfo) {
        return raiseProjectParser.getRaiseInfos(downloadData(memberInfo.getName(),memberInfo.getInfo()));
    }

    @Override
    public boolean updateStrategy(CompleteInfo completeInfo) {
        return System.currentTimeMillis()-completeInfo.getLastAchieveTime() > achieveTime;
    }

    private int[] downloadData(String name,String yyhName){
        try {
            return Jsoup.parse(new URL("https://zhongchou.modian.com/search?key="+name), 30000)
                    .body().getElementsByClass("pro_ul").first().children().stream()
                    .filter(e-> !e.toString().contains("此次众筹已结束，感谢所有人支持。"))
                    .filter(e-> yyhName==null || "".equals(yyhName) || e.getElementsByClass("author").first()
                            .getElementsByTag("p").first().text().equals(yyhName))
                    .filter(e-> !"appointment".equals(e.className()))
                    .mapToInt(e-> Integer.valueOf(e.attr("data-pro-id")))
                    .toArray();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[0];
    }


}
