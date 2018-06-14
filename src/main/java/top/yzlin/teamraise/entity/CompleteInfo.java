package top.yzlin.teamraise.entity;

public class CompleteInfo {
    private MemberInfo memberInfo;
    private RaiseInfo[] raiseInfos;
    private long lastAchieveTime;

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public RaiseInfo[] getRaiseInfos() {
        return raiseInfos;
    }

    public void setRaiseInfos(RaiseInfo[] raiseInfos) {
        this.raiseInfos = raiseInfos;
    }

    public long getLastAchieveTime() {
        return lastAchieveTime;
    }

    public void setLastAchieveTime(long lastAchieveTime) {
        this.lastAchieveTime = lastAchieveTime;
    }
}
