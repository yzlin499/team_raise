import top.yzlin.teamraise.pool.RaisePool;
import top.yzlin.teamraise.savedata.DisposeMember;
import top.yzlin.tools.Tools;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Test {
    public static void main(String[]args){
        long a=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            Tools.printArrays(RaisePool.getInstance().getRaiseInfo(i));
        }
        System.out.println(System.currentTimeMillis()-a);
    }
}
