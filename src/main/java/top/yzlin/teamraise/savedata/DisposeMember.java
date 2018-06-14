package top.yzlin.teamraise.savedata;

import top.yzlin.teamraise.LoadConfig;
import top.yzlin.teamraise.entity.MemberInfo;

public interface DisposeMember {
    int PLATFORM=1;
    int SEARCH_WAY=2;
    int INFO=3;

    /**
     * 获取唯一成员操作实例
     * @return
     */
    static DisposeMember getInstance(){
        return LoadConfig.getInstance().getConfig(LoadMember.class);
    }

    /**
     * 通过id来获取成员
     * @param index id
     * @return
     */
    MemberInfo getMember(int index);

    /**
     * 通过姓名来获取成员
     * @param name 姓名
     * @return
     */
    MemberInfo getMember(String name);

    /**
     * 成员数量，一般是ID的最大值，并非正式数量
     * @return
     */
    int size();

    /**
     * 修改成员信息
     * @param memberInfo 成员信息
     * @return 是否修改成功
     */
    boolean updateMember(MemberInfo memberInfo);

    /**
     * 修改成员信息简单版本
     * @param id 成员id
     * @param column 列
     * @param value 修改值
     * @return 是否修改成功
     */
    default boolean updateMember(int id,int column,String value){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setId(id);
        switch (column){
            case PLATFORM:memberInfo.setPlatform(value);break;
            case SEARCH_WAY:memberInfo.setSearchWay(value);break;
            case INFO:memberInfo.setInfo(value);break;
            default:return false;
        }
        return updateMember(memberInfo);
    }

    /**
     * 与上一次相比是否修改过数据
     * @param id 成员id
     * @return 是否修改
     */
    boolean isUpdate(int id);

    /**
     * 重置某位成员的isUpdate的获取值
     * @param id
     */
    void resetUpdate(int id);

}
