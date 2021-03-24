package kr.co.youngyoung.goldnawa.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class DefaultCommonDomain implements Serializable {

    @JsonIgnore
    private HttpStatus httpStatusCd;

    @JsonIgnore
    private ResultStatusCd resultStatusCd;

    @JsonIgnore
    private String searchStartDate;

    @JsonIgnore
    private String searchEndDate;
}
