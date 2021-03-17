package kr.co.youngyoung.goldnawa.api.main.service;

import kr.co.youngyoung.goldnawa.common.domain.AppVersionDomain;
import kr.co.youngyoung.goldnawa.common.domain.FamousSayingDomain;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class FamousSayingService extends BaseDao<FamousSayingDomain, FamousSayingDomain> {
    public FamousSayingService(){
        super("famousSaying");
    }
    
    /**
     * 무작위 명언을 가져온다
     * */
    public ApiResponseObject<FamousSayingDomain> getFamousSaying() {

        setHttpStatus(HttpStatus.OK);
        setResultStatusCd(ResultStatusCd.SUCCESS);

        return ApiResponseObject
                .data(databaseDao.selectOne(getNameSpace()))
                .httpStatusCd(getHttpStatus())
                .resultStatus(getResultStatusCd())
                .build();
    }
}