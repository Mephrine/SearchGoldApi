package kr.co.youngyoung.goldnawa.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.co.youngyoung.goldnawa.core.domain.DefaultCommonDomain;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@ApiModel
@Alias("goldPriceDomain")
@Data
public class GoldPriceDomain extends DefaultCommonDomain{
    @ApiModelProperty(value = "금, 백금, 은")
    private String jewelryType;

    @ApiModelProperty(value = "금, 백금, 은")
    private String jewelryTypeNm;

    @ApiModelProperty(value = "시세 날자")
    private String goldDate;

    @ApiModelProperty(value = "순도")
    private String goldPurity;

    @ApiModelProperty(value = "살때, 팔때")
    private String goldPriceType;

    @ApiModelProperty(value = "기간 최소 가격")
    private String minGoldPrice;

    @ApiModelProperty(value = "기간 최대 가격")
    private String maxGoldPrice;

    @ApiModelProperty(value = "기간 평균 가격(반올림)")
    private String avgGoldPrice;

    @ApiModelProperty(value = "국가코드")
    private String counytryCode;

    @ApiModelProperty(value = "통화")
    private String goldCurrency;

    @ApiModelProperty(value = "기간")
    private String period;
}
