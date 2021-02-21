package kr.co.youngyoung.goldnara.api.main.contoller;

import kr.co.youngyoung.goldnara.common.domain.ApiDomain;
import kr.co.youngyoung.goldnara.common.domain.value.ResultStatusCd;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping(path = "/appInfo")
    public ApiDomain sample(){

        // TO-DO : We need to create an 'app_version' table in PG Database.
        Map<String,String> appVersionVO = new LinkedHashMap<String,String>();
        appVersionVO.put("app_version","1.0");

        ApiDomain sample = new ApiDomain
                .Builder<Map>()
                .data(appVersionVO)
                .httpStatusCd(HttpStatus.OK)
                .resultStatus(ResultStatusCd.SUCCESS)
                .build();

        return sample;
    }

    @GetMapping(path = "famousSaying")
    public ApiDomain famousSaying(){

        // TO-DO : We need to create an 'tbl_famous_saying' table in PG Database.
        Map<String,Object> famousSayingVO = new LinkedHashMap<String,Object>();

        famousSayingVO.put("seq","1");
        famousSayingVO.put("famous_saying","유명한 명언 입니다. \n 돈은 최고입니다.");
        famousSayingVO.put("famous_saying_writer","워렌버블");
        famousSayingVO.put("use_yn","Y");
        famousSayingVO.put("display_yn","Y");
        famousSayingVO.put("del_yn","N");
        famousSayingVO.put("reg_user","버블");
        famousSayingVO.put("reg_date","2021-02-21 15:54:00");
        famousSayingVO.put("mod_user","버블");
        famousSayingVO.put("mod_date","2021-02-21 15:54:00");

        ApiDomain sample = new ApiDomain
                .Builder<Map>()
                .data(famousSayingVO)
                .httpStatusCd(HttpStatus.OK)
                .resultStatus(ResultStatusCd.SUCCESS)
                .build();

        return sample;

    }

}
