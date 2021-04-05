package kr.co.youngyoung.goldnawa.common.rss.domain;

import kr.co.youngyoung.goldnawa.common.rss.variable.UpdatePeriod;
import lombok.Data;

@Data
public class Syndication {
    UpdatePeriod updatePeriod;
    int updateFrequency;
    String updateBase;
}
