package kr.co.youngyoung.goldnawa.common.rss.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Data
public class Channel {
    private String title;
    private String link;
    private String description;
    private String generator;
    private Date pubDate;
    private Locale language;
    private Syndication syndication;
    private List<Item> items;
}
