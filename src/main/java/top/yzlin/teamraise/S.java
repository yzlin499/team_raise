package top.yzlin.teamraise;

public final class S {
    private S(){}

    public final static class member{
        private member(){}
        private final static String NameSpace="sqlmappers.member.";

        public final static String MemberList=NameSpace+"MemberList";
        public final static String UpdateMember=NameSpace+"UpdateMember";
        public final static String SelectByName=NameSpace+"SelectByName";
    }

    public final static class flag {
        private final static String NameSpace = "sqlmappers.flag.";
        public final static String SubmitGoalFlag = NameSpace + "SubmitGoalFlag";

        private flag() {
        }
    }


}
