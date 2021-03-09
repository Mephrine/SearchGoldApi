package kr.co.youngyoung.goldnawa.api.main.contoller;

import kr.co.youngyoung.goldnawa.api.main.service.AppVersionService;
import kr.co.youngyoung.goldnawa.api.main.service.FamousSayingService;
import kr.co.youngyoung.goldnawa.api.price.service.GoldPriceHistoryService;
import kr.co.youngyoung.goldnawa.common.domain.AppVersionDomain;
import kr.co.youngyoung.goldnawa.common.domain.FamousSayingDomain;
import kr.co.youngyoung.goldnawa.core.annotation.ApiVersion;
import kr.co.youngyoung.goldnawa.core.base.controller.BaseController;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@ApiVersion({1})
@RequestMapping("/api")
public class MainController extends BaseController {
    @Autowired
    AppVersionService appVersionService;
    @Autowired
    FamousSayingService famousSayingService;

    @ApiVersion({1, 1.1})
    @GetMapping(path = "/appVersion")
    public ApiResponseObject appVersion(){
        AppVersionDomain appVersionDomain = appVersionService.selectOne();

        ApiResponseObject sample = new ApiResponseObject
                .Builder<AppVersionDomain>()
                .data(appVersionDomain)
                .httpStatusCd(HttpStatus.OK)
                .resultStatus(ResultStatusCd.SUCCESS)
                .build();

        return sample;
    }

    @GetMapping(path = "famousSaying")
    public ApiResponseObject famousSaying(){
        FamousSayingDomain famousSayingDomain = famousSayingService.selectOne();

        ApiResponseObject sample = new ApiResponseObject
                .Builder<FamousSayingDomain>()
                .data(famousSayingDomain)
                .httpStatusCd(HttpStatus.OK)
                .resultStatus(ResultStatusCd.SUCCESS)
                .build();

        return sample;
    }

}
