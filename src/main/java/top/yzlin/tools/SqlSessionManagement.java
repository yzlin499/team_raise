package top.yzlin.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;

public final class SqlSessionManagement{
    private static final SqlSessionManagement instance=new SqlSessionManagement();
    private SqlSessionManagement(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 获取单例
     * @return 单例
     */
    public static SqlSessionManagement getInstance(){
        return instance;
    }



    /**
     * 不必关，我会关的
     * function你随意，我不管的
     * 会有一步sqlSession.commit();
     * @param function
     */
    public <T> T customSqlSession(Function<SqlSession,T> function) {
        return customSqlSession(function,true);
    }

    /**
     * 不必关，我会关的
     * function你随意，我不管的
     * 不会commit，手动吧
     * @param function
     */
    public <T> T customSqlSession(Function<SqlSession,T> function,boolean isCommit) {
        SqlSession sqls=sqlSessionFactory.openSession();
        T temp=function.apply(sqls);
        if(isCommit){
            sqls.commit();
        }
        sqls.close();
        return temp;
    }

    /**
     * 我求你别用这个
     * @return
     */
    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
