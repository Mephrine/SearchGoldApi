package kr.co.youngyoung.goldnawa.api.sample.service;

import kr.co.youngyoung.goldnawa.common.domain.SampleDomain;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.stereotype.Component;

@Component
public class SampleService extends BaseDao<SampleDomain, String> {
    public SampleDomain selectOne() {
        return databaseDao.selectOne("sample.findBySample");
    }
}