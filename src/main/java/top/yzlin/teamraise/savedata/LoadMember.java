package top.yzlin.teamraise.savedata;

import org.apache.ibatis.exceptions.PersistenceException;
import top.yzlin.teamraise.S;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.tools.SqlSessionManagement;

import java.util.Arrays;
import java.util.List;

public class LoadMember implements DisposeMember {
    private MemberInfo[] memberInfos;
    private boolean[] isUpdate;
    private SqlSessionManagement management=SqlSessionManagement.getInstance();
    //TODO:2018-6-11,郭某人不和我合作
    public LoadMember(){
        List<MemberInfo> memberInfoList= management.customSqlSession(s-> s.selectList(S.member.MemberList));
        memberInfos=new MemberInfo[memberInfoList.get(memberInfoList.size()-1).getId()+1];
        for (MemberInfo m:memberInfoList) {
            try {
                memberInfos[m.getId()] = m;
            }catch (ArrayIndexOutOfBoundsException e){
                memberInfos=Arrays.copyOf(memberInfos,m.getId()+1);
                memberInfos[m.getId()] = m;
            }
        }
        isUpdate=new boolean[memberInfos.length];
        Arrays.fill(isUpdate,false);
    }

    @Override
    public MemberInfo getMember(int index) {
        try {
            return memberInfos[index];
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public MemberInfo getMember(String name) {
        return management.customSqlSession(s-> s.selectOne(S.member.SelectByName,name));
    }

    @Override
    public int size() {
        return memberInfos.length;
    }

    @Override
    public boolean updateMember(MemberInfo memberInfo) {
        return management.customSqlSession(s->{
            try {
                if (s.update(S.member.UpdateMember, memberInfo) <= 0) {
                    s.rollback();
                    return false;
                }
            }catch (PersistenceException e){
                s.rollback();
            }
            int id=memberInfo.getId();
            memberInfos[id].setInfo(memberInfo.getInfo());
            memberInfos[id].setPlatform(memberInfo.getPlatform());
            memberInfos[id].setSearchWay(memberInfo.getSearchWay());
            isUpdate[memberInfo.getId()]=true;
            s.commit();
            return true;
        },false);
    }

    @Override
    public boolean isUpdate(int id) {
        try {
            return isUpdate[id];
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public void resetUpdate(int id) {
        isUpdate[id]=false;
    }
}
