package kr.co.youngyoung.goldnawa.api.price.service;

import kr.co.youngyoung.goldnawa.common.domain.GoldPriceDomain;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoldPriceHistoryService extends BaseDao<GoldPriceDomain, GoldPriceDomain> {
    public GoldPriceHistoryService(){
        super("goldPriceHistory");
    }

    public List<GoldPriceDomain> selectList() {
        return databaseDao.selectList(getNameSpace());
    }
}