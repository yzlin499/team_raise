package top.yzlin.teamraise.entity;

public class GoalFlag extends BasicFlag {
    private int goal;
    private int rewardMoney;

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(int rewardMoney) {
        this.rewardMoney = rewardMoney;
    }
}
