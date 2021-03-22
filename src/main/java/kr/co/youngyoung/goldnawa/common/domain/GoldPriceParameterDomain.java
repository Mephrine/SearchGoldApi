package kr.co.youngyoung.goldnawa.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.co.youngyoung.goldnawa.core.domain.DefaultCommonDomain;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@ApiModel
@Alias("goldPriceParameterDomain")
@Data
public class GoldPriceParameterDomain extends DefaultCommonDomain {
    @ApiModelProperty(value = "품목", notes = "금, 백금, 실버 설정 가능", allowableValues = "gold, platinum, silver")
    private String item;
    
    @ApiModelProperty(value = "팔기/사기", notes = "팔고 사기 설정 가능", allowableValues = "buy, sell")
    private String method;

    @ApiModelProperty(value = "조회 주기", notes = "조회 주기 지정 가능", allowableValues = "daily, modthly, yearly")
    private String period;

    @JsonIgnore
    private String jewelryType;

    @JsonIgnore
    private String goldPriceType;

    @JsonIgnore
    private String dateType;

    @JsonIgnore
    private String searchDateType;

    @JsonIgnore
    private int dateLength;

    public GoldPriceParameterDomain() {
    }

    public GoldPriceParameterDomain(String item, String method, String period, String date) {
        setItem(item);
        setMethod(method);
        setPeriod(period);
        setSearchStartDate(date);
    }
}
