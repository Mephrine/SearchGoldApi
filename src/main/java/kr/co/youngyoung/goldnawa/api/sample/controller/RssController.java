package kr.co.youngyoung.goldnawa.api.sample.controller;


import io.swagger.annotations.ApiOperation;
import kr.co.youngyoung.goldnawa.api.sample.service.SampleService;
import kr.co.youngyoung.goldnawa.common.rss.util.RssWriter;
import kr.co.youngyoung.goldnawa.core.controller.BaseController;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RssController extends BaseController {
    @Autowired
    SampleService sampleService;

    @Value("${spring.profiles}")
    String profile;

    @GetMapping(path = "/rss/pressRelease")
    public void pressRelease(HttpServletRequest request, HttpServletResponse response) throws IOException, JDOMException {
        String path = "";
        if( "local".equals(profile) ){
            path = "C:\\workspace\\newsroom-front\\web\\WebContent\\UPLOAD\\RSS\\RssPressRelease.xml";
        }else{
            path = "/home/devrartes/RssPressRelease.xml";
        }

        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(path);

        RssWriter.responseStreamWriter(doc, response);
    }

    @GetMapping(path = "/rss/ourStory")
    public void rssOurStory(HttpServletRequest request, HttpServletResponse response) throws IOException, JDOMException {
        String path = "";
        if( "local".equals(profile) ){
            path = "C:\\workspace\\newsroom-front\\web\\WebContent\\UPLOAD\\RSS\\RssOurStory.xml";
        }else{
            path = "/home/devrartes/RssPressRelease.xml";
        }

        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(path);

        RssWriter.responseStreamWriter(doc, response);
    }

    @GetMapping(path = "/rss/trendInsight")
    public void trendInsight(HttpServletRequest request, HttpServletResponse response) throws IOException, JDOMException {
        String path = "";
        if( "local".equals(profile) ){
            path = "C:\\workspace\\newsroom-front\\web\\WebContent\\UPLOAD\\RSS\\RssTrendInsight.xml";
        }else{
            path = "/home/devrartes/RssPressRelease.xml";
        }

        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(path);

        RssWriter.responseStreamWriter(doc, response);
    }
}
