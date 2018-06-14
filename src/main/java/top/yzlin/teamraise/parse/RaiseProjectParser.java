package top.yzlin.teamraise.parse;

import top.yzlin.teamraise.entity.RaiseInfo;

public interface RaiseProjectParser {
    RaiseInfo[] getRaiseInfos(int[] ID);
}
