package kr.co.youngyoung.goldnawa.core.code.service;

import kr.co.youngyoung.goldnawa.core.code.domain.CommonCodeDomain;
import kr.co.youngyoung.goldnawa.core.code.repository.SimpleCommonCodeRepository;

import java.util.List;

public interface SimpleCommonCodeService extends SimpleCommonCodeRepository {
    String CODE_SEPARATOR = ".";

    List<CommonCodeDomain> getList(String code);
    CommonCodeDomain getOne(String code);
}
