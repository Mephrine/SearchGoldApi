package kr.co.youngyoung.goldnawa.common.rss.domain;

import lombok.Data;

@Data
public class Guid {
    private boolean PermaLink;
    private String Value;

    public String isPermaLink() {
        return PermaLink?"true":"false";
    }
}
