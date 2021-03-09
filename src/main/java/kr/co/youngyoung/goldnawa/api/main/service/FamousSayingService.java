package kr.co.youngyoung.goldnawa.api.main.service;

import kr.co.youngyoung.goldnawa.common.domain.AppVersionDomain;
import kr.co.youngyoung.goldnawa.common.domain.FamousSayingDomain;
import kr.co.youngyoung.goldnawa.common.domain.GoldPriceDomain;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.stereotype.Component;

@Component
public class FamousSayingService extends BaseDao<FamousSayingDomain, GoldPriceDomain> {
    final private String NAMESPACE = "famousSaying";

    public FamousSayingDomain selectOne() {
        return databaseDao.selectOne(NAMESPACE);
    }
}