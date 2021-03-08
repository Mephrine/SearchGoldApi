package kr.co.youngyoung.goldnawa.api.price.service;

import kr.co.youngyoung.goldnawa.common.domain.GoldPriceDomain;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GoldPriceHistoryService extends BaseDao<GoldPriceDomain, GoldPriceDomain> {
    final private String nameSpace = "goldPriceHistory";

    public List<GoldPriceDomain> selectList() {
        return databaseDao.selectList(nameSpace, "findList");
    }
}