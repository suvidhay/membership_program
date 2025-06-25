package com.firstclub.membership.plan;

import java.math.BigDecimal;
import java.time.Duration;

public final class MonthlyPlan implements Plan {

    private static final BigDecimal PRICE = new BigDecimal("199");
    private static final Duration PERIOD = Duration.ofDays(30);

    @Override
    public PlanCode getCode() {
        return PlanCode.MONTHLY;
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
