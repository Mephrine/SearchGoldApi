package kr.co.youngyoung.goldnara.api.sample.contoller;

import kr.co.youngyoung.goldnara.common.domain.ApiDomain;
import kr.co.youngyoung.goldnara.common.domain.value.ResultStatusCd;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(path = "/sample")
    public ApiDomain sample(){
        ApiDomain sample = new ApiDomain
                .Builder<String>()
                .data("TEST")
                .httpStatusCd(HttpStatus.OK)
                .resultStatus(ResultStatusCd.SUCCESS)
                .build();

        return sample;
    }
}
