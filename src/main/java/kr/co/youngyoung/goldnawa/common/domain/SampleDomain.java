package kr.co.youngyoung.goldnawa.common.domain;

import kr.co.youngyoung.goldnawa.core.domain.DefaultCommonDomain;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("SampleDomain")
@Data
public class SampleDomain extends DefaultCommonDomain{
    String test;
}
