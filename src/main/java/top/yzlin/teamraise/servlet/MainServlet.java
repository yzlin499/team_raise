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
        memberIDs=memberInfoList.stream().map(MemberInfo::getId).toArray(Integer[]::new);
    }



    @RequestMapping("/")
    public ModelAndView indexPage(){
        long nowTime=System.currentTimeMillis();
        if(nowTime-lastTime>resetCache){
            lastTime=nowTime;
            List<RaiseInfo> raiseInfoList=Stream.of(memberIDs)
                    .parallel()
                    .flatMap(i-> Stream.of(raisePool.getRaiseInfo(i)))
                    .sorted((o1, o2) -> {
                        double n1=o1.getAlreadyRaiseMoney()/o1.getGoalMoney();
                        double n2=o2.getAlreadyRaiseMoney()/o2.getGoalMoney();
                        n1=n1>=1?n1-1:n1+1;
                        n2=n2>=1?n2-1:n2+1;
                        return Double.compare(n2,n1);
                    })
                    .collect(Collectors.toList());
            mainView.addObject("raiseInfoList",raiseInfoList);
        }
        return mainView;
    }
}
