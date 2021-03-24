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
    @Cacheable(value="commonCodeCache", key="#root.methodName")
    public List<CommonCodeDomain> getCommonCodeList() {
        return databaseDao.selectList(NAMESPACE);
    }
}
