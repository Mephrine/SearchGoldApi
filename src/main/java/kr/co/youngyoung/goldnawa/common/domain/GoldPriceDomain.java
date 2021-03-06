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
    private int useYn;

    @ApiModelProperty(value = "테스트")
    private int displayYn;

    @ApiModelProperty(value = "테스트")
    private int jewelryType;

    @ApiModelProperty(value = "테스트")
    private int goldDate;

    @ApiModelProperty(value = "테스트")
    private int goldPurity;

    @ApiModelProperty(value = "테스트")
    private int goldPriceType;

    @ApiModelProperty(value = "테스트")
    private int goldPrice;

    @ApiModelProperty(value = "테스트")
    private int counytryCode;

    @ApiModelProperty(value = "테스트")
    private int goldCurrency;
}
