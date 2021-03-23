package kr.co.youngyoung.goldnawa.core.code.repository;

import kr.co.youngyoung.goldnawa.core.code.domain.CommonCodeDomain;

import java.util.List;

public interface SimpleCommonCodeRepository {
    String NAMESPACE = "commonCode";

    List<CommonCodeDomain> getCommonCodeList();
}
