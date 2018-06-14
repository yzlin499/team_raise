package top.yzlin.teamraise.entity;


public class MemberInfo {
    private int id=-1;
    private String name;
    private String platform;
    private String searchWay;
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSearchWay() {
        return searchWay;
    }

    public void setSearchWay(String searchWay) {
        this.searchWay = searchWay;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", searchWay='" + searchWay + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
