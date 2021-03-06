package kr.co.youngyoung.goldnawa.core.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@ApiModel
public class ApiResponseObject<T> {
    @ApiModelProperty(value = "데이터")
    private T data;
    
    @ApiModelProperty(value = "HTTP 코드")
    private HttpStatus httpStatusCd;
    
    @ApiModelProperty(value = "결과 코드")
    private ResultStatusCd resultStatusCd;

    public ApiResponseObject(Builder<T> builder) {
        this.data = builder.data;
        this.httpStatusCd = builder.httpStatusCd;
        this.resultStatusCd = builder.resultStatusCd;
    }

    public static class Builder<T> {
        private T data;
        private HttpStatus httpStatusCd;
        private ResultStatusCd resultStatusCd;

        public Builder<T> data(T data) {
            this.data = data;

            return this;
        }

        public Builder<T> httpStatusCd(HttpStatus httpStatusCd) {
            this.httpStatusCd = httpStatusCd;

            return this;
        }

        public Builder<T> resultStatus(ResultStatusCd resultStatusCd) {
            this.resultStatusCd = resultStatusCd;

            return this;
        }

        public ApiResponseObject<T> build() {
            return new ApiResponseObject<T>(this);
        }
    }
}
