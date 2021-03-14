package kr.co.youngyoung.goldnawa.api.price.controller;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.youngyoung.goldnawa.api.price.service.GoldPriceHistoryService;
import kr.co.youngyoung.goldnawa.common.domain.GoldPriceDomain;
import kr.co.youngyoung.goldnawa.common.domain.GoldPriceParameterDomain;
import kr.co.youngyoung.goldnawa.core.annotation.ApiVersion;
import kr.co.youngyoung.goldnawa.core.controller.BaseController;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return goldPriceHistoryService.getGoldPriceHistory();
    }

    @GetMapping(path = "/goldPriceHistory/{item}/{method}/{period}")
    @ApiOperation(value = "금값 히스토리 조회", notes = "금값 히스토리 조회 화면 입니다")
    @ApiModelProperty(value = "품목", notes = "금, 백금, 다이아 설정 가능", allowableValues = "gold, platinum, diamond")
    public ApiResponseObject<List<GoldPriceDomain>> goldPriceHistoryDetail(
            @ApiParam(value = "품목", allowableValues = "gold, platinum, diamond")
            @PathVariable(value = "item") String item,
            @ApiParam(value = "팔기/사기", allowableValues = "buy, sell")
            @PathVariable(value = "method") String method,
            @ApiParam(value = "조회 주기", allowableValues = "daily, modthly, yearly")
            @PathVariable(value = "period") String period
    ) {
        GoldPriceParameterDomain goldPriceParameterDomain = new GoldPriceParameterDomain(item, method, period);
        return goldPriceHistoryService.getGoldPriceHistoryDetail(goldPriceParameterDomain);
    }
}
