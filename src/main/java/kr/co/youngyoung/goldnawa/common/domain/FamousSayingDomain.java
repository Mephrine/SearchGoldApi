package kr.co.youngyoung.goldnawa.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@ApiModel
@Alias("famousSayingDomain")
@Data
public class FamousSayingDomain {
    @ApiModelProperty(value = "시퀀스")
    private int famousSayingSeq;

    @ApiModelProperty(value = "명언")
    private String famousSaying;

    @ApiModelProperty(value = "위인")
    private String famousSayingWriter;
}