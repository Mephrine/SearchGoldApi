package kr.co.youngyoung.goldnawa.core.code.service;

import com.google.common.collect.Lists;
import kr.co.youngyoung.goldnawa.core.code.domain.CommonCodeDomain;
import kr.co.youngyoung.goldnawa.core.code.exception.CodeNotFoundException;
import kr.co.youngyoung.goldnawa.core.code.exception.IllegalCodeReturnException;

import java.util.List;

public interface SimpleCommonCodeService {
    String NAMESPACE = "commonCode";
    String CODE_SEPARATOR = ".";
    String TOP_LEVEL_CODE = ".";

    List<CommonCodeDomain> getList(String code) throws CodeNotFoundException, IllegalCodeReturnException;
    CommonCodeDomain getOne(String code);
    void setCode();
    List<CommonCodeDomain> getCode();
}
