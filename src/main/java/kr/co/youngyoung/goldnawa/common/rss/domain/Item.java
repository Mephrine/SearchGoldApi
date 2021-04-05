package kr.co.youngyoung.goldnawa.common.rss.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Item {
    private String title;
    private String link;
    private String description;
    private String content;
    private Guid guid;
    private Date pubDate;
    private String author;
    private List<String> categories;
}
