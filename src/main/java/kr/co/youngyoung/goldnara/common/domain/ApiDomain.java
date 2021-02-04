package kr.co.youngyoung.goldnara.common.domain;


import kr.co.youngyoung.goldnara.common.domain.value.ResultStatusCd;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ApiDomain<T> {
    private T data;
    private HttpStatus httpStatusCd;
    private ResultStatusCd resultStatusCd;

    public ApiDomain(Builder builder){
        this.data = (T)builder.data;
        this.httpStatusCd = builder.httpStatusCd;
        this.resultStatusCd = builder.resultStatusCd;
    }

    public static class Builder<T>{
        private T data;
        private HttpStatus httpStatusCd;
        private ResultStatusCd resultStatusCd;

        public Builder data(T data){
            this.data = data;

            return this;
        }

        public Builder httpStatusCd(HttpStatus httpStatusCd){
            this.httpStatusCd = httpStatusCd;

            return this;
        }

        public Builder resultStatus(ResultStatusCd resultStatusCd){
            this.resultStatusCd = resultStatusCd;

            return this;
        }

        public ApiDomain build(){
            return new ApiDomain(this);
        }
    }
}
