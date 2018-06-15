package top.yzlin.teamraise.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.yzlin.teamraise.LoadConfig;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;
import top.yzlin.teamraise.pool.RaisePool;
import top.yzlin.teamraise.savedata.DisposeMember;
import top.yzlin.tools.Tools;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainServlet {
    private ModelAndView mainView;
    private static Integer[] memberIDs;
    private static RaisePool raisePool=RaisePool.getInstance();
    private long lastTime=0;
    private long resetCache;

    public MainServlet(){
        DisposeMember disposeMember=DisposeMember.getInstance();
        List<MemberInfo> memberInfoList=new ArrayList<>(disposeMember.size());
        for(int i=0;i<disposeMember.size();i++){
            MemberInfo memberInfo=disposeMember.getMember(i);
            if(memberInfo!=null){
                memberInfoList.add(memberInfo);
            }
        }
        mainView=new ModelAndView("/WEB-INF/content/index.jsp")
                .addObject("memberInfoList",memberInfoList);
        resetCache=(Long) LoadConfig.getInstance().getConfig("mainServletCache");
        System.out.println(resetCache);
        memberIDs=memberInfoList.stream().map(MemberInfo::getId).toArray(Integer[]::new);
    }



    @RequestMapping("/")
    public ModelAndView indexPage(){
        long nowTime=System.currentTimeMillis();
        if(nowTime-lastTime>resetCache){
            lastTime=nowTime;
            mainView.addObject("raiseInfoList",Stream.of(memberIDs)
                    .flatMap(i-> Stream.of(raisePool.getRaiseInfo(i)))
                    .collect(Collectors.toList()));
        }
        return mainView;
    }
}
