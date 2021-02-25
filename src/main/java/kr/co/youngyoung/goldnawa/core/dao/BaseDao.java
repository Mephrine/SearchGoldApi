package kr.co.youngyoung.goldnawa.core.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T, P> {
    protected static final String QUERY_ID_PREFIX = "test";

    @Autowired
    public MybatisDao<T, P> databaseDao;
}