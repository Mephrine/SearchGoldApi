package kr.co.youngyoung.goldnawa.core.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * 마이바티스 서비스
 **/
@Repository
public class MybatisService<T, P> {
    @Autowired
    private SqlSession sqlSession;

    public T selectOne(String nameSpace, String id) {
        return this.sqlSession.selectOne(nameSpace+"."+id);
    }

    public T selectOne(String nameSpace, String id, P parameter) {
        return this.sqlSession.selectOne(nameSpace+"."+id, parameter);
    }

    public List<T> selectList(String nameSpace, String id) {
        return this.sqlSession.selectList(nameSpace+"."+id);
    }

    public T selectList(String nameSpace, String id, P parameter) {
        T obj = sqlSession.selectOne(nameSpace+"."+id, parameter);

        return obj;
    }
}