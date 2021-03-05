package kr.co.youngyoung.goldnawa.core.mybatis.dao;

import kr.co.youngyoung.goldnawa.core.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T, P> {
    protected static final String QUERY_ID_PREFIX = "test";

    @Autowired
    public MybatisService<T, P> databaseDao;
}