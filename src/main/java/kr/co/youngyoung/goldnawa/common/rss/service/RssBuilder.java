package kr.co.youngyoung.goldnawa.common.rss.service;

import kr.co.youngyoung.goldnawa.common.rss.domain.Channel;
import kr.co.youngyoung.goldnawa.common.rss.domain.Guid;
import kr.co.youngyoung.goldnawa.common.rss.domain.Item;
import kr.co.youngyoung.goldnawa.common.rss.domain.Rss;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jni.Local;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.co.youngyoung.goldnawa.common.rss.constant.RssConstant;

public class RssBuilder {
    static public Document builder(Rss rss) {
        Document doc = new Document();
        //네임스페이스 생성
        Namespace nsContent = Namespace.getNamespace(RssConstant.NS_CONTENT, RssConstant.NS_URL_CONTENT);
        Namespace nsDc = Namespace.getNamespace(RssConstant.NS_DC, RssConstant.NS_URL_DC);
        //RSS 생성
        Element rssEle = new Element(RssConstant.ELE_RSS);
        rssEle.addNamespaceDeclaration(nsContent);
        rssEle.addNamespaceDeclaration(nsDc);
        String version = rss.getVersion();
        rssEle.setAttribute(RssConstant.ATTR_VERSION, version);
        doc.setContent(rssEle);
        //채널 생성
        Channel channel = rss.getChannel();
        Element channelEle = new Element(RssConstant.ELE_CHANNEL);
        //타이틀 생성
        String title = channel.getTitle();
        if(!StringUtils.isEmpty(title)) {
            Element tmpEle = new Element(RssConstant.ELE_TITLE);
            tmpEle.addContent(new CDATA(title));
            channelEle.addContent(tmpEle);
        }
        //링크 생성
        String link = channel.getLink();
        if(!StringUtils.isEmpty(link)){
            Element tmpEle = new Element(RssConstant.ELE_LINK);
            tmpEle.addContent(link);
            channelEle.addContent(tmpEle);
        }
        //디스크립션 생성
        String description = channel.getDescription();
        if(!StringUtils.isEmpty(description)) {
            Element tmpEle = new Element(RssConstant.ELE_DESCRIPTION);
            tmpEle.addContent(new CDATA(description));
            channelEle.addContent(tmpEle);
        }
        //출간일 생성 (Friday, April 2, 2021 at 5:36:16 PM Korean Standard Time)
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US);
        Date pubDate = channel.getPubDate();
        if(pubDate != null){
            Element tmpEle = new Element(RssConstant.ELE_PUBDATE);
            tmpEle.addContent(formatter.format(pubDate));
            channelEle.addContent(tmpEle);
        }
        //저자 생성
        String generator = channel.getGenerator();
        if(!StringUtils.isEmpty(generator)) {
            Element tmpEle = new Element(RssConstant.ELE_GENERATOR);
            tmpEle.addContent(new CDATA(generator));
            channelEle.addContent(tmpEle);
        }
        // ITEM 생성
        List<Item> items = channel.getItems();
        for (Item item: items) {
            Element itemELe = new Element(RssConstant.ELE_ITEM);
            //타이틀 생성
            String itemTitle = item.getTitle();
            if(!StringUtils.isEmpty(itemTitle)) {
                Element tmpEle = new Element(RssConstant.ELE_TITLE);
                tmpEle.addContent(new CDATA(itemTitle));
                itemELe.addContent(tmpEle);
            }
            //저자 생성
            if(!StringUtils.isEmpty(generator)) {
                Element tmpEle = new Element(RssConstant.ELE_CREATOR);
                tmpEle.setNamespace(nsDc);
                tmpEle.addContent(new CDATA(generator));
                itemELe.addContent(tmpEle);
            }
            //카테고리 생성
            List<String> itemCategories = item.getCategories();
            for(String category: itemCategories){
                Element tmpEle = new Element(RssConstant.ELE_CATEGORY);
                tmpEle.addContent(new CDATA(category));
                itemELe.addContent(tmpEle);
            }
            //링크 생성
            String itemLink = item.getLink();
            if(!StringUtils.isEmpty(itemLink)){
                Element tmpEle = new Element(RssConstant.ELE_LINK);
                tmpEle.addContent(itemLink);
                itemELe.addContent(tmpEle);
            }
            //디스크립션 생성
            String itemDescription = item.getDescription();
            if(!StringUtils.isEmpty(description)) {
                Element tmpEle = new Element(RssConstant.ELE_DESCRIPTION);
                tmpEle.addContent(new CDATA(itemDescription));
                itemELe.addContent(tmpEle);
            }
            //컨텐츠 생성
            String itemContent = item.getContent();
            if(!StringUtils.isEmpty(itemContent)) {
                Element tmpEle = new Element(RssConstant.ELE_ENCODED);
                tmpEle.setNamespace(nsContent);
                tmpEle.addContent(new CDATA(itemContent));
                itemELe.addContent(tmpEle);
            }
            //출간일 생성 (Friday, April 2, 2021 at 5:36:16 PM Korean Standard Time)
            Date ItemPubDate = item.getPubDate();
            if(ItemPubDate != null){
                Element tmpEle = new Element(RssConstant.ELE_PUBDATE);
                tmpEle.addContent(formatter.format(ItemPubDate));
                itemELe.addContent(tmpEle);
            }
            //GUID 생성
            Guid itemGuid = item.getGuid();
            if(itemGuid != null){
                Element tmpEle = new Element(RssConstant.ELE_GUID);
                tmpEle.setAttribute(RssConstant.ATTR_ISPERMALINK, itemGuid.isPermaLink());
                tmpEle.addContent(itemGuid.getValue());
                itemELe.addContent(tmpEle);
            }

            channelEle.addContent(itemELe);
        }

        rssEle.addContent(channelEle);

        return doc;
    }
}