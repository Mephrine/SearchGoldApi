package kr.co.youngyoung.goldnawa.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.co.youngyoung.goldnawa.core.domain.DefaultCommonDomain;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@ApiModel
@Alias("appVersionDomain")
@Data
public class AppVersionDomain {
    @ApiModelProperty(value = "버전 시퀀스")
    private int appVersionSeq;

    @ApiModelProperty(value = "버전")
    private String version;

    @ApiModelProperty(value = "버전 설명")
    private String versionDesc;
}
