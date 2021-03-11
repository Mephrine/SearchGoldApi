package kr.co.youngyoung.goldnawa.api.sample.service;

import kr.co.youngyoung.goldnawa.common.domain.SampleDomain;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.stereotype.Service;

@Service
public class SampleService extends BaseDao<SampleDomain, SampleDomain> {
    public SampleService(){
        super("sample");
    }
    public SampleDomain selectOne() {
        return databaseDao.selectOne(getNameSpace(), "findBySample");
    }
}