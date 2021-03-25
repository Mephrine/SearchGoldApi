package kr.co.youngyoung.goldnawa.api.price.service;

import kr.co.youngyoung.goldnawa.common.domain.GoldPriceDomain;
import kr.co.youngyoung.goldnawa.common.domain.GoldPriceParameterDomain;
import kr.co.youngyoung.goldnawa.core.code.service.SimpleCommonCodeService;
import kr.co.youngyoung.goldnawa.core.domain.ApiResponseObject;
import kr.co.youngyoung.goldnawa.core.domain.ResultStatusCd;
import kr.co.youngyoung.goldnawa.core.mybatis.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GoldPriceHistoryService extends BaseDao<GoldPriceDomain, GoldPriceParameterDomain> {
    @Autowired
    SimpleCommonCodeService cacheCommonCodeService;
    @Autowired
    SimpleCommonCodeService dataBaseCommonCodeService;

    public GoldPriceHistoryService(){
        super("goldPriceHistory");
    }

    public ApiResponseObject<List<GoldPriceDomain>> getGoldPriceHistory() {
        setHttpStatus(HttpStatus.OK);
        setResultStatusCd(ResultStatusCd.SUCCESS);

        return ApiResponseObject
                .data(databaseDao.selectList(getNameSpace()))
                .httpStatusCd(getHttpStatus())
                .resultStatus(getResultStatusCd())
                .build();
    }

    public ApiResponseObject<List<GoldPriceDomain>> getGoldPriceHistoryDetail(GoldPriceParameterDomain goldPriceParameterDomain) {
        //귀금속 설정
        String item = goldPriceParameterDomain.getItem();
        String jewrlyType;
        jewrlyType = "gold".equals(item)?"GOLD":"platinum".equals(item)?"PLATINUM":"silver".equals(item)?"SILVER":"";
        goldPriceParameterDomain.setJewelryType(jewrlyType);
        //기간구분 설정
        String period = goldPriceParameterDomain.getPeriod();
        String dateType;
        dateType = "daily".equals(period)?"day":"monthly".equals(period)?"month":"yearly".equals(period)?"year":"recent".equals(period)?"day":"";
        goldPriceParameterDomain.setDateType(dateType);
        //조회날자 설정
        int DateLength;
        DateLength = "daily".equals(period)?90:"monthly".equals(period)?24:"yearly".equals(period)?5:"recent".equals(period)?3:0;
        goldPriceParameterDomain.setDateLength(DateLength);
        //조회시작날자 설정
        String searchDateType = "";
        String searchStartDate = goldPriceParameterDomain.getSearchStartDate();
        searchStartDate = "".equals(searchStartDate)?LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")):searchStartDate;
        searchStartDate = "daily".equals(period)?searchStartDate:"monthly".equals(period)?searchStartDate.substring(0, 7):"yearly".equals(period)?searchStartDate.substring(0, 4):"recent".equals(period)?searchStartDate:"";
        searchDateType = "daily".equals(period)?"YYYY-MM-DD":"monthly".equals(period)?"YYYY-MM":"yearly".equals(period)?"YYYY":"recent".equals(period)?"YYYY-MM-DD":"";
        goldPriceParameterDomain.setSearchStartDate(searchStartDate);
        goldPriceParameterDomain.setSearchDateType(searchDateType);
        //거래 설정
        String method = goldPriceParameterDomain.getMethod();
        String goldPriceType;
        goldPriceType = "buy".equals(method)?"B":"sell".equals(method)?"S":"";
        goldPriceParameterDomain.setGoldPriceType(goldPriceType);

        setHttpStatus(HttpStatus.OK);
        setResultStatusCd(ResultStatusCd.SUCCESS);
        //코드화
        List<GoldPriceDomain> goldPriceDomainList = databaseDao.selectList(getNameSpace(), "Detail", goldPriceParameterDomain);
        goldPriceDomainList.stream().forEach(c -> {
            c.setJewelryTypeNm(cacheCommonCodeService.getOne("ROOT.JEWELRY_TYPE."+c.getJewelryType()).getCodeValue());
            c.setGoldPurityNm(cacheCommonCodeService.getOne("ROOT.PURITY."+c.getGoldPurity()).getCodeValue());
            c.setGoldCurrencyNm(cacheCommonCodeService.getOne("ROOT.CURRENCY."+c.getGoldCurrency()).getCodeValue());
            c.setCountryCodeNm(cacheCommonCodeService.getOne("ROOT.COUNTRY_CODE."+c.getCountryCode()).getCodeValue());
        });

        return ApiResponseObject
                .data(goldPriceDomainList)
                .httpStatusCd(getHttpStatus())
                .resultStatus(getResultStatusCd())
                .build();
    }
}