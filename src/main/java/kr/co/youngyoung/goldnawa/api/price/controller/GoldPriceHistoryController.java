package kr.co.youngyoung.goldnawa.api.price.controller;

import io.swagger.annotations.ApiOperation;
import kr.co.youngyoung.goldnawa.api.price.service.GoldPriceHistoryService;
import kr.co.youngyoung.goldnawa.api.sample.service.SampleService;
import kr.co.youngyoung.goldnawa.common.domain.GoldPriceDomain;
import kr.co.youngyoung.goldnawa.core.annotation.ApiVersion;
import kr.co.youngyoung.goldnawa.core.base.controller.BaseController;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@ApiVersion({1})
@RequestMapping(path = "/api")
public class GoldPriceHistoryController extends BaseController {
    @Autowired
    GoldPriceHistoryService goldPriceHistoryService;

    @GetMapping(path = "/goldPriceHistory")
    @ApiOperation(value = "금값 히스토리 조회", notes = "금값 히스토리 조회 화면 입니다")
    public ApiResponseObject<List<GoldPriceDomain>> goldPriceHistory() {
        List<GoldPriceDomain> goldPriceHistoryList = goldPriceHistoryService.selectList();

        getLogger().info("test {}", goldPriceHistoryList);

        ApiResponseObject<List<GoldPriceDomain>> sample = new ApiResponseObject
                .Builder<List<GoldPriceDomain>>()
                .data(goldPriceHistoryList)
                .httpStatusCd(HttpStatus.OK)
                .resultStatus(ResultStatusCd.SUCCESS)
                .build();

        return sample;
    }
}
