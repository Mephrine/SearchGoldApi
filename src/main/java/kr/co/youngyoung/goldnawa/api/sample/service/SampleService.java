package kr.co.youngyoung.goldnawa.api.sample.service;

import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.stereotype.Component;

@Component
public class SampleService extends BaseDao<String, String> {
    public String selectOne() {
        return databaseDao.selectOne("sample.findBySample");
    }
}