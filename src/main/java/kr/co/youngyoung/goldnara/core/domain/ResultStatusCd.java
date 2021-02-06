package kr.co.youngyoung.goldnara.core.domain;

public enum ResultStatusCd {

    /*
     * 성공코드 반환
     * */
    SUCCESS(200, "Success"),
    /*
     * 타임아웃
     * */
    TIME_OUT(408, ""),
    /*
     * 내부 서버 오류
     * */
    INTERNAL_SERVER_SERROR(500, ""),
    /*
     * 기타 오류
     * */
    CRITICAL_ERROR(501, "");

    private final int value;

    private final String resposneMessage;

    ResultStatusCd(int value, String resposneMessage) {
        this.value = value;
        this.resposneMessage = resposneMessage;
    }

    public int value() {
        return this.value;
    }

    public String resposneMessage() {
        return this.resposneMessage;
    }
}
