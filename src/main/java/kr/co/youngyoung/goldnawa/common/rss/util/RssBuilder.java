package kr.co.youngyoung.goldnawa.common.rss.util;

import kr.co.youngyoung.goldnawa.common.rss.domain.Channel;
import kr.co.youngyoung.goldnawa.common.rss.domain.Guid;
import kr.co.youngyoung.goldnawa.common.rss.domain.Item;
import kr.co.youngyoung.goldnawa.common.rss.domain.Rss;
import kr.co.youngyoung.goldnawa.common.rss.domain.Syndication;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.co.youngyoung.goldnawa.common.rss.variable.NodeConstant;

public class RssBuilder {
    static public Document builder(Rss rss) {
        Document doc = new Document();
        //네임스페이스 생성
        Namespace nsContent = Namespace.getNamespace(NodeConstant.NS_CONTENT, NodeConstant.NS_URL_CONTENT);
        Namespace nsSy = Namespace.getNamespace(NodeConstant.NS_SYNDICATION, NodeConstant.NS_URL_SYNDICATION);
        Namespace nsDc = Namespace.getNamespace(NodeConstant.NS_DC, NodeConstant.NS_URL_DC);
        //RSS 생성
        Element rssEle = new Element(NodeConstant.ELE_RSS);
        rssEle.addNamespaceDeclaration(nsContent);
        rssEle.addNamespaceDeclaration(nsDc);
        rssEle.addNamespaceDeclaration(nsSy);
        //버전 정보 체크
        String version = rss.getVersion();
        if( RssUtils.isEmpty(version) ) throw new RuntimeException("Version information is required");
        rssEle.setAttribute(NodeConstant.ATTR_VERSION, version);
        doc.setContent(rssEle);
        //채널 생성
        Channel channel = rss.getChannel();
        Element channelEle = new Element(NodeConstant.ELE_CHANNEL);
        //타이틀 생성
        String title = channel.getTitle();
        if(!RssUtils.isEmpty(title)) {
            Element tmpEle = new Element(NodeConstant.ELE_TITLE);
            tmpEle.addContent(new CDATA(title));
            channelEle.addContent(tmpEle);
        }
        //링크 생성
        String link = channel.getLink();
        if(!RssUtils.isEmpty(link)){
            Element tmpEle = new Element(NodeConstant.ELE_LINK);
            tmpEle.addContent(link);
            channelEle.addContent(tmpEle);
        }
        //디스크립션 생성
        String description = channel.getDescription();
        if(!RssUtils.isEmpty(description)) {
            Element tmpEle = new Element(NodeConstant.ELE_DESCRIPTION);
            tmpEle.addContent(new CDATA(description));
            channelEle.addContent(tmpEle);
        }
        //출간일 생성 (Friday, April 2, 2021 at 5:36:16 PM Korean Standard Time)
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US);
        Date pubDate = channel.getPubDate();
        if(pubDate != null){
            Element tmpEle = new Element(NodeConstant.ELE_PUBDATE);
            tmpEle.addContent(formatter.format(pubDate));
            channelEle.addContent(tmpEle);
        }
        //저자 생성
        String generator = channel.getGenerator();
        if(!RssUtils.isEmpty(generator)) {
            Element tmpEle = new Element(NodeConstant.ELE_GENERATOR);
            tmpEle.addContent(new CDATA(generator));
            channelEle.addContent(tmpEle);
        }
        //업데이트 주기 생성
        Syndication syndication = channel.getSyndication();
        if(!RssUtils.isNull(syndication)) {
            Element tmpEle = new Element(NodeConstant.ELE_UPDATEPERIOD);
            tmpEle.setNamespace(nsSy);
            tmpEle.addContent(syndication.getUpdatePeriod().updatePeriod());
            channelEle.addContent(tmpEle);
        }
        if(!RssUtils.isNull(syndication)) {
            Element tmpEle = new Element(NodeConstant.ELE_UPDATEFREQUENCY);
            tmpEle.setNamespace(nsSy);
            tmpEle.addContent(Integer.toString(syndication.getUpdateFrequency()));
            channelEle.addContent(tmpEle);
        }
        //언어 설정
        Locale language = channel.getLanguage();
        if(!RssUtils.isNull(language)) {
            Element tmpEle = new Element(NodeConstant.ELE_LANGUAGE);
            tmpEle.addContent(language.getDefault().toString());
            channelEle.addContent(tmpEle);
        }
        // ITEM 생성
        List<Item> items = channel.getItems();
        for (Item item: items) {
            Element itemELe = new Element(NodeConstant.ELE_ITEM);
            //타이틀 생성
            String itemTitle = item.getTitle();
            if(!RssUtils.isEmpty(itemTitle)) {
                Element tmpEle = new Element(NodeConstant.ELE_TITLE);
                tmpEle.addContent(new CDATA(itemTitle));
                itemELe.addContent(tmpEle);
            }
            //저자 생성
            if(!RssUtils.isEmpty(generator)) {
                Element tmpEle = new Element(NodeConstant.ELE_CREATOR);
                tmpEle.setNamespace(nsDc);
                tmpEle.addContent(new CDATA(generator));
                itemELe.addContent(tmpEle);
            }
            //카테고리 생성
            List<String> itemCategories = item.getCategories();
            for(String category: itemCategories) {
                Element tmpEle = new Element(NodeConstant.ELE_CATEGORY);
                tmpEle.addContent(new CDATA(category));
                itemELe.addContent(tmpEle);
            }
            //링크 생성
            String itemLink = item.getLink();
            if(!RssUtils.isEmpty(itemLink)) {
                Element tmpEle = new Element(NodeConstant.ELE_LINK);
                tmpEle.addContent(itemLink);
                itemELe.addContent(tmpEle);
            }
            //디스크립션 생성
            String itemDescription = item.getDescription();
            if(!RssUtils.isEmpty(description)) {
                Element tmpEle = new Element(NodeConstant.ELE_DESCRIPTION);
                tmpEle.addContent(new CDATA(itemDescription));
                itemELe.addContent(tmpEle);
            }
            //컨텐츠 생성
            String itemContent = item.getContent();
            if(!RssUtils.isEmpty(itemContent)) {
                Element tmpEle = new Element(NodeConstant.ELE_ENCODED);
                tmpEle.setNamespace(nsContent);
                tmpEle.addContent(new CDATA(itemContent));
                itemELe.addContent(tmpEle);
            }
            //출간일 생성 (Friday, April 2, 2021 at 5:36:16 PM Korean Standard Time)
            Date ItemPubDate = item.getPubDate();
            if(ItemPubDate != null) {
                Element tmpEle = new Element(NodeConstant.ELE_PUBDATE);
                tmpEle.addContent(formatter.format(ItemPubDate));
                itemELe.addContent(tmpEle);
            }
            //GUID 생성
            Guid itemGuid = item.getGuid();
            if(itemGuid != null) {
                Element tmpEle = new Element(NodeConstant.ELE_GUID);
                tmpEle.setAttribute(NodeConstant.ATTR_ISPERMALINK, itemGuid.isPermaLink());
                tmpEle.addContent(itemGuid.getValue());
                itemELe.addContent(tmpEle);
            }

            channelEle.addContent(itemELe);
        }

        rssEle.addContent(channelEle);

        return doc;
    }

    /**
    * RSS 빌드에 필요한 유틸 이너클래스
    * */
    private static class RssUtils {
        /**
         * 스트링 오브젝트 빈값 체크
         */
        static public boolean isEmpty(String str) {
            boolean isEmpty = false;

            if("".equals(str) || null == str) {
                isEmpty = true;
            }

            return isEmpty;
        }

        /**
         * 오브젝트 빈값 체크
         */
        static public boolean isNull(Object obj){
            boolean isNull = false;

            if(null == obj) {
                isNull = true;
            }

            return isNull;
        }
    }
}