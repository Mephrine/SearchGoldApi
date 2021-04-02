package kr.co.youngyoung.goldnawa.api.sample.controller;


import io.swagger.annotations.ApiOperation;
import kr.co.youngyoung.goldnawa.api.sample.service.SampleService;
import kr.co.youngyoung.goldnawa.common.domain.SampleDomain;
import kr.co.youngyoung.goldnawa.common.rss.domain.Channel;
import kr.co.youngyoung.goldnawa.common.rss.domain.Guid;
import kr.co.youngyoung.goldnawa.common.rss.domain.Item;
import kr.co.youngyoung.goldnawa.common.rss.domain.Rss;
import kr.co.youngyoung.goldnawa.common.rss.service.RssBuilder;
import kr.co.youngyoung.goldnawa.core.annotation.ApiVersion;
import kr.co.youngyoung.goldnawa.core.controller.BaseController;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class RssController extends BaseController {
    @Autowired
    SampleService sampleService;

    @GetMapping(path = "/rss")
    @ApiOperation(value = "샘플 매핑",
            notes = "이것은 샘플 매핑입니다")
    public void sample(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Rss rss = new Rss("2.0");

        Channel channel = new Channel();

        channel.setTitle("Our Story | 현대카드·현대캐피탈 뉴스룸");
        channel.setDescription("Our Story, 현대카드·현대캐피탈 내 다양한 소식과 기업문화, 임직원들의 이야기를 소개합니다. 현대카드·현대캐피탈 뉴스룸");
        channel.setLink("https://newsroom.hcs.com/front/board/list?sort=1&menuCategory=MNC003&contentCategory=&topMenuCd=FMC003");
        channel.setGenerator("현대카드·현대캐피탈");

        Date postDate = new Date();
        channel.setPubDate(postDate);

        List<kr.co.youngyoung.goldnawa.common.rss.domain.Item> itemList = new ArrayList();

        {
            Item item = new Item();
            item.setAuthor("현대카드·현대캐피탈");
            item.setLink("https://newsroom.hcs.com/front/board/%EC%9D%B4-%ED%9A%8C%EC%82%AC%EA%B0%80-%EC%BD%94%EB%A1%9C%EB%82%9819%EB%A5%BC-%EC%9D%B4%EA%B2%A8%EB%82%B4%EB%8A%94-%EB%B0%A9%EB%B2%95");
            item.setTitle("이 회사가 코로나19를 이겨내는 방법");
            item.setCategories(Collections.singletonList("Our Story"));
            item.setDescription("백신휴가 도입, 비대면 실적발표회, 채용 등 전 영역에서 변화를 꾀하는 현대카드·현대캐피탈");
            item.setPubDate(postDate);
            Guid guid = new Guid();
            guid.setPermaLink(false);
            guid.setValue("https://newsroom.hcs.com/front/board/%EC%9D%B4-%ED%9A%8C%EC%82%AC%EA%B0%80-%EC%BD%94%EB%A1%9C%EB%82%9819%EB%A5%BC-%EC%9D%B4%EA%B2%A8%EB%82%B4%EB%8A%94-%EB%B0%A9%EB%B2%95");
            item.setGuid(guid);
            item.setContent("<img src=\"https://newsroom.hcs.com/common/file/3ebbaa0cf46a44ec80abf0b3155ac32a/png/getImg.do\">\n" +
                    "<p class=\"img_desc\">\n" +
                    "\t(출처=gettyimageskorea.com)\n" +
                    "</p>\n" +
                    "\n" +
                    "<p>\n" +
                    "\t“흔히 비상 대책이란, 임시로 적용한다는 당초의 계획과 달리 우리 삶에 깊이 뿌리내린다. 그것이 비상 상황의 본질이다. 비상 상황들은 역사적인 변화를 이끌어낸다.”\n" +
                    "</p>\n" +
                    "<p>\n" +
                    "\t베스트 셀러 ‘사피엔스(Sapiens)’의 저자이자 세계적 석학인 유발 하라리(Yuval Noah Harari)는 최근 파이낸셜 타임즈(Financial Times)에 기고한 ‘코로나바이러스 이후의 세계(The World after coronavirus)’에서 이렇게 말했다. 이는 비단 일상에서 뿐 아니라 기업에서도 마찬가지다. 당장의 위기를 극복하기 위한 다양한 시도와 변화는 임시 방편이 아닌, 한 기업의 문화 그 자체가 될 수 있다. 역동적이고 예측하기 어려운 환경에서 직원들에게 도움을 줄 수 있는 업무 환경 개선이나 사내 복지 프로그램의 선제적인 도입은 코로나 시대는 물론 코로나 이후 시대의 새로운 기업문화를 만들어가는 촉매제 역할을 하게 된다.\n" +
                    "</p>\n" +
                    "<p>\n" +
                    "\t지난 해 코로나19가 전 세계를 강타한 후 적극적으로 대응하고 있는 현대카드·현대캐피탈(이하 현대카드)에 관심이 쏠리고 있다. 현대카드는 임직원의 건강과 감염병 확산 예방을 위해 지난해 초 재택근무를 선제적으로 시행하고, 지난 달에는 정부 발표에 앞서 유급 백신 휴가 도입을 결정하는 등 발빠르게 대처했다. 현재 전 직원을 대상으로 선택적 재택근무를 실시하고 있으며, 대면회의는 화상회의나 컨퍼런스콜로 대체해 운영하고 있다. 현대카드는 기업문화 프로그램뿐 아니라 채용, 사내 병원, 외부 행사 등 일하는 문화와 직원 복지 등 전 영역의 변화를 꾀하고 있다.\n" +
                    "</p>\n" +
                    "<p class=\"article_tit\">\n" +
                    "\t코로나 백신 휴가 선제적으로 도입\n" +
                    "</p>\n" +
                    "<div class=\"img_txt_box \">\n" +
                    "\t<div class=\"txt_box\">\n" +
                    "\t\t<p>\n" +
                    "\t\t\t정부에서 코로나 백신 휴가 강제 적용 여부를 검토하고 있다는 뉴스가 나올 무렵 현대카드 임직원용 인트라넷에는 백신 접종에 따른 이상반응 발현 여부에 상관없이 전 직원을 대상으로 유급 백신 휴가를 부여한다는 공지가 올라왔다. \n" +
                    "\t\t</p>\n" +
                    "\t\t<p>\n" +
                    "\t\t\t현대카드는 백신 이상반응이 통상적으로 접종 후 10~12시간 후 발현하기 때문에 백신을 접종한 다음날 백신휴가를 부여하기로 결정했다. 더불어, 접종당일에도 이동, 대기 및 접종 시간 등을 근무 시간으로 인정해 직원들이 업무부담없이 백신을 접종할 수 있도록 했다.\n" +
                    "\t\t</p>\n" +
                    "\t\t<p>\n" +
                    "\t\t\t현대카드 관계자는 “유급 백신휴가 도입을 통해 일반인 대상 백신 접종이 시작되면 더욱 많은 직원들이 편리하게 백신 접종에 참여할 것으로 기대한다”며 “전 직원이 백신 접종에 조기 참여해 감염병 확산 예방도 큰 도움을 줄 것으로 기대하고 있다”라고 밝혔다.\n" +
                    "\t\t</p>\n" +
                    "\t</div>\n" +
                    "\t<div class=\"img_box\">\n" +
                    "\t\t<img src=\"https://newsroom.hcs.com/common/file/0182ae590ed5472ca30e42124a364809/png/getImg.do\">\n" +
                    "\t\t<p class=\"img_desc\">\n" +
                    "\t\t\t(출처=gettyimageskorea.com)\n" +
                    "\t\t</p>\n" +
                    "\t</div>\n" +
                    "</div>\n" +
                    "<p class=\"article_tit\">\n" +
                    "\t실적 발표회 및 면접에도 비대면 방식 적용\n" +
                    "</p>\n" +
                    "<p>\n" +
                    "\t실적 발표회(IR)는 투자자로 하여금 단순히 기업에 자금을 투입하는데 그치지 않고, 투자자가 기업의 비전을 이해하고 공감하도록 하는 자리다. 때문에 현대카드는 매년 많은 투자자들의 관심을 끌어 낼 수 있도록 다양한 기업문화를 경험할 수 있는 행사를 함께 진행해왔다. 하지만, 올해는 코로나19의 지속적인 확산에 따라 비대면 방식으로 100여명의 국내외 기관투자자 및 애널리스트를 초대해 2020년 성과 및 2021년 중점 추진 전략을 공유하는 자리를 마련했다.\n" +
                    "</p>\n" +
                    "<p>\n" +
                    "\t2020년 연간 경영실적 및 2021년 중점 추진 전략 발표 후, Q&amp;A 세션에서는 현대캐피탈의 해외 커버리지(Coverage) 확대 방향성, 리스크(risk) 관리 방향성, 사업 전략 등에 대한 실시간 질의 응답 시간을 통해 투자자들의 궁금증을 해소했다. 경영환경 악화 우려 속에서도 기대 이상의 실적을 달성한 당사 현황을 투자자에게 충분히 알리고, 시장 내 우려 사항을 직접 듣는 소통의 자리였다.\n" +
                    "</p>\n" +
                    "<img src=\"https://newsroom.hcs.com/common/file/7928aa44d37f4912b07ec4dd8e052358/png/getImg.do\">\n" +
                    "<p>\n" +
                    "\t현대카드 관계자는 “국내 여신전문금융사 중 유일한 대규모 실적 발표회 행사였다”며 “비대면 방식이었기 때문에 참석 인원에 제한이 없어 오히려 대면 행사 때보다 더 많은 인원이 참석했다”고 말했다.\n" +
                    "</p>\n" +
                    "<p>\n" +
                    "\t행사에 참가한 한 투자자는 “많은 투자자들이 현대카드가 회사의 실적과 전략 방향성에 적극적으로 설명하고 투자자의 질문에 여유 있게 대답하는 모습을 인상깊게 봤다”며 “오프라인 공간에 함께 모여 있을 수 없다는 한계를 극복하고 전보다 투명하고 적극적으로 커뮤니케이션 하려고 애쓰는 모습을 보고 현대카드에 대한 신뢰가 더 커졌다”고 말했다.\n" +
                    "</p>\n" +
                    "<div class=\"img_txt_box reverse \">\n" +
                    "\t<div class=\"txt_box\">\n" +
                    "\t\t<p>\n" +
                    "\t\t\t비대면 방식 인턴채용은 지원자의 화상면접 몰입도를 최대한 높이고, 긍정적인 경험을 제공할 수 있도록 오프라인 면접과 같이 온라인 공간에도 대기실을 마련해 호평을 받았다.\n" +
                    "\t\t</p>\n" +
                    "\t\t<p>\n" +
                    "\t\t\t면접 진행 시 발생할 수 있는 기술적인 이슈를 방지하고 지원자가 충분히 온라인 면접 환경에 적응할 수 있도록 배려한 것이다. 면접에 참여했던 한 인턴은 “온라인 대기실 덕분에 면접에 앞서 긴장도 풀고 처음 사용해보는 화상장비들이 잘 작동되는지에 대한 불안도 덜 수 있어서 좋았다”며 덕분에 면접에 집중하고 준비한 모든 것을 면접관들에게 잘 보여줄 수 있었다”고 말했다.\n" +
                    "\t\t</p>\n" +
                    "\t\t<p>\n" +
                    "\t\t\t인턴채용 담당부서에서도 화상면접을 통한 인턴 선발에 대한 만족도가 높았다. 현대카드 인재 모집 담당자는 “포스트 코로나 시대에 일하는 방식 만큼이나 발빠르게 인재 모집의 방식을 바꾸길 참 잘했다는 생각이 든다고”고 말했다.\n" +
                    "\t\t</p>\n" +
                    "\t</div>\n" +
                    "\t<div class=\"img_box\">\n" +
                    "\t\t<img src=\"https://newsroom.hcs.com/common/file/f920a16e0f574baba128de70abe90417/png/getImg.do\">\n" +
                    "\t\t<p class=\"img_desc\">\n" +
                    "\t\t\t인턴선발 과정에서 현대카드 인사 담당자들이 화상으로 면접을 진행하는 모습\n" +
                    "\t\t</p>\n" +
                    "\t</div>\n" +
                    "</div>\n" +
                    "<p class=\"article_tit\">\n" +
                    "\t직원들의 편의 위한 비대면 프로그램도 지속적으로 업그레이드\n" +
                    "</p>\n" +
                    "<p>\n" +
                    "\t현대카드는 코로나19로 인한 불안감과 불편을 최소화할 수 있도록 비대면 프로그램 영역을 확장하고 있다. 홈 트레이닝 프로그램인 ‘온라인 핏 캠프(Online Fit Camp)’가 대표적인 예이다. 온라인 핏 캠프는 사내 운동 시설에서 운동할 수 없는 코로나19 시대에 현대카드가 마련한 운동 프로그램이다. 기존에는 점심 요가와 저녁 스트레칭 프로그램만 운영해 왔지만 지난달 중순부터는 낮에는 요가와 필라테스, 저녁에는 파워짐, 태보, 두서킷 등 요일 별 프로그램을 선택해 참여할 수 있도록 업그레이드 했다. 온라인 핏 캠프 운영 담당자는 “원하는 시간에 직원 상황에 맞게 어디서든지 자유로운 운동이 가능하도록 했고, 온라인으로 진행되는 만큼 가족들도 함께 참여할 수 있다”고 말했다.\n" +
                    "</p>\n" +
                    "<img src=\"https://newsroom.hcs.com/common/file/cf8831595e9842e5822d6c1daf7ce603/png/getImg.do\">\n" +
                    "<p class=\"img_desc\">\n" +
                    "\t온라인 핏 캠프 프로그램을 통해 요가를 하고 있는 모습\n" +
                    "</p>\n" +
                    "<p>\n" +
                    "\t사내 진료 시설인 ‘더 클리닉(the Clinic)’의 원격 진료도 시작했다. 최근 ‘감염병 예방법’ 개정으로 코로나19 상황 하에서 한시적 비대면 진료가 가능해짐에 따라 더 클리닉에서 화상회의 프로그램과 전화를 이용해 진료를 받을 수 있게 한 것. 코로나19 때문에 병원 방문을 망설였던 직원이나, 재택 근무 중이라 병원에 방문하기 어려운 직원이 집에서도 편안하게 진료를 받을 수 있게 했다. 또한 거점에서 근무하며 클리닉 진료 서비스를 경험하지 못했던 직원도 진료가 가능하다. 조원주 더 클리닉 원장은 “비대면 진료는 이미 진단이 내려져 장기적인 치료 전략에 따라 정기 추적을 하는 만성 질환을 가진 환자에게 적합한 방식이지만 최근에는 다양한 방식으로 진화하고 있다”며 “전화 상담의 경우 장소의 제약이 적고 빠르게 상담에 집중할 수 있고, 특히 화상회의 시스템을 이용하는 경우 자료공유 기능을 통해 검진 결과나 교육자료를 보면서 설명할 수 있다는 장점이 있다”고 설명했다.\n" +
                    "</p>");
            itemList.add(item);
        }
        channel.setItems(itemList);
        rss.setChannel(channel);

        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(response.getOutputStream());
            new XMLOutputter().output(RssBuilder.builder(rss), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }


/*// 1. Document 생성
        Document doc = new Document();

        Namespace namespace = Namespace.getNamespace("content", "http://purl.org/rss/1.0/modules/content/");
// 2. Root Element 생성
        Element root = new Element("rss");
        root.addNamespaceDeclaration(namespace);
        root.setAttribute("version", "2.0");
        doc.setContent(root);

// 3. Child Element 생성
        Element records = new Element("records");
        records.setNamespace(namespace);
        root.addContent(records);

        for( int i = 1; i <= 5; i++ ) {
            Element record = new Element("record");
            record.addContent(new CDATA("<그대로 출력되는 문자열>"));
            records.addContent(record);
        }

// 4. 파일에 출력
        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(response.getOutputStream());
            new XMLOutputter().output(doc, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

// 5. 문자열 출력 (Default Format : Format.getCompactFormat())
        String xml = new XMLOutputter().outputString(doc);
        System.out.println(xml);

// 6. 출력 포맷결정
// 6-1. XML형식 이쁜 포맷
        xml = new XMLOutputter(Format.getPrettyFormat()).outputString(doc);
        System.out.println(xml);

// 6-2. 단순한 문자열 포맷
        xml = new XMLOutputter(Format.getCompactFormat()) {
            @Override
            public void printDeclaration(Writer out, Document doc, String encoding) throws IOException {
                out.write("<!--?xml version=\"1.0\" encoding=\"" + encoding + "\"?-->");
            }
        }.outputString(doc);
        System.out.println(xml);

// 7. XML 인코딩을 변경하고 싶으면
        Format.getCompactFormat().setEncoding("UTF-8");*/
    }
}
