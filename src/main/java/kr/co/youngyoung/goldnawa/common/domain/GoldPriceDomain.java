package kr.co.youngyoung.goldnawa.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@ApiModel
@Alias("GoldPriceDomain")
@Data
public class GoldPriceDomain {
    @ApiModelProperty(value = "테스트")
    private int goldPriceSeq;

    @ApiModelProperty(value = "테스트")
    private String useYn;

    @ApiModelProperty(value = "테스트")
    private String displayYn;

    @ApiModelProperty(value = "테스트")
    private String jewelryType;

    @ApiModelProperty(value = "테스트")
    private String goldDate;

    @ApiModelProperty(value = "테스트")
    private String goldPurity;

    @ApiModelProperty(value = "테스트")
    private String goldPriceType;

    @ApiModelProperty(value = "테스트")
    private String goldPrice;

    @ApiModelProperty(value = "테스트")
    private String counytryCode;

    @ApiModelProperty(value = "테스트")
    private String goldCurrency;
}
