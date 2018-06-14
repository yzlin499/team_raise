package top.yzlin.teamraise.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.savedata.DisposeMember;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainServlet {
    private ModelAndView mainView;

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
    }


    @RequestMapping("/")
    public ModelAndView indexPage(){
        return mainView;
    }
}
