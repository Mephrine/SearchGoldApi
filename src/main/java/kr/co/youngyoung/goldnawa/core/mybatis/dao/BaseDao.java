package kr.co.youngyoung.goldnawa.core.mybatis.dao;

import kr.co.youngyoung.goldnawa.core.code.service.impl.DataBaseCommonCodeService;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import kr.co.youngyoung.goldnawa.core.mybatis.service.MybatisService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

/**
 * 데이터 처리 오브젝트
 * */
public class BaseDao<T, P> {
    @Autowired
    public MybatisService<T, P> databaseDao;
    @Getter
    @Setter
    private String nameSpace;
    @Getter
    @Setter
    private HttpStatus httpStatus;
    @Getter
    @Setter
    private ResultStatusCd resultStatusCd;

    public BaseDao(String nameSpace){
        this.nameSpace = nameSpace;
    }

}