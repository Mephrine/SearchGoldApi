package kr.co.youngyoung.goldnawa.core.code.service.impl;

import com.google.common.collect.Lists;
import kr.co.youngyoung.goldnawa.core.code.domain.CommonCodeDomain;
import kr.co.youngyoung.goldnawa.core.code.exception.CodeNotFoundException;
import kr.co.youngyoung.goldnawa.core.code.exception.IllegalCodeReturnException;
import kr.co.youngyoung.goldnawa.core.code.service.SimpleCommonCodeService;
import kr.co.youngyoung.goldnawa.core.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataBaseCommonCodeService implements SimpleCommonCodeService {
    @Autowired
    public MybatisService<CommonCodeDomain, CommonCodeDomain> databaseDao;

    private List<CommonCodeDomain> codeList;

    @Override
    public List<CommonCodeDomain> getList(String code){
        int depth = StringUtils.countOccurrencesOf(code, CODE_SEPARATOR)+1;
        String[] subCode = code.split(CODE_SEPARATOR);
        List<CommonCodeDomain> tmlCodeList = getCode();

        /*뎁스가 1인 경우*/
        for(int i = 1; i <= depth; i++) {
            int cDepth = i;
            tmlCodeList = getCode().stream().filter(c -> {
                return c.getCodeKey().equals(code) && c.getCodeDepth() == cDepth;
            }).collect(Collectors.toList());
        }

        /*if( tmlCodeList.size() == 0 ) {
            throw new CodeNotFoundException("code not founded");
        }*/

        return tmlCodeList;
    }

    @Override
    public CommonCodeDomain getOne(String code) {
        return getList(code).get(0);
    }

    @Override
    public void setCode() {
        this.codeList = databaseDao.selectList(NAMESPACE);
    }

    @Override
    public List<CommonCodeDomain> getCode() {
        setCode();
        return this.codeList;
    }
}
