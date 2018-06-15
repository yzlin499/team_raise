package top.yzlin.teamraise.pool;

import top.yzlin.teamraise.entity.CompleteInfo;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;
import top.yzlin.teamraise.parse.ParseFactory;
import top.yzlin.teamraise.savedata.DisposeMember;

import java.util.Objects;
import java.util.stream.Stream;

public class RaisePool {
    private static RaisePool newInstance=new RaisePool();
    private RaisePool(){
        init();
    }
    public static RaisePool getInstance(){
        return newInstance;
    }

    private CompleteInfo[] completeInfos;

    private void init(){
        DisposeMember disposeMember=DisposeMember.getInstance();
        completeInfos=new CompleteInfo[disposeMember.size()];
        for(int i=0;i<completeInfos.length;i++){
            MemberInfo m=disposeMember.getMember(i);
            if (m != null) {
                CompleteInfo c=new CompleteInfo();
                completeInfos[i]=c;
                c.setLastAchieveTime(System.currentTimeMillis());
                c.setMemberInfo(m);
            }
        }
        Stream.of(completeInfos)
                .parallel()
                .filter(Objects::nonNull)
                .forEach(c->{
                    MemberInfo m=c.getMemberInfo();
                    c.setRaiseInfos(ParseFactory.createRaisesParser(m).parser(m));
                });
    }

    public RaiseInfo[] getRaiseInfo(int index){
        if(completeInfos[index]==null){
            return new RaiseInfo[0];
        }else if(!ParseFactory.createRaisesParser(completeInfos[index].getMemberInfo()).updateStrategy(completeInfos[index])){
            return completeInfos[index].getRaiseInfos();
        }else{
            MemberInfo m=completeInfos[index].getMemberInfo();
            completeInfos[index].setLastAchieveTime(System.currentTimeMillis());
            completeInfos[index].setRaiseInfos(ParseFactory.createRaisesParser(m).parser(m));
            return completeInfos[index].getRaiseInfos();
        }
    }

}
