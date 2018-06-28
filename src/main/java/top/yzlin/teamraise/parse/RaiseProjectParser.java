package top.yzlin.teamraise.parse;

import top.yzlin.teamraise.entity.RaiseInfo;

public interface RaiseProjectParser<T> {
    RaiseInfo[] getRaiseInfos(T[] data);
}
