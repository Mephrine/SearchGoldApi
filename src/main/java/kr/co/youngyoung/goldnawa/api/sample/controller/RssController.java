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

    @GetMapping(path = "/rss")
    @ApiOperation(value = "샘플 매핑",
            notes = "이것은 샘플 매핑입니다")
    public void sample(HttpServletRequest request, HttpServletResponse response) throws IOException, JDOMException {
        String path = "";
        if( "local".equals(profile) ){
            path = "C:\\workspace\\newsroom-front\\web\\WebContent\\UPLOAD\\RSS\\RssPressRelease.xml";
        }else{
            path = "/home/devrartes/RssPressRelease.xml";
        }


        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(path);

        RssWriter.responseStreamWriter(doc, response);
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
