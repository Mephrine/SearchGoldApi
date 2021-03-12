package kr.co.youngyoung.goldnawa.api.price.service;

import kr.co.youngyoung.goldnawa.common.domain.GoldPriceDomain;
import kr.co.youngyoung.goldnawa.common.domain.GoldPriceParameterDomain;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoldPriceHistoryService extends BaseDao<GoldPriceDomain, GoldPriceParameterDomain> {
    public GoldPriceHistoryService(){
        super("goldPriceHistory");
    }

    public ApiResponseObject<List<GoldPriceDomain>> getGoldPriceHistory() {
        setHttpStatus(HttpStatus.OK);
        setResultStatusCd(ResultStatusCd.SUCCESS);

        return ApiResponseObject
                .data(databaseDao.selectList(getNameSpace()))
                .httpStatusCd(getHttpStatus())
                .resultStatus(getResultStatusCd())
                .build();
    }

    public ApiResponseObject<List<GoldPriceDomain>> getGoldPriceHistoryDetail(GoldPriceParameterDomain goldPriceParameterDomain) {
        setHttpStatus(HttpStatus.OK);
        setResultStatusCd(ResultStatusCd.SUCCESS);

        return ApiResponseObject
                .data(databaseDao.selectList(getNameSpace(), "Detail", goldPriceParameterDomain))
                .httpStatusCd(getHttpStatus())
                .resultStatus(getResultStatusCd())
                .build();
    }
}