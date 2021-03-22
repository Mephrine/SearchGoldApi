package kr.co.youngyoung.goldnawa.core.code.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import springfox.documentation.annotations.ApiIgnore;

/**
 * API 서비스에서 사용되는 코드들의 도메인
 * */
@Data
@Alias("commonCodeDomain")
@ApiIgnore
public class CommonCodeDomain {
    //코드
    @JsonIgnore
    String code;
    //상위코드
    @JsonIgnore
    String upperCode;
    //코드뎁스
    @JsonIgnore
    int codeDepth;
    //코드키
    @JsonIgnore
    String codeKey;
    //코드값
    @JsonIgnore
    String cokeValue;
    //코드설명
    @JsonIgnore
    String codeDesc;
    //정렬순서
    @JsonIgnore
    String sortOrder;
}
