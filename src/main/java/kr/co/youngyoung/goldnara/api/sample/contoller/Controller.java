package kr.co.youngyoung.goldnara.api.sample.contoller;

import kr.co.youngyoung.goldnara.common.domain.Sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(path = "/sample")
    public Sample sample(){
        Sample sample = new Sample();
        sample.setMessage("test api 2");

        return sample;
    }
}
