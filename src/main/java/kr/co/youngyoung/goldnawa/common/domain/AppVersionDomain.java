package kr.co.youngyoung.goldnawa.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@ApiModel
@Alias("AppVersionDomain")
@Data
public class AppVersionDomain {
    @ApiModelProperty(value = "테스트")
    private int appVersionSeq;

    @ApiModelProperty(value = "테스트")
    private String version;

    @ApiModelProperty(value = "테스트")
    private String versionDesc;

    @ApiModelProperty(value = "테스트")
    private String useYn;

    @ApiModelProperty(value = "테스트")
    private String displayYn;

}
