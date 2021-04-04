package kr.co.youngyoung.goldnawa.api.sample.controller;

import io.swagger.annotations.ApiOperation;
import kr.co.youngyoung.goldnawa.api.sample.service.SampleService;
import kr.co.youngyoung.goldnawa.common.domain.SampleDomain;
import kr.co.youngyoung.goldnawa.core.annotation.ApiVersion;
import kr.co.youngyoung.goldnawa.core.controller.BaseController;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiVersion({1})
@RequestMapping(path = "/api")
public class Controller extends BaseController {
    @Autowired
    SampleService sampleService;
    
    @Value("${spring.profiles}")
    String profiles;

    @GetMapping(path = "/sample")
    @ApiOperation(value = "샘플 매핑",
            notes = "이것은 샘플 매핑입니다")
    public ApiResponseObject sample(@RequestParam String testPram) {
        getLogger().info("Test");

        SampleDomain str = sampleService.selectOne();

        ApiResponseObject sample = new ApiResponseObject
                .Builder<SampleDomain>()
                .data(str)
                .httpStatusCd(HttpStatus.OK)
                .resultStatus(ResultStatusCd.SUCCESS)
                .build();

        return sample;
    }

    @GetMapping(path = "/profile")
    @ApiOperation(value = "프로파일",
            notes = "이것은 샘플 매핑입니다")
    public String profile() {
        return profiles;
    }
}
