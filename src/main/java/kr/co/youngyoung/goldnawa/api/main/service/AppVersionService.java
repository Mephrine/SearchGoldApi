package kr.co.youngyoung.goldnawa.api.main.service;

import kr.co.youngyoung.goldnawa.common.domain.AppVersionDomain;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AppVersionService extends BaseDao<AppVersionDomain, AppVersionDomain> {
    public AppVersionService(){
        super("appVersion");
    }

    /**
    * 앱 최신 버전을 가져온다
    * */
    public ApiResponseObject getLatestAppVersion() {
        setHttpStatus(HttpStatus.OK);
        setResultStatusCd(ResultStatusCd.SUCCESS);

        return ApiResponseObject
                .data(databaseDao.selectOne(getNameSpace()))
                .httpStatusCd(getHttpStatus())
                .resultStatus(getResultStatusCd())
                .build();
    }
}