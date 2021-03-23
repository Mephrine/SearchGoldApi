package kr.co.youngyoung.goldnawa.core.code.service;

import com.google.common.collect.Lists;
import kr.co.youngyoung.goldnawa.core.code.domain.CommonCodeDomain;
import kr.co.youngyoung.goldnawa.core.code.exception.CodeNotFoundException;
import kr.co.youngyoung.goldnawa.core.code.exception.IllegalCodeReturnException;
import kr.co.youngyoung.goldnawa.core.code.repository.SimpleCommonCodeRepository;
import kr.co.youngyoung.goldnawa.core.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SimpleCommonCodeService extends SimpleCommonCodeRepository {
    String CODE_SEPARATOR = ".";

    List<CommonCodeDomain> getList(String code);
    CommonCodeDomain getOne(String code);
}
