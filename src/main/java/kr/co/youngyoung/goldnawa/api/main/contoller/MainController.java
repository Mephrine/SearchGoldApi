package kr.co.youngyoung.goldnawa.api.main.contoller;

import io.swagger.annotations.ApiOperation;
import kr.co.youngyoung.goldnawa.api.main.service.AppVersionService;
import kr.co.youngyoung.goldnawa.api.main.service.FamousSayingService;
import kr.co.youngyoung.goldnawa.api.main.service.YoutubeListService;
import kr.co.youngyoung.goldnawa.common.domain.AppVersionDomain;
import kr.co.youngyoung.goldnawa.common.domain.FamousSayingDomain;
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

    /**
     * 앱 최신 버전을 조회한다
     * */
    @GetMapping(path = "/appVersion")
    @ApiOperation(value = "앱 버전 조회", notes = "앱 최신 버전 조회 화면입니다")
    public ApiResponseObject<AppVersionDomain> appVersion() {
        return appVersionService.getLatestAppVersion();
    }
    
    /**
     * 무작위 명언을 조회한다
     * */
    @GetMapping(path = "/famousSaying")
    @ApiOperation(value = "명언 조회", notes = "무작위 금과 관련된 명언조회 화면입니다")
    public ApiResponseObject<FamousSayingDomain> famousSaying() {
        return famousSayingService.getFamousSaying();
    }

    /**
     * 무작위 명언을 조회한다
     * */
    @GetMapping(path = "/youtubeList")
    @ApiOperation(value = "유투브 리스트", notes = "금과 관련된 추천 영상을 가져오는 화면입니다")
    public ApiResponseObject<YoutubeListDomain> youtubeList() {
        return youtubeListService.getYouTubeList();
    }

}
