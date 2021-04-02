package kr.co.youngyoung.goldnawa.api.sample.controller;

import com.rometools.rome.feed.rss.*;
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
        Image image = new Image();
        image.setTitle("현대카드·현대캐피탈 뉴스룸");
        image.setUrl("https://newsroom.hcs.com/images/common/empty_img_m.png");
        image.setLink("https://newsroom.hcs.com");
        channel.setImage(image);
        channel.setStyleSheet("https://newsroom.hcs.com/css/mobile.css");

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
            Guid guid = new Guid();
            guid.setPermaLink(false);
            guid.setValue("https://newsroom.hcs.com/front/board/%EC%9D%B4-%ED%9A%8C%EC%82%AC%EA%B0%80-%EC%BD%94%EB%A1%9C%EB%82%9819%EB%A5%BC-%EC%9D%B4%EA%B2%A8%EB%82%B4%EB%8A%94-%EB%B0%A9%EB%B2%95");
            item.setGuid(guid);
            Content content = new Content();
            content.setType("encode");
            content.setValue("<p>내용1</p>");
            item.setContent(content);
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
            item.setPubDate(postDate);Guid guid = new Guid();
            guid.setPermaLink(false);
            guid.setValue("https://newsroom.hcs.com/front/board/%ED%8B%B0%EC%A0%80%EB%A5%BC-%EA%B3%B5%EA%B0%9C%ED%95%A9%EB%8B%88%EB%8B%A4");
            item.setGuid(guid);
            Content content = new Content();
            content.setType("encode");
            content.setValue("<p>내용2</p>");
            item.setContent(content);

            itemList.add(item);
        }

        {
            Item item = new Item();
            item.setAuthor("현대카드·현대캐피탈");
            item.setLink("https://newsroom.hcs.com/front/board/%EB%94%94%EC%9E%90%EC%9D%B8%EB%8F%84-BOOST%ED%95%B4%EB%B2%84%EB%A0%B8%EC%A7%80-%EB%AD%90%EC%95%BC");
            item.setTitle("디자인도 BOOST해버렸지 뭐야");

            com.rometools.rome.feed.rss.Category category = new com.rometools.rome.feed.rss.Category();
            category.setValue("Our Story");
            item.setCategories(Collections.singletonList(category));

            Description descr = new Description();
            descr.setValue("미니멀리즘의 옷을 벗은 '현대카드 MX BOOST' 디자인");
            item.setDescription(descr);
            item.setPubDate(postDate);Guid guid = new Guid();
            guid.setPermaLink(false);
            guid.setValue("https://newsroom.hcs.com/front/board/%EB%94%94%EC%9E%90%EC%9D%B8%EB%8F%84-BOOST%ED%95%B4%EB%B2%84%EB%A0%B8%EC%A7%80-%EB%AD%90%EC%95%BC");
            item.setGuid(guid);
            Content content = new Content();
            content.setType("encode");
            content.setValue("<p>내용3</p>");
            item.setContent(content);

            itemList.add(item);
        }

        {
            Item item = new Item();
            item.setAuthor("삼성전자 뉴스룸");
            item.setLink("https://news.samsung.com/kr/%ea%b5%bf%eb%b0%94%ec%9d%b4-%eb%b0%b1%ec%83%89%ea%b0%80%ec%a0%84-360%ea%b0%9c%ec%9d%98-%ec%bb%ac%eb%9f%ac%eb%a1%9c-%ec%a3%bc%eb%b0%a9%ec%97%90-%ed%94%84%eb%a6%ac%ec%a6%98%ec%9d%84-%ec%9e%85%ed%9e%88?utm_source=rss&amp;utm_medium=direct");
            item.setTitle("[굿바이 백색가전] 360개의 컬러로 주방에 프리즘을 입히다");

            com.rometools.rome.feed.rss.Category category = new com.rometools.rome.feed.rss.Category();
            category.setValue("비스포크");
            item.setCategories(Collections.singletonList(category));

            Description descr = new Description();
            descr.setValue("<![CDATA[‘천편일률적인 백색가전의 시대는 갔다’ 삼성전자 비스포크가 사용자들의 라이프스타일을 화사하게 색칠할 준비를 마쳤다. 올해의 테마 색상인 ‘글램 썬 옐로우’와 ‘코타 그리너리’를 포함해 총 22가지 종류의 패널[1]을 기본 옵션으로 제공하고, ‘나만의 컬러’를 원할 경우 무려]]>");
            item.setDescription(descr);
            item.setPubDate(postDate);Guid guid = new Guid();
            guid.setPermaLink(false);
            guid.setValue("https://bit.ly/3sJAp0E");
            item.setGuid(guid);
            Content content = new Content();
            content.setType("encode");
            content.setValue("<![CDATA[<p><img class=\"alignnone size-full wp-image-417321\" src=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-1.jpg\" alt=\"감성디자인그룹 김소희 그룹장과 홍지담 디자이너\" width=\"1000\" height=\"666\" srcset=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-1.jpg 1000w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-1-845x563.jpg 845w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-1-768x511.jpg 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" /></p><p>‘천편일률적인 백색가전의 시대는 갔다’</p><p>삼성전자 비스포크가 사용자들의 라이프스타일을 화사하게 색칠할 준비를 마쳤다. 올해의 테마 색상인 ‘글램 썬 옐로우’와 ‘코타 그리너리’를 포함해 총 22가지 종류의 패널<a href=\"#_ftn1\" name=\"_ftnref1\"><sup>[1]</sup></a>을 기본 옵션으로 제공하고, ‘나만의 컬러’를 원할 경우 무려 360가지의 컬러 팔레트 중에서 원하는 컬러를 고를 수 있다.</p><p>무한한 색상 스펙트럼에서 360가지를 엄선해 구성한 ‘프리즘 360 컬러’는 사용자가 직접 취향에 맞는 색 배합으로 패널을 구성할 수 있다. 우수한 색상 재현은 물론 무한한 확장이 가능해 나만의 개성이 담긴 다채로운 공간을 완성할 수 있다. 사용자의 맞춤형 경험을 위해 다시 태어난 ‘프리즘 360 컬러’ 비하인드 스토리를 듣기 위해 삼성디지털프라자 강남 본점 6층에 위치한 비스포크 아틀리에에서 삼성전자 생활가전사업부 감성디자인그룹 김소희 그룹장과 홍지담 디자이너를 직접 만났다.</p><p>&nbsp;</p><p><span style=\"color: #000080;\"><strong>더욱 세밀해지는 사용자의 취향, 비스포크로 다가가다</strong></span></p><p>지난해부터 집에 머무는 시간이 늘어나면서 공간을 바라보는 사용자들의 시선도 점차 달라졌다. 오래 머무는 공간을 더욱 아름답게 꾸미기 위해 내부를 구성하는 가전의 디자인에 관심이 높아진 것. 용량과 성능은 기본으로 갖추고, 화려한 옷을 입은 비스포크는 이런 흐름을 타고 사용자들의 필요를 충족시켜줄 수 있는 제품으로 급부상했다. 이제 가전은 공간 이미지에서 배제되었던 과거와 달리, 사용자들이 SNS에 자랑스럽게 내보일 수 있는 디자인의 한 부분으로 자리 잡고 있다.</p><p><img class=\"alignnone size-full wp-image-417314\" src=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360-2.jpg\" alt=\"비스포크 라이프스타일 컷\" width=\"1000\" height=\"498\" srcset=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360-2.jpg 1000w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360-2-768x382.jpg 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" /></p><p>김소희 그룹장은 “비스포크 출시 이후 가전제품을 구매할 때 주방에서의 조화나 심미적 가치를 중요하게 생각하는 소비자가 늘어났다”고 설명했다.</p><p>더불어 사용자들이 보는 가전 디자인의 폭과 깊이도 한층 진화했다. ‘화이트’, ‘그레이’와 같은 기본 색상을 넘어 톤과 색상에서 느껴지는 온도, 질감까지도 고려하게 된 것. 홍지담 디자이너는 “이제 사용자들은 가진 디자인을 고려할 때 디테일한 컬러와 질감은 물론, 화이트 컬러를 선택할 때도 어느 정도의 톤을 원하는지까지 명확하게 언급한다”고 말했다.</p><p>&nbsp;</p><p><span style=\"color: #000080;\"><strong>‘하늘 아래 같은 색은 없다’ 명도와 채도에 따라 펼쳐진 360개의 컬러</strong></span></p><p>색상에 대한 소비자들의 안목이 높아지며 비스포크 패널의 컬러 선택지도 확장이 필요했다. 김소희 그룹장은 “비스포크는 생산자 중심에서 사용자가 제품의 디자인을 ‘선택’하는 패러다임으로 시장의 구조를 바꿔놓은 제품이다. 따라서 제품의 디자인 역시 사용자들의 공간과 취향에 맞춰 더 디테일하게 진화해야 한다”고 말했다.</p><p>컬러의 범위는 무한하다. 하나의 색에서 명도와 채도를 조금씩 조절하는 것만으로도 새로운 컬러가 탄생하기 때문. 디자이너들은 우선 공간과 어울리면서도 제품을 빛나게 해줄 컬러들을 골라냈다. 일반인의 눈으로 구별 가능한 1,360개의 컬러로 범위를 좁혔고, 이 중에서도 자주 사용되는 기본 컬러 영역을 고려해 360개의 컬러를 최종 엄선했다. 홍지담 디자이너는 “모든 사람들에게 친숙하고 구별이 쉬운 6가지 기준 컬러를 선택하고, 각 컬러군 안에서도 채도와 명도가 다른 60개의 컬러들을 포함했다”고 말했다.</p><p><img class=\"alignnone size-full wp-image-417323\" src=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-3.jpg\" alt=\"비스포크 360 프리즘 컬러 샘플\" width=\"1000\" height=\"666\" srcset=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-3.jpg 1000w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-3-845x563.jpg 845w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-3-768x511.jpg 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" /></p><p>컬러 팔레트를 구성할 때 특별히 주의를 기울인 부분은 바로 오프 화이트(Off whites) 군이다. 오프 화이트는 순수한 흰색이 아닌, 다른 색이 소량 가미된 다양한 톤의 흰색을 통칭하는 색상 군. 김소희 그룹장은 “가전제품의 색상에는 톤이 각기 다른 화이트 계열 색상이 사용된다. 그만큼 사용자들에게 화이트 컬러가 노출되는 빈도가 잦아 보는 눈도 자연스럽게 세밀해진다”며 “인테리어나 가전 디자인에 자주 사용되는 만큼 오프화이트 계열로만 24개의 색상을 선정했다. 앞으로 더욱 개수를 늘려갈 예정이다”라고 설명했다.</p><p>&nbsp;</p><p><span style=\"color: #000080;\"><strong>컬러를 한층 선명하게, 디지털 프린팅과 프리즘 360 글래스 컬러링 공법</strong></span></p><p><img class=\"alignnone size-full wp-image-417324\" src=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-4.jpg\" alt=\"비스포크 360 프리즘 컬러 샘플\" width=\"1000\" height=\"665\" srcset=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-4.jpg 1000w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-4-847x563.jpg 847w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-4-768x511.jpg 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" /></p><p>단순히 컬러 팔레트를 넓히는 것을 넘어, 비스포크가 더 선명한 색상을 입을 수 있도록 인쇄 공법에도 변화를 줬다. 안료를 섞은 잉크를 미리 제작해 인쇄했던 전통 프린팅 방식에서 벗어나, 처음으로 디지털 프린팅 방식을 시도한 것. 시안, 마젠타, 옐로우, 블랙과 같은 4~6개의 색상을 고해상도 점(dot)으로 인쇄해 촘촘한 색상을 구현해내는 방식이다. 미리 잉크를 제작할 필요가 없어 다양한 맞춤형 패널을 빠르게 생산할 수 있다는 것이 장점이다.</p><p>이렇게 디지털 방식으로 구현한 색상을 한층 선명하고 또렷하게 만들어내는 데는 또 하나의 혁신이 필요했다. 바로 ‘프리즘 360 글래스 컬러링 공법’. 전통 프린팅에서만 사용되던 프라이머, 화이트막 단계를 처음으로 디지털 프린팅에도 적용해 색상이 눈에 잘 띄게 했다. 김소희 그룹장은 “인쇄 전 프라이머를 올려 컬러가 잘 붙을 수 있도록 했고, 인쇄 후에는 캔버스 역할을 해줄 화이트 코팅을 활용해 색상을 부각시켰다”고 말했다.</p><p>&nbsp;</p><p><span style=\"color: #000080;\"><strong>주방에 가장 어울리는 조합으로, 색상 추천과 벤자민 무어</strong></span></p><p>그렇다면 눈앞에 놓인 360개의 컬러를 어떤 방식으로 조합해야 공간과 잘 어울리면서 심미성도 갖출 수 있을까. 색상 조합이라는 과정이 낯선 사용자들의 경우 첫 컬러 선정 이후 어울리는 색상을 찾아가는 과정에서 어려움을 겪을 수도 있다.</p><p><img class=\"alignnone size-full wp-image-417325\" src=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-5.jpg\" alt=\"비스포크 360 프리즘 컬러 벤자민 무어 색상 샘플\" width=\"1000\" height=\"666\" srcset=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-5.jpg 1000w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-5-845x563.jpg 845w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-5-768x511.jpg 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" /></p><p><img class=\"alignnone size-full wp-image-417318\" src=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360-6.jpg\" alt=\"비스포크 키친핏 색상 선택 화면\" width=\"1000\" height=\"545\" srcset=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360-6.jpg 1000w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360-6-768x419.jpg 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" /></p><p>삼성전자는 이런 사용자들을 위해 한 가지 컬러를 선택하면 해당 색과 잘 어울리는 컬러를 자동으로 추천해주는 알고리즘을 도입했다. <a href=\"https://www.samsung.com/sec/bespokestudio/\" target=\"_blank\" rel=\"noopener\">삼성닷컴 2021 BESPOKE 제작소</a>에서 첫 번째 색상을 클릭하면, 해당 컬러와 조화를 이룰 수 있는 다른 색상들을 바로 아래 추천해준다. 알고리즘의 원리는 여러 배색 조합 원리들에서 가장 호불호가 없는 톤온톤<a href=\"#_ftn2\" name=\"_ftnref2\"><sup>[2]</sup></a>, 톤인톤<a href=\"#_ftn3\" name=\"_ftnref3\"><sup>[3]</sup></a> 기법을 활용했다. 추천을 따라 색상을 선택하다 보면 어렵지 않게 비스포크 디자인을 완성할 수 있다.</p><p><img class=\"alignnone size-full wp-image-417326\" src=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-7.jpg\" alt=\"비스포크 360 프리즘 컬러 벤자민 무어 색상 조합 샘플 \" width=\"1000\" height=\"665\" srcset=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-7.jpg 1000w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-7-847x563.jpg 847w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-7-768x511.jpg 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" /></p><p>아예 다른 계열의 색상들로 비스포크 디자인을 구성하고 싶다면? 글로벌 프리미엄 페인트 기업인 ‘벤자민 무어(Benjamin Moore)’와의 협업을 통해 구성된 색상 조합이 답이 될 수 있다. ‘벤자민 무어’와 함께 개발한 배합은 2021년 트렌드 컬러를 참고해 아름다움과 유행을 모두 담고 있다. 홍지담 디자이너는 “알고리즘이 같은 색상 계열 안에서 다양한 톤을 조합하도록 유도한다면, 벤자민 무어의 조합은 색다른 배합으로 색채에 리듬감을 더했다”고 설명했다.</p><p><img class=\"alignnone size-full wp-image-417327\" src=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-8.jpg\" alt=\"감성디자인그룹 김소희 그룹장과 홍지담 디자이너\" width=\"1000\" height=\"666\" srcset=\"https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-8.jpg 1000w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-8-845x563.jpg 845w, https://img.kr.news.samsung.com/kr/wp-content/uploads/2021/03/360color-8-768x511.jpg 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" /></p><p>1,360개의 색상 샘플을 전부 제작해 살피는 고된 과정에도 디자이너들이 포기하지 않았던 것은 ‘비스포크로 인해 내 삶의 공간이 아름다워졌다’고 언급하는 소비자들 덕분이었다. 홍지담 디자이너는 “색감뿐만 아니라 색상에 담긴 온도, 질감을 통해 더욱 섬세한 공감각을 선사하기 위해 지속적으로 연구하고 노력하겠다”고 말했다.</p><p>비스포크 컬러 팔레트 역시 여기서 멈추지 않고 앞으로 더욱 다채로워질 예정이다. 남아있는 1,000개의 컬러를 어떤 스토리와 함께 사용자들에게 제공할지 치열한 고민 중이기 때문. 김소희 그룹장은 “눈에 자주 보이는 제품일수록 아름다워야 하고, 그래야 삶이 행복해진다고 생각한다. 비스포크가 사용자의 공간에 들어가 일상을 더욱 아름답게 바꿀 수 있도록 더 나은 디자인을 끊임없이 고민할 것”이라고 포부를 전했다.</p><hr /><div class=\"footnotes\"><p class=\"footnotes\"><a href=\"#_ftnref1\" name=\"_ftn1\">[1]</a>22가지 색상 옵션 : 1) 코타 6종: 화이트, 차콜, 그리너리, 썬 옐로우, 페블, 펀그린, 2) 글램 7종: 화이트, 핑크, 네이비, 피치, 바닐라, 그리너리, 썬 옐로우, 3) 새틴 5종: 그레이, 베이지, 스카이블루, 마린, 토프, 4) 페닉스 3종: 베이지, 다크 그레이, 블랙, 5) Vinyl Coated Metal 1종: 브라우니 실버</p><p class=\"footnotes\"><a href=\"#_ftnref2\" name=\"_ftn2\">[2]</a>동일한 색상과 채도 내에서 명도 차이를 이용한 배색 기법</p><p class=\"footnotes\"><a href=\"#_ftnref3\" name=\"_ftn3\">[3]</a>동일한 채도와 명도 내에서 색상 차이를 이용한 배색 기법</p></div>]]>");
            item.setContent(content);

            itemList.add(item);
        }

        channel.setItems(itemList);

        return channel;
    }
}
