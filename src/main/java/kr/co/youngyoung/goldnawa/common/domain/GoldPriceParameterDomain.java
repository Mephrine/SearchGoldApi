package kr.co.youngyoung.goldnawa.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@ApiModel
@Alias("goldPriceParameterDomain")
@Data
public class GoldPriceParameterDomain {
    @ApiModelProperty(value = "품목", notes = "금, 백금, 다이아 설정 가능", allowableValues = "gold, platinum, diamond")
    private String item;
    
    @ApiModelProperty(value = "팔기/사기", notes = "팔고 사기 설정 가능", allowableValues = "buy, sell")
    private String method;

    @ApiModelProperty(value = "조회 주기", notes = "조회 주기 지정 가능", allowableValues = "daily, modthly, yearly")
    private String period;
}
