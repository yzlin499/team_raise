package top.yzlin.teamraise.entity;

public class RelayFlag extends BasicFlag {
    private int startMoney;
    private int onGreat;
    private int addMoney;
    private int upperLimit;

    public int getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(int startMoney) {
        this.startMoney = startMoney;
    }

    public int getOnGreat() {
        return onGreat;
    }

    public void setOnGreat(int onGreat) {
        this.onGreat = onGreat;
    }

    public int getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(int addMoney) {
        this.addMoney = addMoney;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }
}
