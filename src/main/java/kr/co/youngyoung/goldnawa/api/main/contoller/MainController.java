package kr.co.youngyoung.goldnawa.api.main.contoller;

import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import kr.co.youngyoung.goldnawa.api.main.service.AppVersionService;
import kr.co.youngyoung.goldnawa.api.main.service.FamousSayingService;
import kr.co.youngyoung.goldnawa.api.main.service.YoutubeListService;
import kr.co.youngyoung.goldnawa.api.price.service.GoldPriceHistoryService;
import kr.co.youngyoung.goldnawa.common.domain.AppVersionDomain;
import kr.co.youngyoung.goldnawa.common.domain.FamousSayingDomain;
import kr.co.youngyoung.goldnawa.common.domain.GoldPriceParameterDomain;
import kr.co.youngyoung.goldnawa.common.domain.YoutubeListDomain;
import kr.co.youngyoung.goldnawa.core.annotation.ApiVersion;
import kr.co.youngyoung.goldnawa.core.controller.BaseController;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;

@RestController
@ApiVersion({1})
@RequestMapping("/api")
public class MainController extends BaseController {
    @Autowired
    AppVersionService appVersionService;
    @Autowired
    FamousSayingService famousSayingService;
    @Autowired
    YoutubeListService youtubeListService;
    @Autowired
    GoldPriceHistoryService goldPriceHistoryService;

    /**
     * 앱 최신 버전을 조회한다
     * */
    @GetMapping(path = "/appVersion")
    @ApiOperation(value = "앱 버전 조회", notes = "앱 최신 버전 조회")
    public ApiResponseObject<AppVersionDomain> appVersion() {
        return appVersionService.getLatestAppVersion();
    }
    
    /**
     * 무작위 명언을 조회한다
     * */
    @GetMapping(path = "/famousSaying")
    @ApiOperation(value = "명언 조회", notes = "무작위 금과 관련된 명언 조회")
    public ApiResponseObject<FamousSayingDomain> famousSaying() {
        return famousSayingService.getFamousSaying();
    }

    /**
     * 무작위 명언을 조회한다
     * */
    @GetMapping(path = "/youtubeList")
    @ApiOperation(value = "유투브 리스트", notes = "금과 관련된 추천 영상 조회")
    public ApiResponseObject<List<YoutubeListDomain>> youtubeList() {
        return youtubeListService.getYouTubeList();
    }

    /**
     * 앱 초기 구동시 조회
     * */
    @GetMapping(path = "/appInitData")
    @ApiOperation(value = "앱 구동시 데이터", notes = "앱 버전, 명언, 최근 시세 3일치 조회")
    public ApiResponseObject<HashMap<String, Object>> appInitData() {
        HashMap<String, Object> hashMap = Maps.newHashMap();

        hashMap.put("appVersionDomain", appVersionService.getLatestAppVersion().getData());
        hashMap.put("famousSayingDomain", famousSayingService.getFamousSaying().getData());
        GoldPriceParameterDomain goldPriceParameterDomain = new GoldPriceParameterDomain("gold", "buy", "recent", "");
        hashMap.put("goldPriceDomain", goldPriceHistoryService.getGoldPriceHistoryDetail(goldPriceParameterDomain).getData());

        return ApiResponseObject
                .data(hashMap)
                .httpStatusCd(HttpStatus.OK)
                .resultStatus(ResultStatusCd.SUCCESS)
                .build();
    }
    
}
