package kr.co.youngyoung.goldnawa.core.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisService<T, P> {
    @Autowired
    private SqlSession sqlSession;

    public T selectOne(String statement) {
        T obj = sqlSession.selectOne(statement);

        return obj;
    }

    public T selectOne(String statement, P parameter) {
        T obj = sqlSession.selectOne(statement, parameter);

        return obj;
    }
}