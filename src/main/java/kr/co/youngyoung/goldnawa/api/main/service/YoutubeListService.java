package kr.co.youngyoung.goldnawa.api.main.service;

import kr.co.youngyoung.goldnawa.common.domain.YoutubeListDomain;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class YoutubeListService extends BaseDao<YoutubeListDomain, YoutubeListDomain> {
    public YoutubeListService(){
        super("youtubeList");
    }

    /**
    * 유투브 리스트를 가져온다
    * */
    public ApiResponseObject getYouTubeList() {
        setHttpStatus(HttpStatus.OK);
        setResultStatusCd(ResultStatusCd.SUCCESS);

        return ApiResponseObject
                .data(databaseDao.selectList(getNameSpace()))
                .httpStatusCd(getHttpStatus())
                .resultStatus(getResultStatusCd())
                .build();
    }
}