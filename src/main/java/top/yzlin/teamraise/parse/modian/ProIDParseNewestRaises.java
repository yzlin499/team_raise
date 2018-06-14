package top.yzlin.teamraise.parse.modian;

import top.yzlin.teamraise.entity.CompleteInfo;
import top.yzlin.teamraise.entity.MemberInfo;
import top.yzlin.teamraise.entity.RaiseInfo;
import top.yzlin.teamraise.parse.RaiseProjectParser;
import top.yzlin.teamraise.parse.RaisesAchieveStrategy;
import top.yzlin.teamraise.savedata.DisposeMember;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProIDParseNewestRaises implements RaisesAchieveStrategy {
    private RaiseProjectParser raiseProjectParser;

    @Override
    public void setRaiseProjectParser(RaiseProjectParser raiseProjectParser) {
        this.raiseProjectParser=raiseProjectParser;
    }

    @Override
    public RaiseInfo[] parser(MemberInfo memberInfo) {
        return raiseProjectParser.getRaiseInfos(
                Stream.of(memberInfo.getInfo().split(",")).mapToInt(Integer::valueOf).toArray());
    }

    @Override
    public boolean updateStrategy(CompleteInfo completeInfo) {
        DisposeMember s=DisposeMember.getInstance();
        int id=completeInfo.getMemberInfo().getId();
        if(s.isUpdate(id)){
            s.resetUpdate(id);
            return true;
        }
        return false;
    }


}
