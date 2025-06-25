package com.firstclub.membership.plan;

import java.math.BigDecimal;
import java.time.Duration;

public final class YearlyPlan implements Plan {

    private static final BigDecimal PRICE = new BigDecimal("1799");
    private static final Duration PERIOD = Duration.ofDays(365);

    @Override
    public PlanCode getCode() {
        return PlanCode.YEARLY;
    }

    @Override
    public BigDecimal getPrice() {
        return PRICE;
    }

    @Override
    public Duration getPeriod() {
        return PERIOD;
    }
}
