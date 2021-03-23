package kr.co.youngyoung.goldnawa.core.code.repository.impl;

import kr.co.youngyoung.goldnawa.core.code.domain.CommonCodeDomain;
import kr.co.youngyoung.goldnawa.core.code.repository.SimpleCommonCodeRepository;
import kr.co.youngyoung.goldnawa.core.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CacheCommonCodeRepository implements SimpleCommonCodeRepository {
    @Autowired
    public MybatisService<CommonCodeDomain, CommonCodeDomain> databaseDao;

    @Override
    @Cacheable(value="commonCodeCache", key="#name")
    public List<CommonCodeDomain> getCommonCodeList() {
        slowQuery(1000);
        return databaseDao.selectList(NAMESPACE);
    }

    // 빅쿼리를 돌린다는 가정
    private void slowQuery(long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
