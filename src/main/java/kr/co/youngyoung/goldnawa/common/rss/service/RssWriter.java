package kr.co.youngyoung.goldnawa.common.rss.service;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RssWriter {
    /**
     * FilePath에 해당하는 XML 파일 생성
     * 
     * @param doc
     * @param filePath
     */
    static public void fileWriter(Document doc, String filePath) {
        try(FileOutputStream writer = new FileOutputStream(filePath)) {
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
