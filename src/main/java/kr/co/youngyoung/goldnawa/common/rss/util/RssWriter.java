package kr.co.youngyoung.goldnawa.common.rss.util;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class RssWriter {

    /**
     * 해당 파일 패스 경로에 XML 파일 생성
     *
     * @param doc
     * @param filePath
     * @param fileName
     */
    static public void fileWriter(Document doc, String filePath, String fileName) {
        //폴더 생성
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //파일 생성
        try(FileOutputStream writer = new FileOutputStream(filePath+"/"+fileName)) {
            new XMLOutputter().output(doc, writer);
        } catch (FileNotFoundException fnfe) {
            throw new RuntimeException(fnfe.getMessage() + "\n" + "File Not Found.");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe.getMessage() + "\n" + "XML generation failed.");
        }
    }

    /**
     * HttpServletResponse의 OutputStream을 받아 reponse에 담음
     *
     * @param doc
     * @param response
     */
    static public void responseStreamWriter(Document doc, HttpServletResponse response) {
        try(OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream())) {
            new XMLOutputter().output(doc, writer);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage() + "\n" + "XML generation failed.");
        }
    }

    /**
     * HttpServletResponse의 OutputStream을 받아 reponse에 담음
     *
     * @param path
     * @param response
     */
    static public void responseStreamWriter(String path, HttpServletResponse response) {
        try(OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream())) {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(path);

            new XMLOutputter().output(doc, writer);
        } catch (IOException | JDOMException e) {
            throw new RuntimeException(e.getMessage() + "\n" + "XML generation failed.");
        }
    }

    /**
     * String으로 반환
     */
    static public String stringWriter(Document doc){
        return new XMLOutputter().outputString(doc);
    }

    /**
     * Pretty Format String으로 반환
     */
    static public String stringPrettyWriter(Document doc){
        return new XMLOutputter(Format.getPrettyFormat()).outputString(doc);
    }
}
