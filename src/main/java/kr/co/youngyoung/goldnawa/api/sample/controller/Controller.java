package kr.co.youngyoung.goldnawa.api.sample.controller;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Item;
import io.swagger.annotations.ApiOperation;
import kr.co.youngyoung.goldnawa.api.sample.service.SampleService;
import kr.co.youngyoung.goldnawa.common.domain.SampleDomain;
import kr.co.youngyoung.goldnawa.core.annotation.ApiVersion;
import kr.co.youngyoung.goldnawa.core.controller.BaseController;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@ApiVersion({1})
@RequestMapping(path = "/api")
public class Controller extends BaseController {
    @Autowired
    SampleService sampleService;

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



    @GetMapping(path = "/rss")
    @ApiOperation(value = "샘플 매핑",
            notes = "이것은 샘플 매핑입니다")
    public Channel rss() {
        Channel channel = new Channel();
        channel.setFeedType("rss_2.0");
        channel.setTitle("Our Story | 현대카드·현대캐피탈 뉴스룸");
        channel.setDescription("Our Story, 현대카드·현대캐피탈 내 다양한 소식과 기업문화, 임직원들의 이야기를 소개합니다. 현대카드·현대캐피탈 뉴스룸");
        channel.setLink("https://newsroom.hcs.com/front/board/list?sort=1&menuCategory=MNC003&contentCategory=&topMenuCd=FMC003");
        channel.setGenerator("현대카드·현대캐피탈");

        Date postDate = new Date();
        channel.setPubDate(postDate);

        List itemList = new ArrayList();
        {
            Item item = new Item();
            item.setAuthor("현대카드·현대캐피탈");
            item.setLink("https://newsroom.hcs.com/front/board/%EC%9D%B4-%ED%9A%8C%EC%82%AC%EA%B0%80-%EC%BD%94%EB%A1%9C%EB%82%9819%EB%A5%BC-%EC%9D%B4%EA%B2%A8%EB%82%B4%EB%8A%94-%EB%B0%A9%EB%B2%95");
            item.setTitle("이 회사가 코로나19를 이겨내는 방법");

            com.rometools.rome.feed.rss.Category category = new com.rometools.rome.feed.rss.Category();
            category.setValue("Our Story");
            item.setCategories(Collections.singletonList(category));

            Description descr = new Description();
            descr.setValue("백신휴가 도입, 비대면 실적발표회, 채용 등 전 영역에서 변화를 꾀하는 현대카드·현대캐피탈");
            item.setDescription(descr);
            item.setPubDate(postDate);
            itemList.add(item);
        }
        {
            Item item = new Item();
            item.setAuthor("현대카드·현대캐피탈");
            item.setLink("https://newsroom.hcs.com/front/board/%ED%8B%B0%EC%A0%80%EB%A5%BC-%EA%B3%B5%EA%B0%9C%ED%95%A9%EB%8B%88%EB%8B%A4");
            item.setTitle("티저를 공개합니다!");

            com.rometools.rome.feed.rss.Category category = new com.rometools.rome.feed.rss.Category();
            category.setValue("Our Story");
            item.setCategories(Collections.singletonList(category));

            Description descr = new Description();
            descr.setValue("국내 대표적인 ‘금융테크’ 현대카드와 ‘빅테크’ 네이버가 그리는 파트너십의 미래를 조인식 현장에서 엿보다");
            item.setDescription(descr);
            item.setPubDate(postDate);
            itemList.add(item);
        }
        channel.setItems(itemList);

        return channel;
    }
}
