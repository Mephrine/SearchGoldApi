package kr.co.youngyoung.goldnawa.common.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("SampleDomain")
@Data
public class SampleDomain{
    String test;
}
