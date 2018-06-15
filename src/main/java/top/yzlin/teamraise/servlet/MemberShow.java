package top.yzlin.teamraise.servlet;

import org.springframework.web.servlet.ModelAndView;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.savedata.DisposeMember;

import java.util.ArrayList;
import java.util.List;

public class MemberShow {
    private List<MemberInfo> memberInfoList;

    public MemberShow() {
        DisposeMember disposeMember = DisposeMember.getInstance();
        memberInfoList = new ArrayList<>(disposeMember.size());
        for (int i = 0; i < disposeMember.size(); i++) {
            MemberInfo memberInfo = disposeMember.getMember(i);
            if (memberInfo != null) {
                memberInfoList.add(memberInfo);
            }
        }
    }
}
