package top.yzlin.teamraise.parse;

import top.yzlin.teamraise.entity.RaiseInfo;

/**
 * 这个是用来解析数据的
 *
 * @param <T> 待解析的数据
 */
public interface RaiseProjectParser<T> {
    RaiseInfo[] getRaiseInfos(T[] data);
}
