package kr.co.youngyoung.goldnawa.api.main.service;

import kr.co.youngyoung.goldnawa.common.domain.AppVersionDomain;
import kr.co.youngyoung.goldnawa.common.domain.GoldPriceDomain;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppVersionService extends BaseDao<AppVersionDomain, GoldPriceDomain> {
    final private String NAMESPACE = "appVersion";

    public AppVersionDomain selectOne() {
        return databaseDao.selectOne(NAMESPACE, "findOne");
    }
}