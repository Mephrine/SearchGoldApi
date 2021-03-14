package kr.co.youngyoung.goldnawa.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.co.youngyoung.goldnawa.core.domain.DefaultCommonDomain;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@ApiModel
@Alias("youtubeListDomain")
@Data
public class YoutubeListDomain extends DefaultCommonDomain {
    
    @ApiModelProperty(value = "유투브 리스트 시퀀스")
    private int youtubeListSeq;
    private String youtubeTitle;
    private String youtubeSubTitle;
    private String youtubeUrl;
    private String thumbImgUrl;
}
