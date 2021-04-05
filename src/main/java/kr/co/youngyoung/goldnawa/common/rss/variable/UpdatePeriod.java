package kr.co.youngyoung.goldnawa.common.rss.variable;

public enum UpdatePeriod {
    HOURLY("hourly"),
    DAILY("daily"),
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    YEARLY("yearly");

    private final String updatePeriod;

    UpdatePeriod(String updatePeriod){
        this.updatePeriod = updatePeriod;
    }

    public String updatePeriod() {
        return this.updatePeriod;
    }
}
