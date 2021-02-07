package kr.co.youngyoung.goldnawa.api.sample.contoller;

import io.swagger.annotations.ApiOperation;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class Controller {
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(path = "/sample")
    @ApiOperation(value = "샘플 매핑",
            notes = "이것은 샘플 매핑입니다")
    public ApiResponseObject<String> sample(@RequestParam String testPram) {
        logger.info("Test");

        ApiResponseObject<String> sample = new ApiResponseObject
                .Builder<String>()
                .data("TEST")
                .httpStatusCd(HttpStatus.OK)
                .resultStatus(ResultStatusCd.SUCCESS)
                .build();

        return sample;
    }
}
