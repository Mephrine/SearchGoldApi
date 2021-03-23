package kr.co.youngyoung.goldnawa.core.code.service.impl;

import com.google.common.collect.Lists;
import kr.co.youngyoung.goldnawa.core.code.domain.CommonCodeDomain;
import kr.co.youngyoung.goldnawa.core.code.repository.SimpleCommonCodeRepository;
import kr.co.youngyoung.goldnawa.core.code.service.SimpleCommonCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CacheCommonCodeService implements SimpleCommonCodeService {
    @Autowired
    public SimpleCommonCodeRepository cacheCommonCodeRepository;

    @Override
    public List<CommonCodeDomain> getList(String codeKeyString){
        int cIndex = 0;
        String[] subCodeKey = codeKeyString.split("\\.");
        String upperCode = "";
        List<CommonCodeDomain> tmpCodeList;

        for(String s: subCodeKey){
            tmpCodeList = Lists.newArrayList();

            for(CommonCodeDomain c: getCommonCodeList()){
                if(cIndex == 0?
                        c.getCodeKey().equals(s):
                        c.getUpperCode().equals(upperCode) && c.getCodeKey().equals(s)) {
                    tmpCodeList.add(c);
                }
            }

            upperCode = tmpCodeList.get(0).getCode();
            cIndex++;
        }

        String finalUpperCode = upperCode;
        return getCommonCodeList().stream().filter(c -> c.getUpperCode().equals(finalUpperCode)).collect(Collectors.toList());
    }

    @Override
    public CommonCodeDomain getOne(String codeKeyString) {
        int cIndex = 0;
        String[] subCodeKey = codeKeyString.split("\\.");
        String upperCode = "";
        List<CommonCodeDomain> tmpCodeList = Lists.newArrayList();

        for(String s: subCodeKey){
            tmpCodeList = Lists.newArrayList();

            for(CommonCodeDomain c: getCommonCodeList()){
                if(cIndex == 0?
                        c.getCodeKey().equals(s):
                        c.getUpperCode().equals(upperCode) && c.getCodeKey().equals(s)) {
                    tmpCodeList.add(c);
                }
            }

            upperCode = tmpCodeList.get(0).getCode();
            cIndex++;
        }

        return tmpCodeList.get(0);
    }
    @Override
    public List<CommonCodeDomain> getCommonCodeList() {
        return cacheCommonCodeRepository.getCommonCodeList();
    }
}