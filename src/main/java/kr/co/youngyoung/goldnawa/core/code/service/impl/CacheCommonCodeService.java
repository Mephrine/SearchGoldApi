package kr.co.youngyoung.goldnawa.core.code.service.impl;

import kr.co.youngyoung.goldnawa.core.code.domain.CommonCodeDomain;
import kr.co.youngyoung.goldnawa.core.code.service.SimpleCommonCodeService;
import kr.co.youngyoung.goldnawa.core.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheCommonCodeService implements SimpleCommonCodeService {
    @Autowired
    public MybatisService<CommonCodeDomain, CommonCodeDomain> databaseDao;

    @Override
    public List<CommonCodeDomain> getList(String code) {
        return null;
    }

    @Override
    public CommonCodeDomain getOne(String code) {
        return null;
    }

    @Override
    public void setCode() {

    }

    @Override
    public List<CommonCodeDomain> getCode() {
        return null;
    }
}
