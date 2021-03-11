package kr.co.youngyoung.goldnawa.core.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.co.youngyoung.goldnawa.common.domain.AppVersionDomain;
import lombok.Data;
import org.springframework.cglib.beans.BulkBean;
import org.springframework.http.HttpStatus;


@Data
@ApiModel
public class ApiResponseObject<T> {
    @ApiModelProperty(value = "데이터")
    private T data;
    
    @ApiModelProperty(value = "HTTP 코드")
    private int httpStatusCd;
    
    @ApiModelProperty(value = "결과 코드")
    private int resultStatusCd;

    public ApiResponseObject(Builder<T> builder) {
        this.data = builder.data;
        this.httpStatusCd = builder.httpStatusCd;
        this.resultStatusCd = builder.resultStatusCd;
    }

    public static <T> Builder<T> data(T data) {
        return new Builder(data);
    }

    public static class Builder<T> {
        private T data;
        private int httpStatusCd;
        private int resultStatusCd;

        public Builder() { }

        public Builder(T data) {
            this.data = data;
        }

        public Builder<T> data(T data) {
            this.data = data;

            return this;
        }

        public Builder<T> httpStatusCd(HttpStatus httpStatusCd) {
            this.httpStatusCd = httpStatusCd.value();

            return this;
        }

        public Builder<T> resultStatus(ResultStatusCd resultStatusCd) {
            this.resultStatusCd = resultStatusCd.value();

            return this;
        }

        public ApiResponseObject<T> build() {
            return new ApiResponseObject<T>(this);
        }
    }
}
