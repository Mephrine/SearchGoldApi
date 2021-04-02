package kr.co.youngyoung.goldnawa.common.rss.domain;

import lombok.Data;

@Data
public class Rss {
    private String version;
    private Channel channel;

    public Rss(String version) {
        this.version = version;
    }
}
