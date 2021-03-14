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

    public T selectOne(String nameSpace) {
        return this.sqlSession.selectOne(nameSpace+".findOne");
    }

    public T selectOne(String nameSpace, P parameter) {
        return this.sqlSession.selectOne(nameSpace+".findOne", parameter);
    }

    public T selectOne(String nameSpace, String id) {
        return this.sqlSession.selectOne(nameSpace+".findOne"+id);
    }

    public T selectOne(String nameSpace, String id, P parameter) {
        return this.sqlSession.selectOne(nameSpace+"."+id, parameter);
    }

    public List<T> selectList(String nameSpace) {
        return this.sqlSession.selectList(nameSpace+".findList");
    }

    public List<T> selectList(String nameSpace, P parameter) {
        return this.sqlSession.selectList(nameSpace+".findList", parameter);
    }

    public List<T> selectList(String nameSpace, String id) {
        return this.sqlSession.selectList(nameSpace+".findList"+id);
    }

    public List<T> selectList(String nameSpace, String id, P parameter) {
        return this.sqlSession.selectList(nameSpace+".findList"+id, parameter);
    }
}