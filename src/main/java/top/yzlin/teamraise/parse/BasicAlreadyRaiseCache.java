package top.yzlin.teamraise.parse;

import top.yzlin.teamraise.LoadConfig;

import java.util.HashMap;
import java.util.Map;

public abstract class BasicAlreadyRaiseCache implements AlreadyRaise {
    private static class AlreadyCache{
        long lastTime;
        double money;
    }
    private Map<Integer,AlreadyCache> cacheMap=new HashMap<>();
    private long cacheTime=8000;

    public void setCacheTime(long cacheTime) {
        this.cacheTime = cacheTime;
    }

    @Override
    public double getMoney(int proID) {
        long nowTime=System.currentTimeMillis();
        AlreadyCache alreadyCache;
        if(cacheMap.containsKey(proID)){
            alreadyCache=cacheMap.get(proID);
            if(nowTime-alreadyCache.lastTime>cacheTime){
                alreadyCache.lastTime=nowTime;
                alreadyCache.money=getAlready(proID);
            }
        }else{
            alreadyCache=new AlreadyCache();
            alreadyCache.lastTime=nowTime;
            alreadyCache.money=getAlready(proID);
            cacheMap.put(proID,alreadyCache);

        }
        return alreadyCache.money;
    }

    protected abstract double getAlready(int proID);
}
